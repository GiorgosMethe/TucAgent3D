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
