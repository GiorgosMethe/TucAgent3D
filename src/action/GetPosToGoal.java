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

package action;

import behavior.BehaviorStateMachine;
import localization.BallPosition;
import localization.Landmark;
import localization.LocalizationResults;
import motions.MotionTrigger;
import perceptor.HingeJointPerceptor;
import worldState.TeamState;

public class GetPosToGoal {

	@SuppressWarnings("unused")
	private float distance1;
	@SuppressWarnings("unused")
	private float distance2;

	public void Act(){

		boolean iseegoal=false;
		distance1 = 0;
		distance2 = 0;
		float Angle1=0;
		float Angle2 = 0;
		float prefferedAngleKick=0;
		for(int k=0;k<LocalizationResults.getLandmarks().size();k++){
			Landmark a=LocalizationResults.getLandmarks().elementAt(k);
			
			if(a.getName().equalsIgnoreCase(TeamState.getOppGoal1())){
				iseegoal=true;
				distance1=(float) a.getDistance();
				Angle1=(float) a.getHorizontal_Angle();
				//System.out.println("blepw to aristero");
			}
			if(a.getName().equalsIgnoreCase(TeamState.getOppGoal2())){
				iseegoal=true;
				distance2=(float) a.getDistance();
				Angle2=(float) a.getHorizontal_Angle();
				//System.out.println("blepw to aristero");
			}

		}
		if(iseegoal==true){	
			
			prefferedAngleKick=(Angle1+Angle2)/2;
			
		}else{
			
			prefferedAngleKick=180;
			
		}
			

			if(Math.abs(LocalizationResults.getBody_angle()-prefferedAngleKick)>20){


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
