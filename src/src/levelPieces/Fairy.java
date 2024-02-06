/*
 
Class: Fairy
Description: Child class of GamePiece, uses the interact method to give the player a point if the player lands on the same space.
Authors: Colin Wolff and Matt McGrath
Date: 2/5/2024
Collaborators: N/A
Sources: N/A
*/

package src.levelPieces;

import src.gameEngine.Drawable;
import src.gameEngine.InteractionResult;

public class Fairy extends GamePiece implements Drawable {

	//constructor
	public Fairy(char symbol, String label, int location) {
		super(symbol, label, location);

	}

	@Override
	//interaction logic
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {

		//logic: if on player kill, otherwise nothing
		if(super.getLocation() == playerLocation) {
			return InteractionResult.GET_POINT;
		} else {
			return InteractionResult.NONE;
		}

	}
	
	//draws symbol
	public void draw() {
		System.out.print(symbol);
	}

}
