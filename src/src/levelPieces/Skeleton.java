/*
 
Class: Skeleton
Description: Child class of GamePiece that implements Moveable. The skeleton uses the move() method to allow the skeleton to move back and forth 3 spaces on the game board. If the player is within 2 spaces of the skeleton, then it interacts with the player and causes a hit.
Authors: Colin Wolff and Matt McGrath
Date: 2/5/2024
Collaborators: N/A
Sources: N/A
*/ 


package src.levelPieces;

import src.gameEngine.Moveable;
import src.gameEngine.GameEngine;
import src.gameEngine.Drawable;
import src.gameEngine.InteractionResult;


public class Skeleton extends GamePiece implements Moveable, Drawable {

	//variable to track where the skeleton is in its movement
	private int patrolLocation = 0;
	
	//direction the skeleton is going, + = right, - = left
	private int direction = 1;
	
	//constructor
	public Skeleton(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	//manages the interaction between a player and element
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		
		//logic to determine outcome
		if(playerLocation + 1 == super.getLocation()|| playerLocation -1 == super.getLocation()) {
			return InteractionResult.HIT;
		} else if(playerLocation + 2 == super.getLocation()|| playerLocation - 2 == super.getLocation()) {
			return InteractionResult.HIT;
		} else if(playerLocation == super.getLocation()) {
			return InteractionResult.HIT;
		} else {
			return InteractionResult.NONE;
		}
	}
	
	//draws symbol
	public void draw() {
		System.out.print(symbol);
	}

	@Override
	//movement logic
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		
		//keeps skeleton in its patrol range
		if(patrolLocation < 3) {
			patrolLocation++;
		} else {
			direction *= -1;
			patrolLocation = 0;
		}
		
		
		//current location of element
		int oldIndex = this.getLocation();
		
		//distance the skeleton will travel
		int travelDistance;
		
		//patrol forward
		if(direction == 1) {
			
			//keeps skeleton in bounds of map
			if (oldIndex + 1 >= GameEngine.BOARD_SIZE) {
				travelDistance = 1;
			} else {
				travelDistance = -1;
			}
			
		//patrol backwards
		} else {
			
			//keeps skeleton in bounds of map
			if (oldIndex - 1 <= 0) {
				travelDistance = -1;
			} else {
				travelDistance = 1;
			}
			
		}
		
		//sets location to new spot
		gameBoard[oldIndex + travelDistance] = gameBoard[oldIndex];
		gameBoard[oldIndex] = null;
		this.setLocation(oldIndex + travelDistance); 
		
		
	}
}
