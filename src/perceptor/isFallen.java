/*******************************************************************************
 * Copyright 2012, Technical University of Crete
 * Autonomous Agents, winter semester 2011-12
 * Semester Assignment
 * 
 * @author Methenitis Giorgos
 * @author Mpountouris Konstantinos
 * @author Papadimitriou Maouro Vassilis
 * @author Skipetaris Dimosthenis 
 *******************************************************************************/
package perceptor;

import behavior.BehaviorStateMachine;

public class isFallen {
	
	public void Check(){
		
		if((Math.abs(GyroScope.getAngleZ())+Math.abs(GyroScope.getAngleZ()+Math.abs(GyroScope.getAngleZ())))>500){
			BehaviorStateMachine.setName("Fallen");
			BehaviorStateMachine.setState("start");
		}
	}

}
