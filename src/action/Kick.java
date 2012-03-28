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
