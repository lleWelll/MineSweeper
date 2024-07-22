package MainGame.Cells;
import Constants.*;

public class BombCell extends Cell {
	protected final String OPENED_CELL = Constants.BOMB_CELL.getText();
	@Override
	public void printCell() {
		if (isCellOpen) {
			System.out.print(OPENED_CELL);
		} else {
			if (isCellFlagged) System.out.print(FLAGGED_CLOSED_CELL);
			else System.out.print(CLOSED_CELL);
		}
	}

	@Override
	public boolean hasBomb() {
		return true;
	}
}
