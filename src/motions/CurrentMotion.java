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
package motions;

public class CurrentMotion {
	
	public static int StartMotionCyrcles;
	public static int CurrentMotionCyrcles;
	public static int EndMotionCyrcles;
	public static int InitCyrcles;
	public static String CurrentMotionPlaying;
	public static int MotionPose;
	public static boolean PoseEnding;
	public static int SoftChangeCounter;
	
	
	
	public CurrentMotion(String currentMotionPlaying, int startMotionCyrcles,int currentMotionCyrcles, int endMotionCyrcles,int MotionPose,int InitCyrcles,boolean PoseEnding) {
		CurrentMotionPlaying=CurrentMotion.getCurrentMotionPlaying();
		StartMotionCyrcles=CurrentMotion.getStartMotionCyrcles();
		StartMotionCyrcles=CurrentMotion.getCurrentMotionCyrcles();
		EndMotionCyrcles=CurrentMotion.getEndMotionCyrcles();
		MotionPose=CurrentMotion.getMotionPose();
		PoseEnding=CurrentMotion.isPoseEnding();
	}


	public static int getInitCyrcles() {
		return InitCyrcles;
	}


	public static void setInitCyrcles(int initCyrcles) {
		InitCyrcles = initCyrcles;
	}


	public static String getCurrentMotionPlaying() {
		return CurrentMotionPlaying;
	}


	public static void setCurrentMotionPlaying(String currentMotionPlaying) {
		CurrentMotionPlaying = currentMotionPlaying;
	}


	public static int getStartMotionCyrcles() {
		return StartMotionCyrcles;
	}
	public static void setStartMotionCyrcles(int startMotionCyrcles) {
		StartMotionCyrcles = startMotionCyrcles;
	}
	public static int getCurrentMotionCyrcles() {
		return CurrentMotionCyrcles;
	}
	public static void setCurrentMotionCyrcles(int currentMotionCyrcles) {
		CurrentMotionCyrcles = currentMotionCyrcles;
	}
	public static int getEndMotionCyrcles() {
		return EndMotionCyrcles;
	}
	public static void setEndMotionCyrcles(int endMotionCyrcles) {
		EndMotionCyrcles = endMotionCyrcles;
	}


	
	
	public static int getSoftChangeCounter() {
		return SoftChangeCounter;
	}


	public static void setSoftChangeCounter(int softChangeCounter) {
		SoftChangeCounter = softChangeCounter;
	}


	public static int getMotionPose() {
		return MotionPose;
	}


	public static void setMotionPose(int motionPose) {
		MotionPose = motionPose;
	}


	public static boolean isPoseEnding() {
		return PoseEnding;
	}


	public static void setPoseEnding(boolean poseEnding) {
		PoseEnding = poseEnding;
	}
}
