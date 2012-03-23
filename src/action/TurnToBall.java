package action;

import perceptor.HingeJointPerceptor;
import localization.BallPosition;

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
