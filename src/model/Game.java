package model;

import java.util.Random;

public class Game {

	private int k;
	private int n;
	private int m;
	private String nickName;
	private Cell firstCell;

	public Game(int n, int m) {
		super();
		this.n = n;
		this.m = m;
		createMatrix();
	}

	public int getK() {
		return k;
	}

	public int getN() {
		return n;
	}

	public int getM() {
		return m;
	}

	public String getNickName() {
		return nickName;
	}

	public Cell getFirstCell() {
		return firstCell;
	}

	public void createMatrix() {
		firstCell = new Cell(0, 0);
		createRow(0, 0, firstCell);
	}

	private void createRow(int i, int j, Cell firstRow) {
		createCol(i, j + 1, firstRow, firstRow.getUpCell());
		if (i + 1 < n) {
			Cell downFirstRow = new Cell(i + 1, j);
			downFirstRow.setUpCell(firstRow);
			firstRow.setDownCell(downFirstRow);
			createRow(i + 1, j, downFirstRow);
		}
	}

	private void createCol(int i, int j, Cell prev, Cell rowPrev) {
		if (j < m) {
			Cell current = new Cell(i, j);
			current.setPrevCell(prev);
			prev.setNextCell(current);

			if (rowPrev != null) {
				rowPrev = rowPrev.getNextCell();
				current.setUpCell(rowPrev);
				rowPrev.setDownCell(current);
			}
			createCol(i, j + 1, current, rowPrev);
		}
	}

	public String toString() {
		String msg;
		msg = toStringRow(firstCell);

		return msg;
	}

	private String toStringRow(Cell firstCellRow) {
		String msg = "";
		if (firstCellRow != null) {
			msg = toStringCol(firstCellRow) + "\n";
			msg += toStringRow(firstCellRow.getDownCell());
		}
		return msg;
	}

	private String toStringCol(Cell current) {
		String msg = "";
		if (current != null) {
			msg = current.toString();
			msg += toStringCol(current.getNextCell());
		}
		return msg;
	}

	public Cell search(String id) {
		Cell current = null;
		if (firstCell != null) {
			if (firstCell.getId().equals(id)) {
				current = firstCell;
			} else {
				current = searchRow(id, firstCell);
			}
		}
		return current;
	}

	private Cell searchColumn(String id, Cell current) {
		if (current == null) {
			return null;
		}
		if (current != null && current.getId().equals(id)) {
			return current;
		} else if (current.getNextCell() == null) {
			return null;
		}
		return searchColumn(id, current.getNextCell());
	}

	private Cell searchRow(String id, Cell current) {
		if (current != null && current.getId().equals(id)) {
			return current;
		}
		if (searchColumn(id, current) == null && current != null) {
			return searchRow(id, current.getDownCell());
		}
		return searchColumn(id, current);
	}

	public String generatedId() {
		String id;

		int randomRow = (int) (Math.random() * (n - 1 + 1) + 1);

		int randomCol = (int) (Math.random() * (m - 1 + 1) + 0);

		char m = (char) ('A' + randomCol);

		return id = "" + randomRow + m;
	}

	public void addMirror() {
		int tempMirror = 0;
		if (tempMirror < k) {
			Cell searched = search(generatedId());
			if(getRandom()) {
				searched.setMirror((char)47);
			}else {
				searched.setMirror((char)92);
			}
		}
	}

	public boolean getRandom() {
		boolean isRandom = false;
		Random random = new Random();
		isRandom = random.nextBoolean();

		return isRandom;
	}

	public void shut(int pos) {

	}
}
