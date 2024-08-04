package MainGame;

public class Validator {
	public static boolean isCorrectCoordination(String coordination, int fieldSize) {
		char[] coordinateSymbols = coordination.toCharArray();
		char coordinateLetter;
		int coordinateDigit;

		if (coordinateSymbols.length > 3) {
			return false;
		}
		if (coordinateSymbols.length >= 3 && coordinateSymbols[2] != 'F') {
			return false;
		}
		if (Character.isLetter(coordinateSymbols[0])) {
			coordinateLetter = coordinateSymbols[0]; //Getting letter of coordination
		} else {
			return false;
		}
		if (Character.isDigit(coordinateSymbols[1])) {
			coordinateDigit = Character.getNumericValue(coordinateSymbols[1]); //Getting digit of coordination
		} else {
			return false;
		}

		if (coordinateLetter >= 'A' && coordinateLetter <= (char) ('A' + fieldSize - 1)) {
			if (coordinateDigit >= 1 && coordinateDigit <= fieldSize) {
				return true;
			}
		}
		return false;
	}

	public static boolean isCorrectSizeOfField(int size) {
		return size >= 2 && size <= 9;
	}

	public static boolean isCorrectAmountsOfBombs(int amountOfBombs, int size) {
		return amountOfBombs < size * size && amountOfBombs > 0;
	}
}
