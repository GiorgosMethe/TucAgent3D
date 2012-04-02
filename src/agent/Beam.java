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


package agent;

public class Beam {

	public String Init(int number){

		String beam;
		String beamX = null;
		String beamY = null;
		String beamTheta = null;
		if(number==1){
			beamX="-11.0"; beamY="0.0"; beamTheta="0.0";
		}else if(number==2){
			beamX="-7.0"; beamY="-3.0"; beamTheta="0.0";
		}else if(number==3){
			 beamX="-7.0"; beamY="0.0"; beamTheta="0.0";
		}else if(number==4){
			beamX="-7.0"; beamY="3.0"; beamTheta="0.0";
		}else if(number==5){
			beamX="-3.0"; beamY="-3.0"; beamTheta="0.0";
		}else if(number==6){
			beamX="-3.0"; beamY="3.0"; beamTheta="0.0";
		}else if(number==7){
			beamX="-3.5"; beamY="0.0"; beamTheta="0.0";
		}else{
			
		}
		
		beam=beamX+" "+beamY+" "+beamTheta;

		return beam;
	}

}
