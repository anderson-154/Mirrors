package model;

public class Cell {

	private String mirror;
	private Cell nextCell;
	private Cell prevCell;
	private Cell upCell;
	private Cell downCell;
	
	public Cell(String mirror) {
		super();
		this.mirror = mirror;
	}

	public String getMirror() {
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
	
	
}
