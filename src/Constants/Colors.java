package Constants;

public enum Colors {
	RESET("\033[0m"),
	PURPLE("\033[35m"),
	RED("\033[0;31m"),
	ORANGE("\033[38;5;208m"),
	YELLOW("\033[0;33m"),
	GREEN("\033[32m"),
	BLUE("\033[0;34m"),
	CYAN("\033[0;36m"),
	GRAY("\033[90m");

	private final String COLOR;
	Colors(String color) {
		this.COLOR = color;
	}
	public String getColor() {
		return COLOR;
	}
}
