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
