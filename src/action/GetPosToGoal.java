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

		boolean iseegoal=false;
		float Distance1 = 0;
		float Distance2 = 0;
		float Angle1=0;
		float Angle2 = 0;
		float prefferedAngleKick=0;
		for(int k=0;k<LocalizationResults.getLandmarks().size();k++){
			Landmark a=LocalizationResults.getLandmarks().elementAt(k);
			if(a.getName().equalsIgnoreCase("g1r")){
				iseegoal=true;
				Distance1=(float) a.getDistance();
				Angle1=(float) a.getHorizontal_Angle();
			}
			if(a.getName().equalsIgnoreCase("g2r")){
				iseegoal=true;
				Distance2=(float) a.getDistance();
				Angle2=(float) a.getHorizontal_Angle();
			}

		}
		if(iseegoal==true){	
			prefferedAngleKick=(Angle1+Angle2)/2;
			System.out.println("body angle:"+LocalizationResults.getBody_angle());
			System.out.println("distanceL"+Distance1);
			System.out.println("angleL"+Angle1);
			System.out.println("distanceR"+Distance2);
			System.out.println("angleR"+Angle2);
			System.out.println("PrefferedKick"+prefferedAngleKick);
			System.out.println("--------------------------------------");


			if(Math.abs(LocalizationResults.getBody_angle()-prefferedAngleKick)>5){


				if(prefferedAngleKick>0){
					if(Math.abs((HingeJointPerceptor.getHj1()+BallPosition.getAngle()))>20){

						if(HingeJointPerceptor.getHj1()>0){
							MotionTrigger.setMotion("TurnLeft40");

						}else{
							MotionTrigger.setMotion("TurnRight40");

						}


					}else{
						MotionTrigger.setMotion("SideStepRight");
					}
				}else{
					if(Math.abs((HingeJointPerceptor.getHj1()+BallPosition.getAngle()))>20){

						if(HingeJointPerceptor.getHj1()>0){
							MotionTrigger.setMotion("TurnLeft40");

						}else{
							MotionTrigger.setMotion("TurnRight40");

						}


					}else{
						MotionTrigger.setMotion("SideStepLeft");
					}
				}




			}else{
				
				BehaviorStateMachine.setState("goBall");
				
			}



		}






	}





}
