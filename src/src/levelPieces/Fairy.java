package src.levelPieces;

import src.gameEngine.Drawable;
import src.gameEngine.InteractionResult;

public abstract class Fairy extends GamePiece implements Drawable {

	public Fairy(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(super.getLocation() == playerLocation) {
			return InteractionResult.GET_POINT;
		} else {
			return InteractionResult.NONE;
		}

	}
	
	public void draw() {
		System.out.println(symbol);
	}

}
