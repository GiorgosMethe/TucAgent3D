package action;

public class CurrentMotion {
	
	public static int StartMotionCyrcles;
	public static int CurrentMotionCyrcles;
	public static int EndMotionCyrcles;
	public static int InitCyrcles;
	public static String CurrentMotionPlaying;
	public static int MotionPose;
	public static boolean PoseEnding;
	
	
	
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
