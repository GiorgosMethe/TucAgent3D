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

import localization.LocalizationResults;
import motions.MotionTrigger;
import perceptor.Ball;

public class FrGoToPos {


	public void Act(){


		if(Ball.getDistance()>2 && LocalizationResults.getBall_location().getX()>=0 && LocalizationResults.getCurrent_location().getX()<11){


			if(Math.abs(LocalizationResults.getBody_angle())>20){

				if((LocalizationResults.getBody_angle())>0){
					MotionTrigger.setMotion("TurnRight40");

				}else{
					MotionTrigger.setMotion("TurnLeft40");
				}


			}else{

				MotionTrigger.setMotion("Forwards50");

			}

		}else if(Ball.getDistance()<4 && LocalizationResults.getBall_location().getX()<=0 && LocalizationResults.getCurrent_location().getX()>0){

			if(Math.abs(LocalizationResults.getBody_angle())>20){

				if((LocalizationResults.getBody_angle())>0){
					MotionTrigger.setMotion("TurnRight40");

				}else{
					MotionTrigger.setMotion("TurnLeft40");
				}


			}else{

				MotionTrigger.setMotion("Backwards");

			}



		}else{


			MotionTrigger.setMotion("");


		}

	}
}
