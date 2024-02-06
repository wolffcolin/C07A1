package src.levelPieces;

import src.gameEngine.Moveable;

import java.util.Random;

import src.gameEngine.Drawable;
import src.gameEngine.InteractionResult;

public abstract class Bat extends GamePiece implements Moveable, Drawable{

	public Bat(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(playerLocation == super.getLocation()) {
			return InteractionResult.HIT;
		} else {
			return InteractionResult.NONE;
		}
		
	}
	
	public void move() {
		Random rand = new Random();
		int randInt = rand.nextInt(4);
		if(randInt == 0) {
			super.setLocation(super.getLocation() + 1);
		} else if(randInt == 1) {
			super.setLocation(super.getLocation() - 1);
		} else if (randInt == 2){
			super.setLocation(super.getLocation() + 2);
		} else {
			super.setLocation(super.getLocation() - 2);
		}
	}
	
	public void draw() {
		System.out.println(symbol);
	}

}
