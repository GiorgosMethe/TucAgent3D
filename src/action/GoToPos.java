package action;

import motions.MotionTrigger;
import perceptor.Ball;
import perceptor.HingeJointPerceptor;

public class GoToPos {
	
	public void Act(){
		
		if(Ball.getDistance()>5){
			
			if(HingeJointPerceptor.getHj1()>20){
				MotionTrigger.setMotion("TurnLeft40");

			}else if(HingeJointPerceptor.getHj1()<-20){
				MotionTrigger.setMotion("TurnRight40");

			}else{
			
				MotionTrigger.setMotion("Forwards50");
			}
		}
		
		
		
		
	}

}
