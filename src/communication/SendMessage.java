/*******************************************************************************
 * Copyright 2012, Technical University of Crete
 * Autonomous Agents, winter semester 2011-12
 * Semester Assignement
 * 
 * @author Methenitis Giorgos
 * @author Mpountouris Konstantinos
 * @author Papadimitriou Maouro Vassilis
 * @author Skipetaris Dimosthenis 
 *
 * This file is part of magmaOffenburg.
 *
 * Tuc Agent 3D is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *******************************************************************************/


package communication;

import behavior.BehaviorStateMachine;
import perceptor.Ball;
import worldState.TeamState;
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
		
		if(BehaviorStateMachine.getName().equalsIgnoreCase("Fallen")){
			Ball.setDistance(100);
		}
		message="d%"+TeamState.getTeamSide()+"%"+Integer.toString(AgentType.getPlayerNum())+"%"+Float.toString(Ball.getDistance());
		
		
		return message;
		
	}
	
}