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

		float distance = Float.parseFloat(msg[3]);


		if(TeamState.getTeamSide().equalsIgnoreCase(msg[1])){


			for(int i=1;i<MessageBuffer.getDistancesBuffer().length;i++){

				if(i==AgentType.getPlayerNum()){


				}else{


					if(Ball.getDistance()<MessageBuffer.getDistancesBuffer()[i]){

						if(!BehaviorStateMachine.getName().equalsIgnoreCase("goKickTheBall")){
							BehaviorStateMachine.setName("goKickTheBall");
							BehaviorStateMachine.setState("start");
						}
					}else{

						System.out.println("mou milaei allos kai einai pio konta");
						if(!BehaviorStateMachine.getName().equalsIgnoreCase("Wait")){

							if(BehaviorStateMachine.getName().equalsIgnoreCase("Fallen")){
								BehaviorStateMachine.setName("Fallen");
								return;
							}
							BehaviorStateMachine.setName("Wait");
							BehaviorStateMachine.setState("start");
						}
					}

				}
			}
		}

	}


}