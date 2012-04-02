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

import worldState.TeamState;


public class MessageBuffer {

	public static float[] DistancesBuffer =new float[8];


	@SuppressWarnings("static-access")
	public static void UpdateBuffer(HearMessage msg){



		for(int j=0;j<DistancesBuffer.length;j++){
			
			System.out.println("*********"+DistancesBuffer[j]);
			
		}

		if(!msg.getMsg().equalsIgnoreCase("")){
			String[] splittedMsg = msg.getMsg().split("%");
			if(splittedMsg[1].equalsIgnoreCase(TeamState.getTeamSide())){
				
				DistancesBuffer[Integer.parseInt(splittedMsg[2])]=Float.parseFloat(splittedMsg[3]);

			}
		}

	}


	public static float[] getDistancesBuffer() {
		return DistancesBuffer;
	}


	public static void setDistancesBuffer(float[] distancesBuffer) {
		DistancesBuffer = distancesBuffer;
	}




}
