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

import java.util.ArrayList;
import java.util.Random;

import src.gameEngine.Drawable;
import src.gameEngine.InteractionResult;


public class Skeleton extends GamePiece implements Moveable, Drawable {
	
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
		
		//gather all empty spots on board
		ArrayList<Integer> emptySpots = new ArrayList<>();
		
		for (int i = 0; i < gameBoard.length; i++) {
			
			if (gameBoard[i] == null) {
				emptySpots.add(i);
			}
			
		}
		
		int oldIndex = this.getLocation();
		
		ArrayList<Integer> possibleSpots = new ArrayList<>();
		
		//creates possible range of movement
		int possibleRangeNeg = oldIndex - 3;
		int possibleRangePos = oldIndex + 3;
		
		//creates list of spots within +- 3
		for (int i = 0; i < emptySpots.size(); i++) {
			
			if (emptySpots.get(i) < possibleRangePos && emptySpots.get(i) > possibleRangeNeg) {
				possibleSpots.add(emptySpots.get(i));
			}
			
		}
		
		//randomly picks one of these spots
		Random rand = new Random();
		int randInt = rand.nextInt(possibleSpots.size());
		
		int newIndex = possibleSpots.get(randInt);
	
		gameBoard[newIndex] = gameBoard[oldIndex];
		gameBoard[oldIndex] = null;
		this.setLocation(newIndex);
		
		
	}
}
