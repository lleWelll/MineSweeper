package MainGame;

import Constants.Constants;
import Exceptions.*;
import MainGame.Cells.*;
import java.util.*;

public class GameField {
	private int fieldSize;
	private int amountOfBombs;
	private int numberOfOpenedCells;
	private final String[][] COORDINATES;
	private final String[][] COORDINATE_GRID;
	private final TreeMap<String, ? extends Cell> GAME_FIELD;

	public GameField() {
		easyMode();
		this.COORDINATES = createCoordinates();
		this.COORDINATE_GRID = createCoordinateGrid();
		this.GAME_FIELD = createGameField();
	}
	public GameField(String mode) {
		mode = mode.toLowerCase();
		switch (mode) {
			case "easy", "e" -> easyMode();
			case "normal", "n" -> normalMode();
			case "hard", "h" -> hardMode();
			case "custom", "c" -> customMode();
			default -> throw new InvalidModeException();
		}
		this.COORDINATES = createCoordinates();
		this.COORDINATE_GRID = createCoordinateGrid();
		this.GAME_FIELD = createGameField();
	}
	private void easyMode(){
		fieldSize = 5;
		amountOfBombs = 7;
	}
	private void normalMode(){
		fieldSize = 7;
		amountOfBombs = 15;
	}
	private void hardMode(){
		fieldSize = 9;
		amountOfBombs = 27;
	}
	private void customMode() {
		Scanner scan = new Scanner(System.in);
		Constants.ENTER_SIZE_OF_FIELD_AND_AMOUNT_OF_BOMBS.print();
		int size = scan.nextInt();
		int bombs = scan.nextInt();
		if (Validator.isCorrectSizeOfField(size)) fieldSize = size;
		else throw new InvalidSizeException();
		if (Validator.isCorrectAmountsOfBombs(bombs, fieldSize)) amountOfBombs = bombs;
		else throw new InvalidAmountOfBombsException();
	}

	private String[][] createCoordinates() {
		String[][] coordinates = new String[fieldSize][fieldSize];
		char currentSymbol = 'A';
		int currentDigit;
		for (int i = 0; i < fieldSize; i++) {
			currentDigit = 1;
			for (int j = 0; j < fieldSize; j++) {
				coordinates[i][j] = currentSymbol + "" + currentDigit;
				currentDigit++;
			}
			currentSymbol++;
		}
		return coordinates;
	}

	private String[][] createCoordinateGrid() {
		String[][] grid = new String[2][fieldSize];
		char currentSymbol = 'A';
		int currentDigit = 1;
		for (int i = 0; i < fieldSize; i++) {
			grid[0][i] = currentDigit + "";
			currentDigit++;
		}
		for (int i = 0; i < fieldSize; i++) {
			grid[1][i] = currentSymbol + "";
			currentSymbol++;
		}
		return grid;
	}

	private TreeMap<String, Cell> createGameField() {
		TreeMap<String, Cell> field = new TreeMap<>();
		Random rand = new Random();
		//Create empty game field
		for (int i = 0; i < fieldSize; i++) {
			for (int j = 0; j < fieldSize; j++) {
				field.put(COORDINATES[i][j], null);
			}
		}
		//Feeling with bombs
		for (int createdBombs = 0; createdBombs < amountOfBombs;) {
			int rowCoordinateIndex = rand.nextInt(fieldSize);
			int columnCoordinateIndex = rand.nextInt(fieldSize);
			String Coordinate = COORDINATES[rowCoordinateIndex][columnCoordinateIndex];
			if (field.get(Coordinate) == null) {
				field.put(Coordinate, new BombCell());
				createdBombs++;
			}
		}
		//Feeling with other
		for (String currentCoordinates : field.keySet()) {
			if (field.get(currentCoordinates) != null) {
				continue;
			}
			field.put(currentCoordinates, new NormalCell(amountOfBombs(currentCoordinates, field)));
		}
		return field;
	}

	private int amountOfBombs(String currentCoordinates, TreeMap<String, Cell> field) {
		int bombsCounter = 0;
		ArrayList<String> nearByCellsList = getNearByCells(currentCoordinates, field.keySet());
		for (String cell : nearByCellsList) {
			try {
				if (field.get(cell).hasBomb()) {
					bombsCounter++;
				}
			} catch (NullPointerException ignored) {
			}
		}
		return bombsCounter;
	}

	private ArrayList<String> getNearByCells(String currentCoordinates, Set<String> allCoordinates) {
		ArrayList<String> nearByCells = new ArrayList<>();
		char[] currentCoordinatesSymbols = currentCoordinates.toCharArray();
		char currentCoordinatesLetter = currentCoordinatesSymbols[0]; //Getting letter of current coordination
		int currentCoordinatesDigit = Character.getNumericValue(currentCoordinatesSymbols[1]); //Getting digit of current coordination

		for (String coordinatesElement : allCoordinates) {
			if (currentCoordinates.equals(coordinatesElement)) {
				continue;
			}
			char[] coordinatesSymbols = coordinatesElement.toCharArray();
			char coordinateLetter = coordinatesSymbols[0]; //Getting letter of coordination for compare
			int coordinateDigit = Character.getNumericValue(coordinatesSymbols[1]); //Getting digit of coordination for compare

			char plusCoordinateLetter = (char) (coordinateLetter + 1);
			char minusCoordinateLetter = (char) (coordinateLetter - 1);
			int plusCoordinateDigit = coordinateDigit + 1;
			int minusCoordinateDigit = coordinateDigit - 1;

			if (coordinateLetter == currentCoordinatesLetter
					|| plusCoordinateLetter == currentCoordinatesLetter
					|| minusCoordinateLetter == currentCoordinatesLetter) {
				if (coordinateDigit == currentCoordinatesDigit
						|| plusCoordinateDigit == currentCoordinatesDigit
						|| minusCoordinateDigit == currentCoordinatesDigit) {
					nearByCells.add(coordinatesElement);
				}
			}
		}
		return nearByCells;
	}

	public void printGameField() {
		System.out.print("\t");
		for (int i = 0; i < fieldSize; i++) {
			System.out.print(COORDINATE_GRID[0][i] + " ");
		}
		System.out.print("\n");
		Iterator<String> iterator = GAME_FIELD.keySet().iterator();
		for (int i = 0; i < fieldSize; i++) {
			System.out.print(COORDINATE_GRID[1][i] + "\t");
			for (int j = 0; j < fieldSize; j++) {
				GAME_FIELD.get(iterator.next()).printCell();
				System.out.print(" ");
			}
			System.out.print(" " + "\n");
		}
	}
	public void flagCell(String coordination) {
		GAME_FIELD.get(coordination).flagCell();
	}
	public void openCell(String coordination) {
		GAME_FIELD.get(coordination).openCell();
		this.numberOfOpenedCells++;
	}
	public void openAllCells() {
		for (String coordination : GAME_FIELD.keySet()) {
			GAME_FIELD.get(coordination).openCell();
		}
		updateGameField();
	}
	public boolean cellHasBomb(String coordination) {
		return GAME_FIELD.get(coordination).hasBomb();
	}
	public boolean allCellsOpened() {
		if (this.numberOfOpenedCells < (fieldSize * fieldSize) - amountOfBombs) {
			return false;
		}
		else {
			return true;
		}
	}
	public void updateGameField() {
		printGameField();
	}
	public int getFieldSize() {
		return fieldSize;
	}
}
