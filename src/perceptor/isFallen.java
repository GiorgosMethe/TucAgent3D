/*******************************************************************************
 * Copyright 2012, Technical University of Crete
 * Autonomous Agents, winter semester 2011-12
 * Semester Assignement
 * 
 * @author Methenitis Giorgos
 * @author Mpountouris Konstantinos
 * @author Papadimitriou Maouro Vassilis
 * @author Skipetaris Dimosthenis 
 *
 * This file is part of magmaOffenburg.
 *
 * Tuc Agent 3D is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
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
