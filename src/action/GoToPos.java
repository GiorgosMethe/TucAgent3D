package action;

import localization.Landmark;
import localization.LocalizationResults;
import motions.MotionTrigger;
import perceptor.Ball;
import perceptor.HingeJointPerceptor;
import worldState.TeamState;

public class GoToPos {

	public void Act(){

		if(Ball.getDistance()>3){

			boolean iseegoal1=false;
			boolean iseegoal2=false;
			float Distance1 = 0;
			float Distance2 = 0;
			float Angle1=0;
			float Angle2=0;
			float prefferedAngleMove=0;
			for(int k=0;k<LocalizationResults.getLandmarks().size();k++){
				Landmark a=LocalizationResults.getLandmarks().elementAt(k);

				if(a.getName().equalsIgnoreCase(TeamState.getOppGoal1())){
					iseegoal1=true;
					Distance1=(float) a.getDistance();
					Angle1=(float) a.getHorizontal_Angle();
					System.out.println("blepw to aristero");
				}
				if(a.getName().equalsIgnoreCase(TeamState.getOppGoal2())){
					iseegoal2=true;
					Distance2=(float) a.getDistance();
					Angle2=(float) a.getHorizontal_Angle();
					System.out.println("blepw to aristero");
				}

				if(iseegoal1==true || iseegoal2==true){

					if(Angle1<Angle2){

					

						prefferedAngleMove=(Angle1+Angle2)/2;
					}

				}
				if(Ball.getDistance()>3){
					if(LocalizationResults.getBody_angle()+HingeJointPerceptor.getHj1()<-10){
						MotionTrigger.setMotion("TurnRight40");
					}else if(LocalizationResults.getBody_angle()+HingeJointPerceptor.getHj1()>10){
						MotionTrigger.setMotion("TurnLeft40");
					}else{
						MotionTrigger.setMotion("Forwards50");
					}
				}

			}

		}
	}
}
