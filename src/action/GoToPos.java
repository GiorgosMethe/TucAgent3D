package action;

import localization.BallPosition;
import localization.Landmark;
import localization.LocalizationResults;
import motions.MotionTrigger;
import perceptor.Ball;
import perceptor.HingeJointPerceptor;
import worldState.TeamState;

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
