package src.levelPieces;

import src.gameEngine.Moveable;
import src.gameEngine.GameEngine;
import src.gameEngine.Drawable;
import src.gameEngine.InteractionResult;


public abstract class Skeleton extends GamePiece implements Moveable, Drawable {
	private int patrolLocation = 0;
	private int direction = 1;
	
	public Skeleton(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
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
	
	
	public void move() {
		if(patrolLocation < 3) {
			patrolLocation++;
		} else {
			direction *= -1;
			patrolLocation = 0;
		}
		
		if(direction == 1) {
			super.setLocation(getLocation()+1);
		} else {
			super.setLocation(getLocation()-1);
		}
	}
	
	public void draw() {
		System.out.println(symbol);
	}
}
