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
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Skeleton skeleton = new Skeleton('S', "skeleton", 10);
		gameBoard[10] = skeleton;
		
		for(int i = 8; i < 13; i++) {
			assertEquals(InteractionResult.HIT, skeleton.interact(gameBoard, i));
		}
		
		
		for (int i = 0; i < 10; i++) {
			assertEquals(InteractionResult.HIT, skeleton.interact(gameBoard, i));
		}
		
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, skeleton.interact(gameBoard, i));
		}
		
	}
	@Test
	void testBat() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Bat bat = new Bat('B', "bat", 10);
		gameBoard[10] = bat;
		
		assertEquals(InteractionResult.HIT, bat.interact(gameBoard, 10));
		
		for (int i = 0; i < 10; i++) {
			assertEquals(InteractionResult.NONE, bat.interact(gameBoard, i));
		}
		
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, bat.interact(gameBoard, i));
		}
	}
	
	@Test
	void testFairy() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Fairy fairy = new Fairy('F', "fairy", 10);
		gameBoard[10] = fairy;
		
		assertEquals(InteractionResult.GET_POINT, fairy.interact(gameBoard, 10));
		
		for (int i = 0; i < 10; i++) {
			assertEquals(InteractionResult.NONE, fairy.interact(gameBoard, i));
		}
		
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, fairy.interact(gameBoard, i));
		}
	}
	
	@Test
	void testGuard() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Guard guard = new Guard('G', "guard", 10);
		gameBoard[10] = guard;
		
		assertEquals(InteractionResult.KILL, guard.interact(gameBoard, 10));
		
		for (int i = 0; i < 10; i++) {
			assertEquals(InteractionResult.NONE, guard.interact(gameBoard, 10));
		}
		
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, guard.interact(gameBoard, 10));
		}
	}
	
	@Test
	void testMage() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Mage mage = new Mage('M', "Mage", 10);
		gameBoard[10] = mage;
		
		assertEquals(InteractionResult.HIT, mage.interact(gameBoard, 9));
		assertEquals(InteractionResult.HIT, mage.interact(gameBoard, 11));
		assertEquals(InteractionResult.ADVANCE, mage.interact(gameBoard, 10));
		
		for (int i = 0; i < 9; i++) {
			assertEquals(InteractionResult.NONE, mage.interact(gameBoard, i));
		}
		
		for (int i = 12; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, mage.interact(gameBoard, i));
		}
	}
	

}
