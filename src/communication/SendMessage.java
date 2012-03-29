package communication;

import perceptor.Ball;
import agent.AgentType;
import connection.Connection;
public class SendMessage {
	
	public void Say(String type, Connection con){
		
		String message="";
		String coderMessage="";
		
		if(type.equalsIgnoreCase("distance")){
			coderMessage=DistanceMessageCoder();
		}
		message = "(say"+" "+coderMessage+")";
		
		if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
			con.sendMessage(message);
		}
		
	}
	
	public String DistanceMessageCoder(){
		String message="";
		
		message="d%"+Integer.toString(AgentType.getPlayerNum())+"%"+Float.toString(Ball.getDistance());
		
		
		return message;
		
	}
	
}