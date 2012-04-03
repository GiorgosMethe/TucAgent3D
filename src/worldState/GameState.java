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
