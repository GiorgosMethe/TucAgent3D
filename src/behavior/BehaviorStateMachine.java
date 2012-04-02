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

package behavior;

public class BehaviorStateMachine {
	
	
	public static String Name;
	public static String State;
	
	
	public BehaviorStateMachine(String Name,String State){
		BehaviorStateMachine.setName(Name);
		BehaviorStateMachine.setState(State);
	}
	
	
	
	public static String getName() {
		return Name;
	}
	public static void setName(String name) {
		Name = name;
	}
	public static String getState() {
		return State;
	}
	public static void setState(String state) {
		State = state;
	}
	

}
