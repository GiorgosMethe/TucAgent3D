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
