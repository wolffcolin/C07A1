/*
 * 
Class: TestInteractions
Description: Tests interactions of all GamePieces
Authors: Colin Wolff and Matt McGrath
Date: 2/9/2024
Collaborators: N/A
Sources: N/A
*/

package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.gameEngine.Drawable;
import src.gameEngine.GameEngine;
import src.gameEngine.InteractionResult;
import src.levelPieces.Bat;
import src.levelPieces.Fairy;
import src.levelPieces.Guard;
import src.levelPieces.Mage;
import src.levelPieces.Skeleton;

class TestInteractions {
	
	@Test
	void testSkeleton() {
		//creates board, and skeleton and sets skeleton start to 10
        int skeletonLocation = 10;
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        Skeleton skeleton = new Skeleton('S', "skeleton", skeletonLocation);
        gameBoard[skeletonLocation] = skeleton;
        
        //test interactions that should result in a HIT
        //directly on the skeleton, one or two spaces away
        assertEquals(InteractionResult.HIT, skeleton.interact(gameBoard, skeletonLocation));
        assertEquals(InteractionResult.HIT, skeleton.interact(gameBoard, skeletonLocation - 1));
        assertEquals(InteractionResult.HIT, skeleton.interact(gameBoard, skeletonLocation + 1));
        assertEquals(InteractionResult.HIT, skeleton.interact(gameBoard, skeletonLocation - 2));
        assertEquals(InteractionResult.HIT, skeleton.interact(gameBoard, skeletonLocation + 2));
        
        //test interactions that should result in NONE
        //anywhere else on the board
        for (int i = 0; i < gameBoard.length; i++) {
            if (i < skeletonLocation - 2 || i > skeletonLocation + 2) { // Outside hit range
                assertEquals(InteractionResult.NONE, skeleton.interact(gameBoard, i), "Interaction at distance should result in NONE.");
            }
        }
		
	}
	@Test
	void testBat() {
		//creates board and bat and sets bat start to 10
		int batLocation = 10;
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Bat bat = new Bat('B', "bat", batLocation);
		gameBoard[batLocation] = bat;
		
        //test interaction at the same location should result in HIT
		assertEquals(InteractionResult.HIT, bat.interact(gameBoard, batLocation));
		
        //test interactions at any other location should result in NONE
		for (int i = 0; i < 10; i++) {
			assertEquals(InteractionResult.NONE, bat.interact(gameBoard, i));
		}
		
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, bat.interact(gameBoard, i));
		}
	}
	
	@Test
	void testFairy() {
		//creates board and fairy and sets fairy start to 10
		int fairyLocation = 10;
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Fairy fairy = new Fairy('F', "fairy", fairyLocation);
		gameBoard[fairyLocation] = fairy;
		
        //test interaction at the same location should result in GET_POINT
		assertEquals(InteractionResult.GET_POINT, fairy.interact(gameBoard, fairyLocation));
		
        //test interactions at any other location should result in NONE
		for (int i = 0; i < 10; i++) {
			assertEquals(InteractionResult.NONE, fairy.interact(gameBoard, i));
		}
		
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, fairy.interact(gameBoard, i));
		}
	}
	
	@Test
	void testGuard() {
		//creates board and guard and sets guard start to 10
		   int guardLocation = 10;
	        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
	        Guard guard = new Guard('G', "guard", guardLocation);
	        gameBoard[guardLocation] = guard;
	        
	        //test interaction at the same location should result in KILL
	        assertEquals(InteractionResult.KILL, guard.interact(gameBoard, guardLocation));
	        
	        //test interactions at any other location should result in NONE
	        for (int i = 0; i < gameBoard.length; i++) {
	            if (i != guardLocation) { // Any position other than the guard's location
	                assertEquals(InteractionResult.NONE, guard.interact(gameBoard, i));
	            }
	        }
	}
	
	@Test
	void testMage() {
		//creates board and mage and sets mage start to 10
		int mageLocation = 10;
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Mage mage = new Mage('M', "Mage", mageLocation);
		gameBoard[mageLocation] = mage;
		
        //test interactions at location 1 ahead or behind should result in KILL
		assertEquals(InteractionResult.KILL, mage.interact(gameBoard, mageLocation - 1));
		assertEquals(InteractionResult.KILL, mage.interact(gameBoard, mageLocation + 1));
		
        //test interactions at the same location should result in ADVANCE
		assertEquals(InteractionResult.ADVANCE, mage.interact(gameBoard, mageLocation));
		
        //test interactions at any other location should result in NONE
		for (int i = 0; i < 9; i++) {
			assertEquals(InteractionResult.NONE, mage.interact(gameBoard, i));
		}
		
		for (int i = 12; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, mage.interact(gameBoard, i));
		}
	}
	

}
