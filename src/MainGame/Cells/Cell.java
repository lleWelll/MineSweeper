package MainGame.Cells;


import Constants.Constants;

public abstract class Cell {
	protected final String CLOSED_CELL = Constants.CLOSED_CELL.getText();
	protected final String FLAGGED_CLOSED_CELL = Constants.FLAGGED_CLOSED_CELL.getText();
	protected boolean isCellOpen = false;
	protected boolean isCellFlagged = false;

	public void flagCell() {
		isCellFlagged = true;
	}

	public void openCell() {
		isCellOpen = true;
	}

	public abstract boolean hasBomb();

	public abstract void printCell();
}
