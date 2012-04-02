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

package worldState;

public class TeamState {
	
	public static String TeamSide;
	public static String OppGoal1,OppGoal2;
	
	

	public static String getTeamSide() {
		return TeamSide;
	}

	public static void setTeamSide(String teamSide) {
		if(teamSide.equalsIgnoreCase("left")){
			setOppGoal1("g1r");
			setOppGoal2("g2r");
		}else if(teamSide.equalsIgnoreCase("right")){
			setOppGoal1("g1l");
			setOppGoal2("g2l");
		}
		TeamSide = teamSide;
	}

	public static String getOppGoal1() {
		return OppGoal1;
	}

	public static void setOppGoal1(String oppGoal1) {
		OppGoal1 = oppGoal1;
	}

	public static String getOppGoal2() {
		return OppGoal2;
	}

	public static void setOppGoal2(String oppGoal2) {
		OppGoal2 = oppGoal2;
	}
	
	
	
	
	
	

}
