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


package action;

import localization.LocalizationResults;
import motions.MotionTrigger;
import perceptor.Ball;

public class DlGoToPos {
	
	public void Act(){


		if(Ball.getDistance()>5 && LocalizationResults.getBall_location().getX()>=0 && LocalizationResults.getCurrent_location().getX()<0){


			if(Math.abs(LocalizationResults.getBody_angle()-10)>20){

				if((LocalizationResults.getBody_angle()-10)>0){
					MotionTrigger.setMotion("TurnRight40");

				}else{
					MotionTrigger.setMotion("TurnLeft40");
				}


			}else{

				MotionTrigger.setMotion("Forwards50");

			}

		}else if(Ball.getDistance()<5 && LocalizationResults.getBall_location().getX()<=0 && LocalizationResults.getCurrent_location().getX()>-9){
			
			if(Math.abs(LocalizationResults.getBody_angle()-10)>20){

				if((LocalizationResults.getBody_angle()-10)>0){
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
