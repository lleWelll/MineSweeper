package MainGame;

import Constants.*;

import java.util.Scanner;

public class MineSweeper {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static boolean GameLost = false;
	private static boolean GameWon = false;


	public MineSweeper() {
	}
	public void playGame() {
		// Starting phase
		Constants.WELCOME_TEXT.print();
		String mode = SCANNER.next();
		GameField gameField = new GameField(mode);
		Constants.DIVISION_LINE.print();
		gameField.printGameField();

		// Main phase
		while (!GameLost && !GameWon) {
			Constants.COORDINATION_CHOICE.print();
			String input = SCANNER.next().toUpperCase();
			if (! Validator.isCorrectCoordination(input, gameField.getFieldSize())) {
				Constants.INCORRECT_COORDINATION_TEXT.print();
				continue;
			}
			char[] inputSymbols = input.toCharArray();
			String coordination = inputSymbols[0] + "" + inputSymbols[1];
			if (inputSymbols.length >= 3 && inputSymbols[2] == 'F') gameField.flagCell(coordination);
			else gameField.openCell(coordination);
			gameField.updateGameField();
			Constants.DIVISION_LINE.print();
			if (inputSymbols.length < 3 && gameField.cellHasBomb(coordination)) {
				GameLost = true;
				break;
			}
			if (gameField.allCellsOpened()) {
				GameWon = true;
				break;
			}
		}

		// Final phase
		if (GameLost) {
			Constants.LOSS_TEXT.print();
			gameField.openAllCells();
		}
		if (GameWon) {
			Constants.VICTORY_TEXT.print();
			gameField.openAllCells();
		}
	}
}
