package model;

public class Cell {

	private int n;
	private int m;
	private char mirror;
	private String id;
	
	private Cell nextCell;
	private Cell prevCell;
	private Cell upCell;
	private Cell downCell;

	public Cell(int n, int m) {
		this.n = n;
		this.m = m;
		nextCell = null;
		prevCell = null;
		upCell = null;
		downCell = null;
		mirror=getMirror();
	}


	public int getN() {
		return n;
	}

	public int getM() {
		return m;
	}

	public char getMirror() {
		return mirror;
	}

	public void setMirror(char mirror) {
		this.mirror = mirror;
	}


	public String getId() {
		id=""+n+getNum();
		return id;
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
	@Override
	public String toString() {
	return "["+getMirror()+"]";
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
