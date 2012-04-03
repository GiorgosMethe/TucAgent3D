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

public class GyroScope {

	public static float angleX, angleY, angleZ;

	public GyroScope(float angleX, float angleY, float angleZ) {

		angleX = GyroScope.angleX;
		angleY = GyroScope.angleY;
		angleZ = GyroScope.angleZ;
	}

	public static float getAngleX() {
		return angleX;
	}

	public static void setAngleX(float angleX) {
		GyroScope.angleX = angleX;
	}

	public static float getAngleY() {
		return angleY;
	}

	public static void setAngleY(float angleY) {
		GyroScope.angleY = angleY;
	}

	public static float getAngleZ() {
		return angleZ;
	}

	public static void setAngleZ(float angleZ) {
		GyroScope.angleZ = angleZ;
	}

}
