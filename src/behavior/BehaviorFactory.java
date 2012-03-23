package behavior;

import action.GetKickablePosition;
import action.TurnToBall;
import action.TurnToSeeBall;
import action.WalkToBall;
import perceptor.Ball;
import perceptor.Vision;

public class BehaviorFactory {

	TurnToSeeBall tTsB=new TurnToSeeBall();
	TurnToBall tTb=new TurnToBall();
	WalkToBall wTb=new WalkToBall();
	GetKickablePosition gKp=new GetKickablePosition();

	public void BehaviorController(){

		System.out.println(""+BehaviorStateMachine.getState());
	
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

					BehaviorStateMachine.setState("iReachTheBall");


				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("iReachTheBall")){

				if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("")){
					BehaviorDone.setBehaviorDone(false);
					BehaviorDone.setName("kick");
					gKp.Act();				
					BehaviorStateMachine.setState("iReachTheBall");
				}else if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("kick")){
					BehaviorDone.setName("");
					BehaviorDone.setBehaviorDone(true);
					BehaviorStateMachine.setState("start");
				}else{
					
				}
			}

		}


	}


}
