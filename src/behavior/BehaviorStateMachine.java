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
