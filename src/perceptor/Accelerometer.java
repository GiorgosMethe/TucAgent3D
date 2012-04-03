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

public class Accelerometer {

	public static float accX, accY, accZ;

	public Accelerometer(float accX, float accY, float accZ) {

		accX = Accelerometer.accX;
		accY = Accelerometer.accY;
		accZ = Accelerometer.accZ;

	}

	public static float getAccX() {
		return accX;
	}

	public static void setAccX(float accX) {
		Accelerometer.accX = accX;
	}

	public static float getAccY() {
		return accY;
	}

	public static void setAccY(float accY) {
		Accelerometer.accY = accY;
	}

	public static float getAccZ() {
		return accZ;
	}

	public static void setAccZ(float accZ) {
		Accelerometer.accZ = accZ;
	}

}
