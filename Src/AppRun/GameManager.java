package Src.AppRun;


import java.awt.Image;
import java.util.Scanner;

import Tools.SimpleWindow;


public class GameManager extends SimpleWindow{
    private int imgSize;
	private MatrixBoard board;
	Scanner scan = new Scanner(System.in);

	/** Skapar ett fönster som kan visa memorybrädet board. */
	public GameManager(MatrixBoard matrixBoard) {
		super(800, 800, "Game");
		

		this.board = matrixBoard;
		imgSize = 800 / board.getSize();
	}

	/**
	 * Ritar brädet med alla kort. Raderna och kolonnerna numreras från 0 och
	 * uppåt.
	 */
	public void drawBoard() {
		for (int r = 0; r < board.getSize(); r++) {
			for (int c = 0; c < board.getSize(); c++) {
				drawCard(r, c);
			}
		}
	}

	/** Ritar kortet på rad r, kolonn c. */
	public void drawCard(int r, int c) {
		int x0 = c * imgSize + 2;
		int y0 = r * imgSize + 2;
		moveTo(x0, y0);
		CardImage card = board.getCardImage(r, c);
		if (board.isRevealed(r, c)) {
			getAdvancedControls().drawImage(card.getFront().getScaledInstance(imgSize, imgSize, Image.SCALE_SMOOTH));
		} else {
		    getAdvancedControls().drawImage(card.getBack().getScaledInstance(imgSize, imgSize, Image.SCALE_SMOOTH));
		}
		moveTo(x0, y0);
		lineTo(x0 + imgSize, y0);
		lineTo(x0 + imgSize, y0 + imgSize);
		lineTo(x0, y0 + imgSize);
		lineTo(x0, y0);
	}

	/** Tar reda på raden för senaste musklick. */
	public int getMouseRow() {
		return getClickedY() / imgSize;
	}

	/** Tar reda på kolonnen för senaste musklick. */
	public int getMouseCol() {
		return getClickedX() / imgSize;

	}
    
}
