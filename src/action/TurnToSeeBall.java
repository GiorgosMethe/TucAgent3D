package action;

import localization.BallPosition;
import perceptor.Ball;
import perceptor.HingeJointPerceptor;
import perceptor.Vision;
import behavior.BehaviorDone;

public class TurnToSeeBall {


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



