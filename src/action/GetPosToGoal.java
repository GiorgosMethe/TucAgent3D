package action;

import localization.AgentPosition;

public class GetPosToGoal {
	
public void Act(){
	
	
	if(AgentPosition.getTheta()<10){
		MotionTrigger.setMotion("TurnRight40");
	}else if(AgentPosition.getTheta()>-10){
		MotionTrigger.setMotion("TurnLeft40");
	}else{
		MotionTrigger.setMotion("");
	}
	
	
			
	}

}
