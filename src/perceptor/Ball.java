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

public class Ball {

	private static boolean seeTheBall;
	private static float distance;
	private static float angleX;
	private static float angleY;

	public Ball(boolean seeTheBall, float distance, float angleX, float angleY) {

		seeTheBall = Ball.isSeeTheBall();
		distance = Ball.getDistance();
		angleX = Ball.getAngleX();
		angleY = Ball.getAngleY();

	}

	public static boolean isSeeTheBall() {
		return seeTheBall;
	}

	public static void setSeeTheBall(boolean seeTheBall) {
		Ball.seeTheBall = seeTheBall;
	}

	public static float getDistance() {
		return distance;
	}

	public static void setDistance(float distance) {
		Ball.distance = distance;
	}

	public static float getAngleX() {
		return angleX;
	}

	public static void setAngleX(float angleX) {
		Ball.angleX = angleX;
	}

	public static float getAngleY() {
		return angleY;
	}

	public static void setAngleY(float angleY) {
		Ball.angleY = angleY;
	}
	
	public static boolean isKickable(){
		if(HingeJointPerceptor.getHj1()<-15 && HingeJointPerceptor.getHj1()>-17){
			return true;
		}else{
			return false;
		}	
	}
	
}
