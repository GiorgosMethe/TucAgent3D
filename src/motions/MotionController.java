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

package motions;
import behavior.BehaviorDone;
import connection.Connection;
import connection.ServerCyrcles;


public class MotionController {

	private String Str;
	Connection con;

	private int endMotionPose;
	private int speedControl;
	private int speed; 
	private int poseOffset;

	public MotionController(){


	}

	public String MotionFactory(String Motion){

		int Current=ServerCyrcles.getCyrclesNow();
		int pose=0;
		Str="";
		Motions dnc=new Motions();
		double hardness=1;


		if (Motion.equalsIgnoreCase("Forwards50")){

			endMotionPose=135;
			speed=3;
			speedControl=10;
			poseOffset=2;

		}else if (Motion.equalsIgnoreCase("Forwards")){

			endMotionPose=40;
			speed=3;
			speedControl=10;
			poseOffset=2;
			
		}else if (Motion.equalsIgnoreCase("TurnRight40")){

			endMotionPose=72;
			speed=3;
			speedControl=10;
			poseOffset=2;
			
		}else if (Motion.equalsIgnoreCase("TurnLeft40")){

			endMotionPose=72;
			speed=3;
			speedControl=10;
			poseOffset=2;
					
		}else if (Motion.equalsIgnoreCase("SideStepLeft")){

			endMotionPose=124;
			speed=2;
			speedControl=10;
			poseOffset=2;
			hardness=0.7;
			
		}else if (Motion.equalsIgnoreCase("SideStepRight")){

			endMotionPose=145;
			speed=2;
			speedControl=10;
			poseOffset=2;
			hardness=0.7;
			
		}else if (Motion.equalsIgnoreCase("KickForwardRight")){

			endMotionPose=61;
			speed=3;
			speedControl=9;
			poseOffset=1;
			
		}else if (Motion.equalsIgnoreCase("KickForwardLeft")){

			endMotionPose=61;
			speed=3;
			speedControl=9;
			poseOffset=1;
						
		}else if (Motion.equalsIgnoreCase("Init")){

			endMotionPose=6;
			speed=3;
			speedControl=10;
			poseOffset=1;
			
		}else if (Motion.equalsIgnoreCase("leftFall")){

			endMotionPose=9;
			speed=3;
			speedControl=10;
			poseOffset=1;
						
					
		}else if (Motion.equalsIgnoreCase("KickSideRight")){

			endMotionPose=38;
			speed=3;
			speedControl=10;
			poseOffset=1;
			
		}else if (Motion.equalsIgnoreCase("TurnOver")){

			//endMotionPose=35;
			endMotionPose=16;
			speed=30;
			speedControl=40;
			poseOffset=1;
			
		}else if (Motion.equalsIgnoreCase("StandUpFromFront")){

			endMotionPose=23;
			speed=15;
			speedControl=30;
			poseOffset=1;

		}else if (Motion.equalsIgnoreCase("Backwards")){

			endMotionPose=66;
			speed=3;
			speedControl=10;
			poseOffset=2;

		}else{

			if(CurrentMotion.CurrentMotionPlaying.equalsIgnoreCase("")){
				return "";
			}else{
			
				return dnc.StopBehavior();
			}
		}


		//there is no any motion in progress
		if(CurrentMotion.getCurrentMotionPlaying().equalsIgnoreCase("")){
			//System.out.println("there is no any motion in progress");
			CurrentMotion.setCurrentMotionPlaying(Motion);
			return "";

		}else if(CurrentMotion.getCurrentMotionPlaying().equalsIgnoreCase(Motion)){
			//System.out.println("play the same");
			if((Current-CurrentMotion.getStartMotionCyrcles())%speed==0){
				int previousPose=CurrentMotion.getMotionPose();
				pose=previousPose+poseOffset;
				//System.out.println("current pose playing:"+pose);
				CurrentMotion.setMotionPose(pose);

				if (pose >= endMotionPose){
					CurrentMotion.setPoseEnding(true);
					BehaviorDone.setBehaviorDone(true);
					CurrentMotion.setStartMotionCyrcles(0);			
					CurrentMotion.setEndMotionCyrcles(0);
					CurrentMotion.setCurrentMotionCyrcles(0);
					CurrentMotion.setMotionPose(0);
					MotionTrigger.setMotion("");
					return dnc.StopBehavior();

				}else{
					CurrentMotion.setMotionPose(pose);
					return dnc.Motion(Motion,pose,speedControl,hardness);
				}

			}

		}else{
			
				CurrentMotion.setInitCyrcles(0);
				CurrentMotion.setCurrentMotionPlaying(Motion);
				CurrentMotion.setStartMotionCyrcles(Current);
				CurrentMotion.setMotionPose(0);
				CurrentMotion.setPoseEnding(false);

				return "";

		}
		return Str;


	}


}
