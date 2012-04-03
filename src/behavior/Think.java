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
package behavior;

public class Think {
	
	BehaviorFactory Bh = new BehaviorFactory();
	Goalie Gb = new Goalie();
	ForwardCenter fc=new ForwardCenter();
	ForwardLeft fl=new ForwardLeft();
	ForwardRight fr=new ForwardRight();
	DefenderCenter dc=new DefenderCenter();
	DefenderLeft dl=new DefenderLeft();
	DefenderRight dr=new DefenderRight();
	
	
	public void Role(int number){
		
		if(number==1){
			Gb.BehaviorController();
		}else if(number==2){
			dr.BehaviorController();
		}else if(number==3){
			dc.BehaviorController();
		}else if(number==4){
			dl.BehaviorController();
		}else if(number==5){
			fr.BehaviorController();
		}else if(number==6){
			fl.BehaviorController();
		}else if(number==7){
			fc.BehaviorController();
		}else{
			System.err.println("error number (1-7)");
			System.exit(1);
		}
				
	}

}
