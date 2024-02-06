package src.levelPieces;

import src.gameEngine.Drawable;
import src.gameEngine.InteractionResult;

public abstract class Mage extends GamePiece {

	public Mage(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(playerLocation + 1 == super.getLocation() || playerLocation - 1 == super.getLocation()) {
			return InteractionResult.KILL;
		} else {
			return InteractionResult.NONE;
		}
	}

}
