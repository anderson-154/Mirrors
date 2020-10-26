package model;

public class Cell {

	private int n;
	private char m;
	private Cell nextCell;
	private Cell prevCell;
	private Cell upCell;
	private Cell downCell;

	public Cell(int n, char m) {
		super();
		this.n = n;
		this.m = m;
	}


	public int getN() {
		return n;
	}

	public char getM() {
		return m;
	}

	public Cell getNextCell() {
		return nextCell;
	}
	

	public Cell getPrevCell() {
		return prevCell;
	}

	public Cell getUpCell() {
		return upCell;
	}

	public void setPrevCell(Cell prevCell) {
		this.prevCell = prevCell;
	}

	public void setDownCell(Cell downCell) {
		this.downCell = downCell;
	}

	public Cell getDownCell() {
		return downCell;
	}

	public void setNextCell(Cell nextCell) {
		this.nextCell = nextCell;
	}

	public void setUpCell(Cell upCell) {
		this.upCell = upCell;
	}
	
	
}
