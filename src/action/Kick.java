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

import motions.MotionTrigger;
import perceptor.HingeJointPerceptor;



public class Kick {
	
	public void Act(){
		
		
		if(HingeJointPerceptor.getHj1()>0){
			MotionTrigger.setMotion("KickForwardLeft");
		}else{
			MotionTrigger.setMotion("KickForwardRight");
		}
		
		
	
	}

}
