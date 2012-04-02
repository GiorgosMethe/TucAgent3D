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

package connection;
import connection.Connection;
public class ServerCyrcles {
	
	
	static int Cyrcles=0;;
	Connection con;
	
	public static int getCyrclesNow() {
		return Cyrcles;
	}


	public static void setCyrclesNow(int cyrcles) {
		Cyrcles = cyrcles;
	}
	
	
	
	

}
