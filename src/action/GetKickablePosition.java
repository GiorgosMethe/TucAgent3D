package action;

import perceptor.Ball;
import perceptor.HingeJointPerceptor;

public class GetKickablePosition {
	
	public void Act(){
		
		if(HingeJointPerceptor.getHj1()>-16){
			MotionTrigger.setMotion("SideStepLeft");
		}else{
			MotionTrigger.setMotion("SideStepRight");
		}
	}
}
