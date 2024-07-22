package MainGame.Cells;
import Constants.*;

public class NormalCell extends Cell {
	protected final String OPENED_CELL;

	public NormalCell(int bombsAround) {
		OPENED_CELL = cellText(bombsAround);
	}

	public NormalCell() {
		this.OPENED_CELL = "";
	}
	private String cellText(int bombsAround){
		switch (bombsAround) {
			case 0:
				return Constants.NORMAL_CELL_0.getText();
			case 1:
				return Constants.NORMAL_CELL_1.getText();
			case 2:
				return Constants.NORMAL_CELL_2.getText();
			case 3:
				return Constants.NORMAL_CELL_3.getText();
			case 4:
				return Constants.NORMAL_CELL_4.getText();
			case 5:
				return Constants.NORMAL_CELL_5.getText();
			case 6:
				return Constants.NORMAL_CELL_6.getText();
			case 7:
				return Constants.NORMAL_CELL_7.getText();
			case 8:
				return Constants.NORMAL_CELL_8.getText();
		}
		return "!";
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
