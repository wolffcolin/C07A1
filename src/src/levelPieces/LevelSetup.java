package src.levelPieces;

import java.util.ArrayList;

import src.gameEngine.Drawable;
import src.gameEngine.Moveable;
import src.gameEngine.*;
import src.levelPieces.*;

public class LevelSetup {
	
	private Drawable[] elements;
	
	public LevelSetup() {
		elements = new Drawable[GameEngine.BOARD_SIZE];
	}
	
	public void createLevel(int levelNum) {
		if (levelNum == 1) {
			Guard guard = new Guard('G', "guard", 1);
			Bat bat = new Bat('B', "bat", 3);
			Fairy fairy = new Fairy('F', "fairy", 12);
			Skeleton skeleton = new Skeleton('S', "skeleton", 18);
			Wall wall1 = new Wall('W', "wall", 2);
			Wall wall2 = new Wall('W', "wall", 15);	
			Mage mage = new Mage('M', "mage", 20);
			
			this.elements[guard.getLocation()] = guard;
			this.elements[bat.getLocation()] = bat;
			this.elements[fairy.getLocation()] = fairy;
			this.elements[skeleton.getLocation()] = skeleton;
			this.elements[wall1.getLocation()] = wall1;
			this.elements[wall2.getLocation()] = wall2;
			this.elements[mage.getLocation()] = mage;
			
		} else if (levelNum == 2) {
			Guard guard = new Guard('G', "guard", 20);
			Bat bat = new Bat('B', "bat", 5);
			Fairy fairy = new Fairy('F', "fairy", 18);
			Skeleton skeleton = new Skeleton('S', "skeleton", 4);
			Wall wall1 = new Wall('W', "wall", 19);
			Wall wall2 = new Wall('W', "wall", 6);	
			Mage mage = new Mage('M', "mage", 1);
			
			this.elements[0] = guard;
			this.elements[1] = bat;
			this.elements[2] = fairy;
			this.elements[3] = skeleton;
			this.elements[4] = wall1;
			this.elements[5] = wall2;
			this.elements[6] = mage;
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
		
		ArrayList<GamePiece> interactingPieces = new ArrayList<>();
		
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] instanceof GamePiece) {
				interactingPieces.add((GamePiece) elements[i]);;
			}
		}
		
		return interactingPieces;
		

	}

	public int getPlayerStartLoc() {
		
		return 10;
		
	}
	
	
}
