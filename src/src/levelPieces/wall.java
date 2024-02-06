/*
 
Class: Wall
Description: Only implements drawable, allowing it to be seen on the game board.
Authors: Colin Wolff and Matt McGrath
Date: 2/5/2024
Collaborators: N/A
Sources: N/A
*/

package src.levelPieces;

import src.gameEngine.*;

public class Wall implements Drawable {
	
	private char symbol;
	private String label;
	private int location;
	
	//constructor
	public Wall(char symbol, String label, int location) {
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
		this.label = label;
		this.location = location;
	}

	@Override
	//draws symbol
	public void draw() {
		// TODO Auto-generated method stub
		System.out.print(symbol);
	}

	//return loc
	public int getLocation() {
		return location;
	}
	
	//return sym
	public char getSymbol() {
		return symbol;
	}
}
