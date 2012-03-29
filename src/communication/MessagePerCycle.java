package communication;

import agent.AgentType;
import connection.ServerCyrcles;

public class MessagePerCycle {

	public static boolean PerNumCircles(int number){

		int MaxNum=4;

		if (ServerCyrcles.getCyrclesNow()%3==0){

			if(WhoSent.getCounter()==MaxNum){
				WhoSent.setCounter(1);
			}else{
				WhoSent.setCounter(WhoSent.getCounter()+1);
			}
			
			if(AgentType.getPlayerNum()==WhoSent.getCounter()){
				return true;
			}else{
				return false;
			}
		}else{

			return false;
		}
		
	}
}