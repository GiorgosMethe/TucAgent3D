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

public class GameState {

	public static float gameTime;
	public static String gameState;

	public GameState(float gameTime, String gameState) {

		gameTime = GameState.gameTime;
		gameState = GameState.gameState;

	}

	public static float getGameTime() {
		return gameTime;
	}

	public static void setGameTime(float gameTime) {
		GameState.gameTime = gameTime;
	}

	public static String getGameState() {
		return gameState;
	}

	public static void setGameState(String gameState) {
		GameState.gameState = gameState;
	}

}
