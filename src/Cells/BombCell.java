package Cells;

public class BombCell extends Cell {
	protected final String OPENED_CELL = "X"; //Содержит строку с бомбой
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
		return true;
	}
}
