package model;

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
		firstCell = new Cell(0,0, false);
		createRow(0,0, false, firstCell);
	}
	
	private void createRow(int i, int j, boolean b, Cell firstRow) {
		createCol(i,j+1,b, firstRow, firstRow.getUpCell());
		if(i+1<n) {
			Cell downFirstRow = new Cell(i+1, j, b);
			downFirstRow.setUpCell(firstRow);
			firstRow.setDownCell(downFirstRow);
			createRow(i+1, j, b, downFirstRow);
		}
	}

	private void createCol(int i, int j, boolean b, Cell prev, Cell rowPrev) {
		if(j<m) {
			Cell current = new Cell(i,j,b);
			current.setPrevCell(prev);
			prev.setNextCell(current);
			
			if(rowPrev!=null){
				rowPrev = rowPrev.getNextCell();
				current.setUpCell(rowPrev);
				rowPrev.setDownCell(current);
			}
			createCol(i, j+1, b, current, rowPrev);
		}
	}
	
	public String toString() {
		String msg;
		msg = toStringRow(firstCell);
		
		return msg;
	}

	private String toStringRow(Cell firstCellRow) {
		String msg="";
		if(firstCellRow!=null) {
			msg = toStringCol(firstCellRow)+"\n"; 
			msg += toStringRow(firstCellRow.getDownCell());
		}
		return msg;
	}
	
	private String toStringCol(Cell current) {
		String msg="";
		if(current!=null) {
			msg = current.toString(); 
			msg += toStringCol(current.getNextCell());
		}
		return msg;
	}
}
