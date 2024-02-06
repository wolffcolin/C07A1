/*
 
Class: Bat
Description: Child class of GamePiece that implements Moveable, allowing the bat to move. The move method utilizes Java's random library to move the bat randomly, up to 2 spaces left or right. It interacts with the player, causing a hit if the player lands on the same square. 
Authors: Colin Wolff and Matt McGrath
Date: 2/5/2024
Collaborators: N/A
Sources: N/A
*/

package src.levelPieces;

import src.gameEngine.Moveable;

import java.util.Random;

import src.gameEngine.Drawable;
import src.gameEngine.GameEngine;
import src.gameEngine.InteractionResult;

public class Bat extends GamePiece implements Moveable, Drawable{

	//constructor
	public Bat(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	//logic to manage interactions
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		//logic to manage interactions
		if(playerLocation == super.getLocation()) {
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
	//logic to manage movement
	public void move(Drawable[] gameBoard, int playerLocation) {
		
		//setup for random num gen
		Random rand = new Random();
		int randInt = rand.nextInt(4);
		
		//old location of Bat
		int oldIndex = this.getLocation();
		
		//variable to hold offset
		int travelDistance;
		
		//move forward one
		if(randInt == 0) {
			
			if (oldIndex + 1 >= GameEngine.BOARD_SIZE) {
				travelDistance = 1;
			} else {
				travelDistance = -1;
			}
			
		//move backward one
		} else if(randInt == 1) {
			
			if (oldIndex - 1 <= 0) {
				travelDistance = -1;
			} else {
				travelDistance = 1;
			}
			
		//move forward two
		} else if (randInt == 2){
			
			if (oldIndex + 1 >= GameEngine.BOARD_SIZE) {
				travelDistance = 2;
			} else {
				travelDistance = -2;
			}
			
		//move backward two
		} else {
			
			if (oldIndex - 1 <= 0) {
				travelDistance = -2;
			} else {
				travelDistance = 2;
			}
			
			
		}
		
		//set location to new location in board
		gameBoard[oldIndex + travelDistance] = gameBoard[oldIndex];
		gameBoard[oldIndex] = null;
		this.setLocation(oldIndex + travelDistance); 



		
	}

}
