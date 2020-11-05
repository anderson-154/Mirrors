package model;

import java.util.Random;

public class Game {

	private int k;
	private int n;
	private int m;
	private String nickName;
	private Cell firstCell;

	public Game(int n, int m, int k) {
		this.n = n;
		this.m = m;
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
	@Override
	public String toString() {
		String msg;
		msg = toStringRow(firstCell);

		return msg;
	}

	private String toStringRow(Cell firstCellRow) {
		String msg = "";
		if (firstCellRow != null) {
			msg += toStringCol(firstCellRow) + "\n";
			return msg += toStringRow(firstCellRow.getDownCell());
		}
		return msg;
	}

	private String toStringCol(Cell current) {
		String msg = "";
		if (current != null) {
			msg = current.toString();
			return msg += toStringCol(current.getNextCell());
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
		String id = "";

		int randomRow = (int) (Math.random() * (n - 1 + 1) + 0);

		int randomCol = (int) (Math.random() * (m - 1 + 1) + 0);

		char m = (char) ('A' + randomCol);
		id = "" + randomRow + m;
		return id;
	}

	public void addMirror() {
		int tempMirror = 0;
		if (tempMirror<k) {
			Cell searched = search(generatedId());
			if (searched.getMirror() == (char) 47 || searched.getMirror() == (char) 95) {
				addMirror();
			} else {
				searched.setMirror(selectMirror());
				tempMirror++;
				addMirror();
			}
		}
	}

	private char selectMirror() {
        if (getRandom()) {
            return 'R';
        }
        return 'L';
    }
	
	private boolean getRandom() {
		boolean isRandom = false;
		Random random = new Random();
		isRandom = random.nextBoolean();

		return isRandom;
	}

	public void posShot(String pos, String vh) {
		Cell current = search(pos);
		if(current.getUpCell()==null && current.getPrevCell()==null) {
			if(vh=="V") {
				shotV();
			}else if(vh=="H") {
				shotH();
			}
		}else if(current.getUpCell()==null && current.getNextCell()==null) {
			if(vh=="V") {
				shotV();
			}else if(vh=="H") {
				shotH();
			}
		}else if(current.getDownCell()==null && current.getPrevCell()==null) {
			if(vh=="V") {
				shotV();
			}else if(vh=="H") {
				shotH();
			}
		}else if(current.getDownCell()==null && current.getNextCell()==null) {
			if(vh=="V") {
				shotV();
			}else if(vh=="H") {
				shotH();
			}
		}
	}
	private void shotH() {
		
		
	}

	private void shotV() {
		
	}

	public void shot(String pos) {
		search(pos);
	}
}
