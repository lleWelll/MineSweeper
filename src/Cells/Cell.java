package Cells;

public abstract class Cell {
	protected final String CLOSED_CELL = "▢";
	protected boolean isCellOpen = false;

	public void openCell() {
		isCellOpen = true;
	}

	public abstract boolean hasBomb();

	public abstract void printCell();
}
