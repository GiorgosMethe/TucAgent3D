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

import perceptor.HingeJointPerceptor;
import localization.BallPosition;
import motions.MotionTrigger;

public class TurnToBall {
	
	
	public void Act(){
		
		if(Math.abs((HingeJointPerceptor.getHj1()+BallPosition.getAngle()))>20){
			
			if(HingeJointPerceptor.getHj1()>0){
				MotionTrigger.setMotion("TurnLeft40");
				
			}else{
				MotionTrigger.setMotion("TurnRight40");
				
			}
			
			
	}else{
		
		
	}
	
	}
	

}
