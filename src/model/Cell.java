package model;

public class Cell {

	private int n;
	private int m;
	private boolean mirror;
	
	private Cell nextCell;
	private Cell prevCell;
	private Cell upCell;
	private Cell downCell;

	public Cell(int n, int m, boolean mirror) {
		super();
		this.n = n;
		this.m = m;
		this.mirror = mirror;
	}


	public int getN() {
		return n;
	}

	public int getM() {
		return m;
	}
	

	public boolean isMirror() {
		return mirror;
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
	
	public char getNum() {
		return (char)('A'+m);
	}
	public String toString() {
	return "["+n+","+m+"]";
	}
}
