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
