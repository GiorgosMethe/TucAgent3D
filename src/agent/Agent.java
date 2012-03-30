package agent;
import communication.HearMessage;
import communication.SendMessage;

import localization.BallPosition;
import localization.Landmark;
import localization.LocalizationResults;
import motions.CurrentMotion;
import motions.MotionController;
import motions.MotionTrigger;
import behavior.BehaviorFactory;
import behavior.BehaviorStateMachine;
import action.SeekBall;
import connection.Connection;
import connection.MessageController;
import connection.ServerCyrcles;
import perceptor.Ball;
import worldState.GameState;
import worldState.TeamState;

import java.lang.String;


public class Agent {


	public static int num=0;
	@SuppressWarnings("unused")
	private static CurrentMotion mt;

	public static void main(String[] args) {

		MessageController Gp = new MessageController();
		SeekBall Sb = new SeekBall();
		BehaviorFactory Bh = new BehaviorFactory();
		SendMessage sm = new SendMessage();
		MotionController dnc=new MotionController();

		//connection config
		String host = "127.0.0.1";
		int port = 3100;

		//initializes the connection
		Connection con = new Connection(host,port);

		boolean isConnected = false;

		//establish the connection between agent and server
		isConnected = con.establishConnection();

		//Creation of Nao robot
		if(isConnected==true){
			InitAgent.CreateAgent(con);
		}

		//server cyrcles
		int i=0;

		//player number
		num=3;
		// team name
		String Teamname="tuc";
		//player position
		String beamX="-4.0";
		String beamY="0.0";
		String beamTheta="0.0";
		String beam=beamX+" "+beamY+" "+beamTheta;

		while(con.isConnected()){

			i++;
			//update perceptors
			Gp.GetPerceptors(con);
			//update ball position
			BallPosition.WhereIsTheBall();
			//update server cyrcles
			ServerCyrcles.setCyrclesNow(i);
			//init Agent
			InitAgent.Init(Teamname, num, beam, con);
			//think
			if(!GameState.getGameState().equalsIgnoreCase("BeforeKickOff") && InitAgent.isPlayerInited()==true){	
				Bh.BehaviorController();
				//Communication
				//say message
				sm.Say("distance", con);
				HearMessage.MessageDecoder();
			}
			//get the head movement
			String headAct=Sb.MoveHead();
			//get the agent action
			String AgentAct= dnc.MotionFactory(MotionTrigger.getMotion());
			//create the hole agents actions
			String Act=headAct+AgentAct;
			//Act
			con.sendMessage(Act);
			
		}

	}
}
