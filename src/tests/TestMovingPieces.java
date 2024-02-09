package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.gameEngine.Drawable;
import src.gameEngine.GameEngine;
import src.gameEngine.InteractionResult;
import src.levelPieces.Skeleton;

class TestMovingPieces {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testSkeletonMovement() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Skeleton skeleton = new Skeleton('S', "skeleton", 10);
		gameBoard[10] = skeleton;
		
		assertEquals(InteractionResult.HIT, skeleton.interact(gameBoard, 10));
		
		for (int i = 0; i < 10; i++) {
			assertEquals(InteractionResult.HIT, skeleton.interact(gameBoard, i));
		}
		
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, skeleton.interact(gameBoard, i));
		}
		
	}

}
