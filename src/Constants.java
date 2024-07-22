public enum Constants {
	WELCOME_TEXT("Hello, you are playing 'MineSweeper'\n" + "Enter preferred mode (easy, normal, hard)"),
	VICTORY_TEXT("\nYOU WIN!!"),
	LOSS_TEXT("\nYou lost("),
	COORDINATION_CHOICE("Enter cell to open (A1, B4, E2)"),
	INCORRECT_COORDINATION_TEXT("Entered wrong coordination, try again"),
	DIVISION_LINE("----------------------");

	private final String MESSAGE;
	Constants(String message) {
		this.MESSAGE = message;
	}
	public void print() {
		System.out.println(MESSAGE);
	}
}
