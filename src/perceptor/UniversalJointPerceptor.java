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

package perceptor;

public class UniversalJointPerceptor {

	private float axis1, axis2;
	private String name;

	public UniversalJointPerceptor(String name) {
		this(name, 0.0f, 0.0f);
	}

	public UniversalJointPerceptor(String name, float axis1, float axis2) {
		this.name = name;
		this.axis1 = axis1;
		this.axis2 = axis2;
	}

	public float getAxis1() {

		return this.axis1;
	}

	public float getAxis2() {

		return this.axis2;
	}

	public void setAxis1(float axis1) {

		this.axis1 = axis1;
	}

	public void setAxis2(float axis2) {

		this.axis2 = axis2;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

}
