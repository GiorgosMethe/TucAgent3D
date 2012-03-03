package action;

public class MotionTimer {
	
	public static int StartMotionCyrcles;
	public static int CurrentMotionCyrcles;
	public static int EndMotionCyrcles;
	public static String CurrentMotionPlaying;
	public static int MotionPose;
	public static boolean PoseEnding;
	
	
	
	public MotionTimer(String currentMotionPlaying, int startMotionCyrcles,int currentMotionCyrcles, int endMotionCyrcles,int MotionPose,boolean PoseEnding) {
		CurrentMotionPlaying=MotionTimer.getCurrentMotionPlaying();
		StartMotionCyrcles=MotionTimer.getStartMotionCyrcles();
		StartMotionCyrcles=MotionTimer.getCurrentMotionCyrcles();
		EndMotionCyrcles=MotionTimer.getEndMotionCyrcles();
		MotionPose=MotionTimer.getMotionPose();
		PoseEnding=MotionTimer.isPoseEnding();
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
