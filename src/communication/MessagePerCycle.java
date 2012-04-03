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

import agent.AgentType;
import connection.ServerCyrcles;

public class MessagePerCycle {

	public static boolean PerNumCircles(int number){

		int MaxNum=7;

		if (ServerCyrcles.getCyrclesNow()%4==0){

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