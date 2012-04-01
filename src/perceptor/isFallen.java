package perceptor;

import behavior.BehaviorStateMachine;

public class isFallen {
	
	public void Check(){
		
		if((Math.abs(GyroScope.getAngleZ())+Math.abs(GyroScope.getAngleZ()+Math.abs(GyroScope.getAngleZ())))>500){
			BehaviorStateMachine.setName("Fallen");
		}
	}

}
