package action;

import localization.AgentPosition;

public class Kick {
	
	public void Act(){
		
		
		if(AgentPosition.getTheta()>-45 && AgentPosition.getTheta()<45)
		
		MotionTrigger.setMotion("KickForwardRight");
		
		else{
			
			MotionTrigger.setMotion("KickSideRight");
		}
		
	}

}
