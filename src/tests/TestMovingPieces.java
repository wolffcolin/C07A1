/*
 * 
Class: TestMovingPieces
Description: Tests movement of the skeleton and bat
Authors: Colin Wolff and Matt McGrath
Date: 2/9/2024
Collaborators: N/A
Sources: N/A
*/

package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;

import src.gameEngine.Drawable;
import src.gameEngine.GameEngine;
import src.gameEngine.InteractionResult;
import src.levelPieces.Bat;
import src.levelPieces.Skeleton;
import src.levelPieces.Wall;

class TestMovingPieces {
	
	@Test
	void testSkeletonMovement() {
		
		//create board, skeleton and sets skeleton start to 6
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		Skeleton skeleton = new Skeleton('S', "skeleton", 6);
		
		gameBoard[6] = skeleton;
		
		//tests 200 times
		//checks if skeleton new location each turn is within +- 3
		for (int i = 0; i < 200; i++) {
			
			int oldIndex = skeleton.getLocation();
			
			ArrayList<Integer> possibleLocations = new ArrayList<>();
			
			int lowerLimit = oldIndex - 3;
			int upperLimit = oldIndex + 3;
			
			//if within range add to possible locations
			for (int j = 0; j < gameBoard.length; j++) {
				
				if (j > lowerLimit && j < upperLimit) {
					possibleLocations.add(j);
				}
				
			}
			
			skeleton.move(gameBoard, 13);
			
			int loc = skeleton.getLocation();
			
			assert(possibleLocations.contains(loc));
			
			
		}
	}
	
	@Test
	void testBatMovement() {
		
		//create board, obstacles and bat, set bat start to 6
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		Wall wall1 = new Wall('W', "wall", 2);
		Wall wall2 = new Wall('W', "wall", 4);
		Wall wall3 = new Wall('W', "wall", 13);
		Wall wall4 = new Wall('W', "wall", 19);
		
		gameBoard[2] = wall1;
		gameBoard[4] = wall2;
		gameBoard[13] = wall3;
		gameBoard[19] = wall4;
				
		
		Bat bat = new Bat('B', "bat", 6);
		
		gameBoard[6] = bat;
		
		//array of possible locations for bat to be to check against
		ArrayList<Integer> possibleLocations = new ArrayList<>();
		
		for (int j = 0; j < gameBoard.length; j++) {
			
			if (j != 2 && j != 4 && j != 13 && j != 19) {
				possibleLocations.add(j);
			}
			
		}
		
		//array of visit counts to ensure each spot is visited at some point in 200 turns
		Integer[] actualCounts = new Integer[GameEngine.BOARD_SIZE];
		
		for (int i = 0; i < actualCounts.length; i++) {
			actualCounts[i] = 0;
		}
		
		//run movement tests, 200 turns
		for (int i = 0; i < 200; i++) {
			
			bat.move(gameBoard, 20);
			
			int loc = bat.getLocation();
			
			actualCounts[loc]++;
			
			assert(possibleLocations.contains(loc));
			
			
		}
		
				
		//checks each spot in the actualCounts array to see if it's greater than 1	
		for (int i = 0; i < actualCounts.length; i++) {
			
			if (i != 2 && i != 4 && i != 13 && i != 19) {
				assert(actualCounts[i] > 1);
			}
		
		}
		
	}

}
