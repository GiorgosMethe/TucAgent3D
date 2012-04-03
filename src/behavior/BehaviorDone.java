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

public class BehaviorDone {
	
	public static String name;
	public static boolean behaviorDone;

	
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		BehaviorDone.name = name;
	}

	public static boolean isBehaviorDone() {
		return behaviorDone;
	}

	public static void setBehaviorDone(boolean behaviorDone) {
		BehaviorDone.behaviorDone = behaviorDone;
	}
	
	

}
