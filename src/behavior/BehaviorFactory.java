package behavior;

import action.GetKickablePosition;
import action.GetPosToGoal;
import action.Kick;
import action.MotionTrigger;
import action.TurnToBall;
import action.TurnToSeeBall;
import action.WalkToBall;
import perceptor.Ball;
import perceptor.Vision;

public class BehaviorFactory {

	TurnToSeeBall tTsB=new TurnToSeeBall();
	TurnToBall tTb=new TurnToBall();
	WalkToBall wTb=new WalkToBall();
	Kick Kb=new Kick();
	GetKickablePosition gKp = new GetKickablePosition();
	GetPosToGoal gPtG = new GetPosToGoal();

	public void BehaviorController(){

		System.out.println("Behavior:   "+BehaviorStateMachine.getState());
		System.out.println("Motion   :"+MotionTrigger.getMotion());
	
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

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("walkToBall")){

				if(Ball.getDistance()>0.5){
					wTb.Act();
					BehaviorStateMachine.setState("walkToBall");
				}else{

					BehaviorStateMachine.setState("closeToBall");


				}
				
			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("closeToBall")){
				
				if(Ball.isKickable()==true){
					BehaviorStateMachine.setState("Kick");
				}else{
					gKp.Act();
					BehaviorStateMachine.setState("closeToBall");
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

				if(Ball.getDistance()>0.5){
					wTb.Act();
					BehaviorStateMachine.setState("walkToBall");
				}else{
					BehaviorStateMachine.setState("GetPosToGoal");


				}
				
			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("GetPosToGoal")){

				
					gPtG.Act();
					BehaviorStateMachine.setState("GetPosToGoal");
				
				
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

		}


	}


}
