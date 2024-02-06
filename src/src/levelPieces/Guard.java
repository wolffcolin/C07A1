package src.levelPieces;

import java.util.Random;

import src.gameEngine.Drawable;
import src.gameEngine.InteractionResult;

public class Guard extends GamePiece implements Drawable{

	public Guard(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(super.getLocation() == playerLocation) {
			return InteractionResult.KILL;
		} else {
			return InteractionResult.NONE;
		}
		
	}

	public void draw() {
		System.out.print(symbol);
	}
	

}
