package behavior;

import action.TurnToBall;
import perceptor.Ball;
import perceptor.Vision;

public class BehaviorFactory {


	


	public void BehaviorController(){
		
		System.out.println(""+BehaviorStateMachine.getState());

		if(BehaviorStateMachine.getName().equalsIgnoreCase("simpleBehavior")){
			
			if(BehaviorStateMachine.getState().equalsIgnoreCase("startup")){
				
				if(Vision.isiSee()==true){
					
					if(Ball.isSeeTheBall()==true){
						BehaviorStateMachine.setState("iseetheball");
					}
				}
				
			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("iseetheball")){
				
				if(BehaviorDone.isBehaviorDone()!=true){
					TurnToBall.Act();
					
				}
				
				
				
			}
			

			
		}
		
		
	}

	

}
