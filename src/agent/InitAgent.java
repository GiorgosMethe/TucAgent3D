package agent;

import communication.HearMessage;
import communication.WhoSent;

import motions.CurrentMotion;
import motions.MotionTrigger;
import behavior.BehaviorDone;
import behavior.BehaviorStateMachine;
import connection.Connection;
import connection.ServerCyrcles;

public class InitAgent {

	public static boolean playerReady;

	public static void Init(String Teamname, int number,String beam, Connection con){

		int cyrcles=ServerCyrcles.getCyrclesNow();
		//boolean AgentInitialized=false;
		if(cyrcles>0 && cyrcles<10){
			if(cyrcles==1){
				
				new BehaviorStateMachine("KickTheBallToGoal","start");
				CurrentMotion.setSoftChangeCounter(0);
				InitAgent.setPlayerInited(false);
				BehaviorDone.setName("");
				BehaviorDone.setBehaviorDone(true);
				MotionTrigger.setMotion("");
				CurrentMotion.setCurrentMotionPlaying("");
				con.sendMessage("(init(unum "+number+")(teamname "+Teamname+"))");
				AgentType.setPlayerNum(number);
				WhoSent.setCounter(1);
				HearMessage.InitMessage();
				

			}else if(cyrcles==3){

				con.sendMessage("(beam "+beam+")");

			}
			
			MotionTrigger.setMotion("Init");
			if(cyrcles==9){
				InitAgent.setPlayerInited(true);
			}
		}

	}

	public static void CreateAgent(Connection con){
		con.sendMessage("(scene rsg/agent/nao/nao.rsg)");
	}

	public static boolean isPlayerInited() {
		return playerReady;
	}

	public static void setPlayerInited(boolean playerInited) {
		InitAgent.playerReady = playerInited;
	}



}
