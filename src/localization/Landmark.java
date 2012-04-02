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

package localization;

public class Landmark {
	public String Name;
	public double Distance,Vertical_Angle,Horizontal_Angle;
	public Landmark (String name,double distance,double ver_angle, double hor_angle ){
		Name=name;
		Distance=distance;
		Vertical_Angle=ver_angle;
		Horizontal_Angle=hor_angle;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getDistance() {
		return Distance;
	}
	public void setDistance(double distance) {
		Distance = distance;
	}
	public double getVertical_Angle() {
		return Vertical_Angle;
	}
	public void setVertical_Angle(double vertical_Angle) {
		Vertical_Angle = vertical_Angle;
	}
	public double getHorizontal_Angle() {
		return Horizontal_Angle;
	}
	public void setHorizontal_Angle(double horizontal_Angle) {
		Horizontal_Angle = horizontal_Angle;
	}
}