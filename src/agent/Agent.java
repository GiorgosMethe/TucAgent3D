package agent;
import behavior.BehaviorFactory;
import action.MotionHandler;
import action.CurrentMotion;
import action.MotionTrigger;
import action.SeekBall;
import connection.Connection;
import connection.ServerCyrcles;
import perceptor.Perceptors;


public class Agent {


	@SuppressWarnings("unused")
	private static CurrentMotion mt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Perceptors Gp = new Perceptors();
		SeekBall Sb = new SeekBall();
		BehaviorFactory Bh = new BehaviorFactory();

		String host = "127.0.0.1";
		int port = 3100;

		//initializes the connection
		Connection con = new Connection(host,port);

		boolean isConnected = false;

		//boolean playerIsInit=false;

		//establish the connection between agent and server
		isConnected = con.establishConnection();
		MotionHandler dnc=new MotionHandler();

		//Creation of Nao robot
		if(isConnected==true){

			con.sendMessage("(scene rsg/agent/nao/nao.rsg)");


		}

		int i=0;
		//MotionTrigger.setMotion("Forwards50");
		while(con.isConnected()){


			i++;
			Gp.GetPerceptors(con);
			ServerCyrcles.setCyrclesNow(i);

			if (i==2){
				MotionTrigger.setMotion("");
				CurrentMotion.setCurrentMotionPlaying("");
				con.sendMessage("(init(unum 1)(teamname TucAgent3D))");
			}			

			if (i==3){

				con.sendMessage("(beam 0.0 0.0 0.0)");
			}


			if(i>50){
				
				Bh.BehaviorController();
				System.out.println(MotionTrigger.getMotion());
				
				con.sendMessage(Sb.MoveHead(ServerCyrcles.getCyrclesNow()));

				con.sendMessage( dnc.MotionFactory(MotionTrigger.getMotion(),ServerCyrcles.getCyrclesNow()));


			}

		}

	}
}
