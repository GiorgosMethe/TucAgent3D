package behavior;

import action.TurnToSeeBall;
import perceptor.Ball;
import perceptor.Vision;

public class BehaviorFactory {

	TurnToSeeBall bh=new TurnToSeeBall();
	
	public void BehaviorController(){
		
		System.out.println(""+BehaviorStateMachine.getState());

		if(BehaviorStateMachine.getName().equalsIgnoreCase("doNothing")){

			
			
			
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

				if(BehaviorDone.isBehaviorDone()!=true){
					bh.Act();					
				}
				BehaviorStateMachine.setState("start");
				

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("NotSeeBall")){
				
				if(BehaviorDone.isBehaviorDone()!=true){
					bh.Act();	
				}
				BehaviorStateMachine.setState("start");
				
				

			}


		}


	}



}
