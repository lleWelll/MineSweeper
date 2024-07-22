package Cells;

public class NormalCell extends Cell {
	protected final String OPENED_CELL; //Содержит строку с количеством бомб по близости

	public NormalCell(int bombsAround) {
		OPENED_CELL = bombsAround + "";
	}

	public NormalCell() {
		this.OPENED_CELL = "";
	}

	@Override
	public void printCell() {
		if (isCellOpen) {
			System.out.print(OPENED_CELL);
		} else {
			System.out.print(CLOSED_CELL);
		}
	}

	@Override
	public boolean hasBomb() {
		return false;
	}

}
