package agent;

import behavior.Behavior;
import action.MotionHandler;
import action.MotionTimer;
import action.MotionTrigger;
//import action.Motions;
import action.SeekBall;
import connection.Connection;
import connection.ServerCyrcles;
import perceptor.Perceptors;


public class Agent {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MotionTimer Mt= new MotionTimer("",0,0,0,0,true);
		Perceptors Gp = new Perceptors();
		SeekBall Sb = new SeekBall();
		Behavior Bh = new Behavior();

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
		int y=1;


		while(con.isConnected()){
			
			Gp.GetPerceptors(con);
			ServerCyrcles.setCyrclesNow(i);

			if (i==2){

				con.sendMessage("(init(unum 0)(teamname TucAgent3D))");
				//playerIsInit=true;
			}

			if (i==3){

				con.sendMessage("(beam 7.0 0.0 0.0)");
			}

			if(i>50){
				
				Bh.Act();
				
				
				con.sendMessage(Sb.MoveHead(ServerCyrcles.getCyrclesNow()));
				
				
				con.sendMessage( dnc.MotionFactory(MotionTrigger.getMotion(),ServerCyrcles.getCyrclesNow()));
							
				
			}

		i++;
		}
	}
}