/*
 
Class: Mage
Description: Child class of gamepiece, uses the interact method to kill the player if they land within 1 space of the mage. If the player lands on the same space as the mage, it does not kill the player.
Authors: Colin Wolff and Matt McGrath
Date: 2/5/2024
Collaborators: N/A
Sources: N/A
*/

package src.levelPieces;

import src.gameEngine.Drawable;
import src.gameEngine.InteractionResult;

public class Mage extends GamePiece implements Drawable {

	//constructor
	public Mage(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	//interaction logic
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		//if near player, kill, if on, advance, if far then nothing
		if(playerLocation + 1 == super.getLocation() || playerLocation - 1 == super.getLocation()) {
			return InteractionResult.KILL;
		} else if (super.getLocation() == playerLocation) {
			return InteractionResult.ADVANCE;
		} else {
			return InteractionResult.NONE;
		}
	}
	
	//draw symbol
	public void draw() {
		System.out.print(symbol);
	}

}
