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
	

	public static void Init(String Teamname, int number,Connection con){

		Beam bm=new Beam();
		String beam=bm.Init(number);
		int cyrcles=ServerCyrcles.getCyrclesNow();
		//boolean AgentInitialized=false;
		if(cyrcles>0 && cyrcles<10){
			if(cyrcles==1){
				
				if(number==1){
					new BehaviorStateMachine("Goalie","start");
				}else{
					new BehaviorStateMachine("goToPos","start");
				}
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
