package src.levelPieces;

import java.util.ArrayList;

import src.gameEngine.Drawable;
import src.gameEngine.Moveable;
import src.gameEngine.*;

public class LevelSetup {
	
	private Drawable[] elements;
	
	public LevelSetup() {
		elements = new GamePiece[GameEngine.BOARD_SIZE];
	}
	
	public void createLevel(int levelNum) {
		if (levelNum == 0) {
			
		} else if (levelNum == 1) {
			
		} else {
			System.out.println("Level number is incorrect");
		}
	} 

	public Drawable[] getBoard() {
		return elements;
	}

	public ArrayList<Moveable> getMovingPieces() {
		
		ArrayList<Moveable> movingPieces = new ArrayList<>();
		
		for (int i = 0; i < elements.length; i++) {
						
			if (elements[i] instanceof Moveable) {
				movingPieces.add((Moveable) elements[i]);
			} 
		}
		
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		
		ArrayList<GamePiece> allPieces = new ArrayList<>();
		
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] instanceof GamePiece) {
				allPieces.add((GamePiece) elements[i]);;
			}
		}
		
		ArrayList<GamePiece> interactingPieces = new ArrayList<>();
		
		for (int i = 0; i < allPieces.size(); i++) {
			for (int j = i + 1; j < allPieces.size(); j++) {
				if (allPieces.get(i).getLocation() == allPieces.get(j).getLocation()) {
					if (!interactingPieces.contains(allPieces.get(i))) {
						interactingPieces.add(allPieces.get(i));
					}
					
					if (!interactingPieces.contains(allPieces.get(j))) {
						interactingPieces.add(allPieces.get(j));					
					}
				}
			}
		}

		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		
		return 10;
		
	}
	
	
}
