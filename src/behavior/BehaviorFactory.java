package behavior;

public class BehaviorFactory {


	SimpleBehavior Bh=new SimpleBehavior();

	public void BehaviorController(){

		if(BehaviorDone.isBehaviorDone()!=true){
			Bh.Act();
		}
	}

	

}
