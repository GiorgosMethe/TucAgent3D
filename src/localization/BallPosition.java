package localization;

import perceptor.Ball;
import perceptor.HingeJointPerceptor;

public class BallPosition {



	public static float distance,angle;

	public BallPosition(float distance,float angle){

		distance=BallPosition.getDistance();
		angle=BallPosition.getAngle();

	}

	public static void WhereIsTheBall(){

		float angleX=Ball.getAngleX();
		//float angleY=Ball.getAngleY();
		float Bodydistance=Ball.getDistance();
		boolean iSeeBall=Ball.isSeeTheBall();
		float HeadxTheta=HingeJointPerceptor.getHj1();
		//float HeadyTheta=HingeJointPerceptor.getHj2();

		if(iSeeBall==true){

			float HeadxThetaDeg=(float) Math.toDegrees(HeadxTheta);
			float realAngleFromBody=HeadxThetaDeg + angleX;
			
			BallPosition.setDistance(Bodydistance);
			BallPosition.setAngle(realAngleFromBody);

		}
	}

	public static boolean IsBallKickable(){
		//needs something
		//needs something
		//needs something
		//needs something
		//needs something
		//needs something
		//needs something
		//needs something		
		return false;
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
