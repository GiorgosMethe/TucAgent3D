package action;

import localization.BallPosition;
import perceptor.Ball;
import perceptor.Vision;
import behavior.BehaviorDone;

public class TurnToBall {

	public static void Act(){

		if(Vision.isiSee()==true){

			if(Ball.isSeeTheBall()==true){

				float distance=BallPosition.getDistance();
				float angle=BallPosition.getAngle();
				
				System.out.println("distance"+distance);
				System.out.println("angle"+angle);

				
				if (distance<0.6){
					MotionTrigger.setMotion("KickForwardRight");
				}else{
					MotionTrigger.setMotion("Forwards");
				}
			}
		}

	}

}
