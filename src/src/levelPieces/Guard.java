/*
 
Class: Guard
Description: Child class of GamePiece. Overrides the interract method to cause a kill on a player if it lands on the same space. 
Authors: Colin Wolff and Matt McGrath
Date: 2/5/2024
Collaborators: N/A
Sources: N/A
*/

package src.levelPieces;

import src.gameEngine.Drawable;
import src.gameEngine.InteractionResult;

public class Guard extends GamePiece implements Drawable{

	//constructor
	public Guard(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	//interaction logic
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		
		//more interaction logic, if on player kill, if not nothing
		if(super.getLocation() == playerLocation) {
			return InteractionResult.KILL;
		} else {
			return InteractionResult.NONE;
		}
		
	}

	//draws symbol
	public void draw() {
		System.out.print(symbol);
	}
	

}
