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

package perceptor;


//import javax.vecmath.Vector3d;

import javax.vecmath.Vector3d;

//import org.apache.commons.math.geometry.Vector3D;


public class ForceResistancePerceptor {
	// point where the force acts
	public static Vector3d forceOrigin;

	// the force itself
	public static Vector3d force;
	
	public static String name;

	/**
	 * Default constructor, initializes origin and force to (0.0, 0.0, 0.0)
	 * @param name the name of the sensor
	 */	
	public ForceResistancePerceptor(String name, float fox, float foy,
			float foz, float fx, float fy, float fz)
	{
		name = ForceResistancePerceptor.name;
		forceOrigin = new Vector3d(fox, foy, foz);
		force = new Vector3d(fx, fy, fz);
	}

	public Vector3d getForceOrigin()
	{
		return forceOrigin;
	}

	public Vector3d getForce()
	{
		return force;
	}

	public static void setForceOrigin(Vector3d forceOr) {
		ForceResistancePerceptor.forceOrigin = forceOr;
	}

	public static void setForce(Vector3d force) {
		ForceResistancePerceptor.force = force;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		ForceResistancePerceptor.name = name;
	}

	
	
}