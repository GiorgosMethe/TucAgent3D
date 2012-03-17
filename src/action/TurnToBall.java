package action;

import behavior.BehaviorDone;
import localization.BallPosition;

public class TurnToBall {
	
	
	public void Act(){
		
		float angleFromBall=BallPosition.getAngle();
		
		if (angleFromBall>40){
			
			MotionTrigger.setMotion("TurnRight40");
			
			
		}else{
			
			MotionTrigger.setMotion("");
			BehaviorDone.setBehaviorDone(true);
		}
		
		
		
		
	}
	
	
	
	

}
