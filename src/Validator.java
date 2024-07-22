public class Validator {
	public static boolean isCorrectCoordination(String coordination, int fieldSize) {
		char[] coordinateSymbols = coordination.toCharArray();
		char coordinateLetter = coordinateSymbols[0]; //Получение буквы координаты
		int coordinateDigit = Character.getNumericValue(coordinateSymbols[1]); //Получение цифры координаты

		if (coordinateLetter >= 'A' && coordinateLetter <= (char)('A' + fieldSize - 1)) {
			if (coordinateDigit >= 1 && coordinateDigit <= fieldSize) {
				return true;
			}
		}
		return false;
	}
}
