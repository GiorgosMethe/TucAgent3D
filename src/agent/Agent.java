package agent;
import localization.BallPosition;
import behavior.BehaviorDone;
import behavior.BehaviorFactory;
import behavior.BehaviorStateMachine;
import action.MotionController;
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
		new BehaviorStateMachine("goKickTheBall","start");

		String host = "127.0.0.1";
		int port = 3100;

		//initializes the connection
		Connection con = new Connection(host,port);

		BehaviorDone.setName("");
		BehaviorDone.setBehaviorDone(true);
		boolean isConnected = false;

		//boolean playerIsInit=false;

		//establish the connection between agent and server
		isConnected = con.establishConnection();
		MotionController dnc=new MotionController();

		//Creation of Nao robot
		if(isConnected==true){

			con.sendMessage("(scene rsg/agent/nao/nao.rsg)");


		}

		int i=0;
		
		while(con.isConnected()){


			i++;
			Gp.GetPerceptors(con);
			BallPosition.WhereIsTheBall();
			ServerCyrcles.setCyrclesNow(i);

			if (i==2){
				MotionTrigger.setMotion("");
				CurrentMotion.setCurrentMotionPlaying("");
				con.sendMessage("(init(unum 1)(teamname Agent3D))");
			}			

			if (i==3){

				con.sendMessage("(beam 0.0 0.0 90.0)");
			}
			//initJoints


			if(i>50){
				
				Bh.BehaviorController();
				System.out.println(MotionTrigger.getMotion());			
				con.sendMessage(Sb.MoveHead(ServerCyrcles.getCyrclesNow()));
				con.sendMessage( dnc.MotionFactory(MotionTrigger.getMotion(),ServerCyrcles.getCyrclesNow()));
				
				
			}

		}

	}
}
