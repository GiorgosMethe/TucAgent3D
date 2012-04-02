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


package action;

import connection.ServerCyrcles;
import localization.Coordinate;
import localization.LocalizationResults;
import motions.MotionTrigger;

public class WalkTo {
	
	public void Act(float X,float Y,float Theta){
		
		Coordinate target=new Coordinate(4, -4);

		double dx=target.getX()-LocalizationResults.current_location.getX();
		double dy=target.getY()-LocalizationResults.current_location.getY();
		double dTheta=-Math.atan(dy/dx)+LocalizationResults.getBody_angle();

		if(ServerCyrcles.getCyrclesNow()%20==0){
			if(Math.abs(dx)<1 && Math.abs(dy)<1){
				MotionTrigger.setMotion("");
			}else{


				if(dTheta>15){

					if(dTheta>0){
						MotionTrigger.setMotion("TurnRight40");

					}else{
						MotionTrigger.setMotion("TurnLeft40");
					}

				}else{

					MotionTrigger.setMotion("Forwards50");

				}

			}
		}
		
	}

}
