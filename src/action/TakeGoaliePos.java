package action;

import localization.LocalizationResults;
import motions.MotionTrigger;

public class TakeGoaliePos {
	
	public void Act(){
		
		
		boolean alreadyGivenMove=false;
		if(LocalizationResults.getCurrent_location().getX()<-10.5){
			alreadyGivenMove=true;
			MotionTrigger.setMotion("Forwards50");
		}else if(LocalizationResults.getCurrent_location().getX()>-9.5){
			alreadyGivenMove=true;
			MotionTrigger.setMotion("Backwards");
		}else{
			
			if(LocalizationResults.getCurrent_location().getY()>0.8 && alreadyGivenMove==false){
				alreadyGivenMove=true;
				MotionTrigger.setMotion("SideStepRight");
			}else if(LocalizationResults.getCurrent_location().getY()<-0.8 && alreadyGivenMove==false){
				alreadyGivenMove=true;
				MotionTrigger.setMotion("SideStepLeft");
			}else{
				
				if(LocalizationResults.getBody_angle()>10 && alreadyGivenMove==false){
					alreadyGivenMove=true;
					MotionTrigger.setMotion("TurnRight40");
				}else if(LocalizationResults.getBody_angle()>10 && alreadyGivenMove==false){
					alreadyGivenMove=true;
					MotionTrigger.setMotion("TurnLeft40");
				}else{
					
					if(LocalizationResults.getBall_location().getY()<LocalizationResults.getCurrent_location().getY() && alreadyGivenMove==false){
						MotionTrigger.setMotion("SideStepRight");
					}else{
						MotionTrigger.setMotion("SideStepLeft");
					}
				}
	
			}		
		}	
	}

}
