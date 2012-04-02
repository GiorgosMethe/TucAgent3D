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

package behavior;

import localization.BallPosition;
import motions.MotionTrigger;
import perceptor.Ball;
import perceptor.HingeJointPerceptor;
import perceptor.Vision;
import action.GetPosToGoal;
import action.GetUp;
import action.GoToPos;
import action.Kick;
import action.StandUp;
import action.TurnOver;
import action.TurnToBall;
import action.TurnToSeeBall;
import action.WalkToBall;

public class ForwardCenter {
	
	TurnToSeeBall tTsB=new TurnToSeeBall();
	TurnToBall tTb=new TurnToBall();
	WalkToBall wTb=new WalkToBall();
	Kick Kb=new Kick();
	GetPosToGoal gPtG = new GetPosToGoal();
	GoToPos gTp= new GoToPos();
	StandUp sU=new StandUp();
	TurnOver tO=new TurnOver();
	GetUp gU=new GetUp();

	public void BehaviorController(){



		////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////go kick the ball////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////




		if(BehaviorStateMachine.getName().equalsIgnoreCase("goKickTheBall")){

			if(BehaviorStateMachine.getState().equalsIgnoreCase("start")){

				if(Vision.isiSee()==true){

					if(Ball.isSeeTheBall()==true){

						BehaviorStateMachine.setState("iSeeBall");

					}else{

						BehaviorStateMachine.setState("NotSeeBall");

					}

				}else{

					BehaviorStateMachine.setState("start");

				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("iSeeBall")){

				tTb.Act();
				BehaviorStateMachine.setState("walkToBall");


			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("NotSeeBall")){


				tTsB.Act();

				BehaviorStateMachine.setState("start");

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("goBall")){

				if(Ball.getDistance()>0.5){
					wTb.Act();
					BehaviorStateMachine.setState("goBall");
				}else{
					BehaviorStateMachine.setState("StraightToBall");


				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("StraightToBall")){

				if(Math.abs((HingeJointPerceptor.getHj1()+BallPosition.getAngle()))>15){

					if(HingeJointPerceptor.getHj1()>0){
						MotionTrigger.setMotion("TurnLeft40");

					}else{
						MotionTrigger.setMotion("TurnRight40");

					}
					
				}else{
					BehaviorStateMachine.setState("Kick");
				}	

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("Kick")){

				if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("")){
					BehaviorDone.setBehaviorDone(false);
					BehaviorDone.setName("Kick");
					Kb.Act();				
					BehaviorStateMachine.setState("Kick");
				}else if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("Kick")){
					BehaviorDone.setName("");
					BehaviorDone.setBehaviorDone(true);
					BehaviorStateMachine.setState("start");
				}else{

				}
			}






			////////////////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////kick the ball to goal////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////






		}else if(BehaviorStateMachine.getName().equalsIgnoreCase("KickTheBallToGoal")){

			if(BehaviorStateMachine.getState().equalsIgnoreCase("start")){

				if(Vision.isiSee()==true){

					if(Ball.isSeeTheBall()==true){

						BehaviorStateMachine.setState("iSeeBall");

					}else{

						BehaviorStateMachine.setState("NotSeeBall");

					}

				}else{

					BehaviorStateMachine.setState("start");

				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("iSeeBall")){

				tTb.Act();
				BehaviorStateMachine.setState("walkToBall");


			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("NotSeeBall")){


				tTsB.Act();

				BehaviorStateMachine.setState("start");

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("walkToBall")){

				if(Ball.getDistance()>0.6){
					wTb.Act();
					BehaviorStateMachine.setState("walkToBall");
				}else{
					BehaviorStateMachine.setState("GetPosToGoal");


				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("GetPosToGoal")){

				gPtG.Act();


			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("goBall")){

				if(Ball.getDistance()>0.5){
					wTb.Act();
					BehaviorStateMachine.setState("goBall");
				}else{
					BehaviorStateMachine.setState("StraightToBall");


				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("StraightToBall")){

				if(Math.abs((HingeJointPerceptor.getHj1()+BallPosition.getAngle()))>15){

					if(HingeJointPerceptor.getHj1()>0){
						MotionTrigger.setMotion("TurnLeft40");

					}else{
						MotionTrigger.setMotion("TurnRight40");

					}
					
				}else{
					BehaviorStateMachine.setState("Kick");
				}


			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("Kick")){

				if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("")){
					BehaviorDone.setBehaviorDone(false);
					BehaviorDone.setName("Kick");
					Kb.Act();				
					BehaviorStateMachine.setState("Kick");
				}else if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("Kick")){
					BehaviorDone.setName("");
					BehaviorDone.setBehaviorDone(true);
					BehaviorStateMachine.setState("start");
				}else{

				}
			}


			////////////////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////go to position///////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////

		}else if(BehaviorStateMachine.getName().equalsIgnoreCase("goToPos")){

			if(BehaviorStateMachine.getState().equalsIgnoreCase("start")){

				if(Vision.isiSee()==true){

					if(Ball.isSeeTheBall()==true){

						BehaviorStateMachine.setState("iSeeBall");

					}else{

						BehaviorStateMachine.setState("NotSeeBall");

					}

				}else{

					BehaviorStateMachine.setState("start");

				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("iSeeBall")){

				if(Ball.getDistance()>3){

					gTp.Act();
					BehaviorStateMachine.setState("start");

				}else{
					MotionTrigger.setMotion("");
					BehaviorStateMachine.setState("start");
				}


			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("NotSeeBall")){


				tTsB.Act();

				BehaviorStateMachine.setState("start");

			}

			//////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////robot fall//////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////////

		}else if(BehaviorStateMachine.getName().equalsIgnoreCase("Fallen")){

			if(BehaviorStateMachine.getState().equalsIgnoreCase("start")){
				BehaviorDone.setName("");
				BehaviorDone.setBehaviorDone(true);
				BehaviorStateMachine.setState("turnOver");

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("turnOver")){

				if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("")){
					BehaviorDone.setBehaviorDone(false);
					BehaviorDone.setName("turnOver");
					tO.Act();				
				}else if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("turnOver")){
					BehaviorDone.setName("");
					BehaviorDone.setBehaviorDone(true);
					BehaviorStateMachine.setState("standup");
				}else{

				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("standup")){

				if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("")){
					BehaviorDone.setBehaviorDone(false);
					BehaviorDone.setName("standup");
					sU.Act();				
				}else if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("standup")){
					BehaviorDone.setName("");
					BehaviorDone.setBehaviorDone(true);
					BehaviorStateMachine.setState("getup");
				}else{

				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("getup")){

				if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("")){
					BehaviorDone.setBehaviorDone(false);
					BehaviorDone.setName("getup");
					gU.Act();				
				}else if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("getup")){
					BehaviorDone.setName("");
					BehaviorDone.setBehaviorDone(true);
					BehaviorStateMachine.setState("KickTheBallToGoal");
					BehaviorStateMachine.setName("start");
				}else{

				}





			}


		}










	}


}
