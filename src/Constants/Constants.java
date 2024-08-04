package Constants;

public enum Constants {
	WELCOME_TEXT("Hello, you are playing 'MainGame.MineSweeper'\n" + "Enter preferred mode (Easy, Normal, Hard, Custom)"),
	VICTORY_TEXT(Colors.YELLOW.getColor() + "\nYOU WIN!!" + Colors.RESET.getColor()),
	LOSS_TEXT(Colors.RED.getColor() + "\nYOU LOST(" + Colors.RESET.getColor()),
	COORDINATION_CHOICE("Enter cell to open (A1, B4, E2)"),
	INCORRECT_COORDINATION_TEXT("Entered wrong coordination, try again"),
	ENTER_SIZE_OF_FIELD_AND_AMOUNT_OF_BOMBS("Enter size of field (2 <= x <= 9) and amount of bombs (x < size^2)"),
	DIVISION_LINE("----------------------"),
	CLOSED_CELL("▢"),
	FLAGGED_CLOSED_CELL(Colors.RED.getColor() + "▢" + Colors.RESET.getColor()),
	BOMB_CELL(Colors.PURPLE.getColor() + "X" + Colors.RESET.getColor()),
	NORMAL_CELL_0(Colors.GRAY.getColor() + "0" + Colors.RESET.getColor()),
	NORMAL_CELL_1(Colors.CYAN.getColor() + "1" + Colors.RESET.getColor()),
	NORMAL_CELL_2(Colors.BLUE.getColor() + "2" + Colors.RESET.getColor()),
	NORMAL_CELL_3(Colors.GREEN.getColor() + "3" + Colors.RESET.getColor()),
	NORMAL_CELL_4(Colors.YELLOW.getColor() + "4" + Colors.RESET.getColor()),
	NORMAL_CELL_5(Colors.ORANGE.getColor() + "5" + Colors.RESET.getColor()),
	NORMAL_CELL_6(Colors.RED.getColor() + "6" + Colors.RESET.getColor()),
	NORMAL_CELL_7(Colors.RED.getColor() + "7" + Colors.RESET.getColor()),
	NORMAL_CELL_8(Colors.RED.getColor() + "8" + Colors.RESET.getColor());

	private final String MESSAGE;
	Constants(String message) {
		this.MESSAGE = message;
	}
	public void print() {
		System.out.println(MESSAGE);
	}
	public String getText() {
		return MESSAGE;
	}
}
