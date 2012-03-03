package behavior;

import action.MotionTrigger;
import perceptor.Ball;
import perceptor.Vision;

public class Behavior {


	public void Act(){

		if(Vision.isiSee()==true){

			if(Ball.isSeeTheBall()==true){
				
				if(Ball.getDistance()>1){
					
					MotionTrigger.setMotion("Forwards");
				}else{
					
					MotionTrigger.setMotion("StopBehavior");
				}

			}else{
				MotionTrigger.setMotion("");
			}

		}else{
			
			MotionTrigger.setMotion("");
			
			
		}





	}



}
