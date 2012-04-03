/*******************************************************************************
 * Copyright 2012, Technical University of Crete
 * Autonomous Agents, winter semester 2011-12
 * Semester Assignment
 * 
 * @author Methenitis Giorgos
 * @author Mpountouris Konstantinos
 * @author Papadimitriou Maouro Vassilis
 * @author Skipetaris Dimosthenis 
 *******************************************************************************/

package communication;

import connection.Connection;
import agent.AgentType;
import behavior.BehaviorStateMachine;
import perceptor.Ball;
import worldState.TeamState;
public class HearMessage {

	Connection con = new Connection();
	public static float time;
	public static float direction;
	public static String msg;
	public static boolean self;

	public HearMessage(){

	}

	public HearMessage(float time, float direction, String msg, boolean self){

		time = HearMessage.getTime();
		direction = HearMessage.getDirection();
		msg = HearMessage.getMsg();
		self = HearMessage.isSelf();

	}

	public static float getTime() {
		return time;
	}


	public static void setTime(float time) {
		HearMessage.time = time;
	}


	public static float getDirection() {
		return direction;
	}


	public static void setDirection(float direction) {
		HearMessage.direction = direction;
	}


	public static String getMsg() {
		return msg;
	}


	public static void setMsg(String msg) {
		HearMessage.msg = msg;
	}


	public static boolean isSelf() {
		return self;
	}


	public static void setSelf(boolean self) {
		HearMessage.self = self;
	}



	public static void InitMessage(){

		setMsg(null);
		setDirection(0);
		setTime(0);
		setSelf(true);
	}

	public static void MessageDecoder(){

		if(isSelf()==false){

			if(!getMsg().equalsIgnoreCase("")){
				String msg=HearMessage.getMsg();
				String[] splittedMsg = msg.split("%");
				if(splittedMsg[0].equalsIgnoreCase("d")){
					DistMessageAct(splittedMsg);
				}
			}
		}
	}

	public static void DistMessageAct(String msg[]){

		@SuppressWarnings("unused")
		float distance = Float.parseFloat(msg[3]);

		if(AgentType.getPlayerNum()!=1){

			if(TeamState.getTeamSide().equalsIgnoreCase(msg[1])){

				float min = 100;

				for(int i=2;i<MessageBuffer.getDistancesBuffer().length;i++){

					if(i!=AgentType.getPlayerNum()){
						if(MessageBuffer.getDistancesBuffer()[i]!=0.0f){
							if(MessageBuffer.getDistancesBuffer()[i]<min){
								min = MessageBuffer.getDistancesBuffer()[i];
							}
						}
					}
				}
				;
				if(Ball.getDistance()<min){

					if(!BehaviorStateMachine.getName().equalsIgnoreCase("KickTheBallToGoal")){
						BehaviorStateMachine.setName("KickTheBallToGoal");
						BehaviorStateMachine.setState("start");
					}
				}else{
					if(!BehaviorStateMachine.getName().equalsIgnoreCase("goToPos")){

						if(BehaviorStateMachine.getName().equalsIgnoreCase("Fallen")){
							BehaviorStateMachine.setName("Fallen");
							return;
						}
						BehaviorStateMachine.setName("goToPos");
						BehaviorStateMachine.setState("start");
					}
				}




			}

		}

	}


}