package src.levelPieces;

import src.gameEngine.*;

public class wall implements Drawable{
	
	private char symbol;
	private String label;
	private int location;
	
	public wall(char symbol, String label, int location) {
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
		this.label = label;
		this.location = location;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(symbol);
	}

	public int getLocation() {
		return location;
	}
	
	public char getSymbol() {
		return symbol;
	}
}