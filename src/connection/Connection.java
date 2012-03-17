package connection;

import connection.GetMessageAsVector;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {
	// handle for logging
	private static final Logger logger = Logger.getLogger("");

	private static final String SERVER_IP = null;

	private static final int SERVER_PORT = 0;

	// the active host name of the server
	private final String host;

	// Server TCP Port
	private final int port;

	// Network socket
	private Socket socket;

	// Outgoing data stream
	private DataOutputStream out;

	// Incoming data stream
	private DataInputStream in;

	// Last message received
	private String currentMessage;

	// True if connection is closed (after disconnection/error)
	private boolean shutDown;

	// true if we are currently connected to the server
	private boolean connected;

	/** the time when receive started (in ns) */
	private long startTime;

	public Vector<String> msgVector = new Vector<String>();

	/**
	 * Default constructor
	 */
	public Connection() {
		this(SERVER_IP, SERVER_PORT);
	}

	public Connection(String host, int port) {
		this.host = host;
		this.port = port;
		shutDown = false;
		connected = false;
	}

	/**
	 * Actually connect to the server
	 */
	public boolean establishConnection() {
		try {
			socket = new Socket(host, port);
			socket.setTcpNoDelay(true);

			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());

			System.out.println("Connection to: " + host + ":" + port);

			connected = true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		} catch (ConnectException e) {
			System.out
					.println(host
							+ ":"
							+ port
							+ " refused the connection. Is rcssserver3d running? Are you using an IPv6-enabled"
							+ " system and the host name translates to an IPv6 address?");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public void sendMessage(String msg) {
		logger.log(Level.FINEST, "sending: {0}", msg);
		msg = msg + "(syn)";
		byte[] body = msg.getBytes();

		// creation of the messages header (4 bytes)
		int len = body.length;
		int byte0 = (len >> 24) & 0xFF;
		int byte1 = (len >> 16) & 0xFF;
		int byte2 = (len >> 8) & 0xFF;
		int byte3 = len & 0xFF;

		try {
			out.writeByte((byte) byte0);
			out.writeByte((byte) byte1);
			out.writeByte((byte) byte2);
			out.writeByte((byte) byte3);
			out.write(body);
			out.flush();
		} catch (IOException e) {
			shutDown = true;
			System.out.println("Error writing to socket, shuting down...");
		}

		//System.out.println("Sent: " + msg);
	}

	public void startReceiveLoop() {
		while (!shutDown) {
			currentMessage = receiveMessage();
			startTime = System.nanoTime();

			logger.log(Level.FINER, "Received message from server");
			logger.log(Level.FINEST, "message: {0}", currentMessage);

			long end = System.nanoTime();
			logger.log(Level.FINE, "Message processed in (ns): "
					+ (end - startTime));
		}
		closeConnection();
		shutDown = false;
	}

	public void stopReceiveLoop() {
		shutDown = true;
	}

	/*
	 * Receive server message
	 */
	public String receiveMessage() {
		String msg;
		byte[] result;
		int length;

		try {
			int byte0 = in.read();
			int byte1 = in.read();
			int byte2 = in.read();
			int byte3 = in.read();
			length = byte0 << 24 | byte1 << 16 | byte2 << 8 | byte3; // analyzes
			// the header
			int total = 0;

			if (length < 0) {
				// server was shutdown
				shutDown = true;
				return null;
			}

			result = new byte[length];
			while (total < length) {
				total += in.read(result, total, length - total);
			}

			msg = new String(result, 0, length, "UTF-8");
			//System.out.println("--" + msg + "\n");

		} catch (IOException e) {
			System.out
					.println("Error when reading from socket, closing down...");
			shutDown = true;
			return null;
		}
		return msg;
	}

	/*
	 * Close server connection
	 */
	private void closeConnection() {
		try {
			in.close();
			out.close();
			socket.close();
			connected = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Connection disconnected");
	}

	public String getCurrentMessage() {
		return currentMessage;
	}

	public boolean isConnected() {
		return connected;
	}

	public Vector<String> GetVector() {

		GetMessageAsVector GmAv = new GetMessageAsVector();
		msgVector = GmAv.getMessage(receiveMessage());

		return msgVector;
	}

}
