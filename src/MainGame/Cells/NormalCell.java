package MainGame.Cells;
import Constants.*;
import Exceptions.InvalidAmountOfBombsException;

public class NormalCell extends Cell {
	protected final String OPENED_CELL;

	public NormalCell(int bombsAround) {
		OPENED_CELL = cellText(bombsAround);
	}

	public NormalCell() {
		this.OPENED_CELL = "";
	}

	private String cellText(int bombsAround){
		return switch (bombsAround) {
			case 0 -> Constants.NORMAL_CELL_0.getText();
			case 1 -> Constants.NORMAL_CELL_1.getText();
			case 2 -> Constants.NORMAL_CELL_2.getText();
			case 3 -> Constants.NORMAL_CELL_3.getText();
			case 4 -> Constants.NORMAL_CELL_4.getText();
			case 5 -> Constants.NORMAL_CELL_5.getText();
			case 6 -> Constants.NORMAL_CELL_6.getText();
			case 7 -> Constants.NORMAL_CELL_7.getText();
			case 8 -> Constants.NORMAL_CELL_8.getText();
			default -> throw new InvalidAmountOfBombsException("Invalid amount of Bombs around cell");
		};
    }

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
		return false;
	}

}
