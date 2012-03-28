package action;

import motions.MotionTrigger;
import perceptor.Ball;
import perceptor.HingeJointPerceptor;

public class GetKickablePosition {
	
	public void Act(){
		
		if(Ball.getDistance()>0.5){
			MotionTrigger.setMotion("Forwards50");
		}else{
		
		if(HingeJointPerceptor.getHj1()>-10){
			MotionTrigger.setMotion("SideStepLeft");
		}else{
			MotionTrigger.setMotion("SideStepRight");
		}
		}
	}
}
