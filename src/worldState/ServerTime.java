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
package worldState;

public class ServerTime {

	public static float time;
	public static String name;

	public ServerTime() {

	}

	public ServerTime(String name, float time) {

		name = ServerTime.getName();
		time = ServerTime.getTime();

	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		ServerTime.name = name;
	}

	public static float getTime() {
		return time;
	}

	public static void setTime(float time) {
		ServerTime.time = time;
	}

}
