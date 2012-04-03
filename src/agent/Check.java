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

package agent;

public class Check {
	
	public void Number(final int number){

		if(number>7){
			System.err.println("error number (1-7)");
			System.exit(1);
		}
		
		
	}

}
