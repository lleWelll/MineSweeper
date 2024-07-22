import java.util.Scanner;

public class MineSweeper {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static boolean GameLost = false;
	private static boolean GameWon = false;


	public MineSweeper() {
	}
	public void playGame() throws InterruptedException {
		// Стартовая фаза
		Constants.WELCOME_TEXT.print();
		String mode = SCANNER.next();
		GameField gameField = new GameField(mode);
		Constants.DIVISION_LINE.print();
		gameField.printGameField();

		//Основная фаза игры
		while (!GameLost && !GameWon) {
			Constants.COORDINATION_CHOICE.print();
			String input = SCANNER.next();
			if (! Validator.isCorrectCoordination(input, gameField.getFieldSize())) {
				Constants.INCORRECT_COORDINATION_TEXT.print();
				continue;
			}
			gameField.openCell(input);
			gameField.updateGameField();
			if (gameField.cellHasBomb(input)) {
				GameLost = true;
				break;
			}
			if (gameField.allCellsOpened()) {
				GameWon = true;
				break;
			}
		}

		//Заключительная фаза игры
		if (GameLost) {
			Constants.LOSS_TEXT.print();
		}
		if (GameWon) {
			Constants.VICTORY_TEXT.print();
		}
	}
}
