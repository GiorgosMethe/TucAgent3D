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

import java.util.Vector;

public class GetMessageAsVector {

	public Vector<String> message = new Vector<String>();

	public GetMessageAsVector() {

	}

	public Vector<String> getMessage(String msg) {

		int length;
		length = msg.length();

		int start = 0;
		int end = 0;
		char[] valueOf;
		valueOf = msg.toCharArray();
		for (int i = 0; i < length+1; i++) {

			if(i==length){
				message.add("end");
			}else{
				
			
			
			if (valueOf[i] == '(') {
				start = i;

			} else if (valueOf[i] == '(' || valueOf[i] == ' '
					|| valueOf[i] == ')') {

				end = i;
				if (end > i - 1) {
					if (msg.substring(start + 1, end).equalsIgnoreCase("")) {

					} else {
						message.add(msg.substring(start + 1, end));
					}

					start = end;
				}

			}

			}
		}

		return message;

	}

}
