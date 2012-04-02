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

import localization.BallPosition;
import motions.MotionTrigger;
import perceptor.HingeJointPerceptor;

public class GoToPos {

	public void Act(){


		if(Math.abs((HingeJointPerceptor.getHj1()+BallPosition.getAngle()))>20){

			if(HingeJointPerceptor.getHj1()>0){
				MotionTrigger.setMotion("TurnLeft40");

			}else{
				MotionTrigger.setMotion("TurnRight40");

			}


		}else{

			MotionTrigger.setMotion("Forwards50");

		}






	}

}
