package action;

import connection.ServerCyrcles;
import behavior.BehaviorStateMachine;
import localization.BallPosition;
import localization.Coordinate;
import localization.Landmark;
import localization.LocalizationResults;
import motions.MotionTrigger;
import perceptor.Ball;
import perceptor.HingeJointPerceptor;

public class GetPosToGoal {

	public void Act(){




		Coordinate target=new Coordinate(4, -4);

		double dx=target.getX()-LocalizationResults.current_location.getX();
		double dy=target.getY()-LocalizationResults.current_location.getY();
		double dTheta=-Math.atan(dy/dx)+LocalizationResults.getBody_angle();

		System.out.println("----------dx--------------------");
		System.out.println(dx);
		System.out.println("-----------dy-------------------");
		System.out.println(dy);
		System.out.println("-----------dTheta-------------------");
		System.out.println(dTheta);



		if(ServerCyrcles.getCyrclesNow()%20==0){
			if(Math.abs(dx)<1 && Math.abs(dy)<1){
				MotionTrigger.setMotion("");
			}else{


				if(dTheta>15){

					if(dTheta>0){
						MotionTrigger.setMotion("TurnRight40");

					}else{
						MotionTrigger.setMotion("TurnLeft40");
					}

				}else{

					MotionTrigger.setMotion("Forwards50");

				}

			}
		}

	}
}
