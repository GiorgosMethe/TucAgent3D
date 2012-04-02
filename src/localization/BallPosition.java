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

package localization;

import perceptor.Ball;
import perceptor.HingeJointPerceptor;

public class BallPosition {



	public static float distance,angle;

	public BallPosition(float distance,float angle){

		distance=BallPosition.getDistance();
		angle=BallPosition.getAngle();



	}

	public static BallPosition WhereIsTheBall(){

		float angleX=Ball.getAngleX();
		//float angleY=Ball.getAngleY();
		float Bodydistance=Ball.getDistance();
		boolean iSeeBall=Ball.isSeeTheBall();
		float HeadxTheta=HingeJointPerceptor.getHj1();
		//float HeadyTheta=HingeJointPerceptor.getHj2();



		if(iSeeBall==true){


			float HeadxThetaDeg=(float) Math.toDegrees(HeadxTheta);
			float realAngleFromBody=HeadxThetaDeg + angleX;
			
			BallPosition BallPos = new BallPosition(Bodydistance, realAngleFromBody);
			return BallPos;


		}else{
			
			return null;
		}
	}


	public static float getDistance() {
		return distance;
	}

	public static void setDistance(float distance) {
		BallPosition.distance = distance;
	}

	public static float getAngle() {
		return angle;
	}

	public static void setAngle(float angle) {
		BallPosition.angle = angle;
	}


}