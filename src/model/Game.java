package model;

public class Game {

	private int k;
	private int n;
	private char m;
	private String nickName;
	private Cell firstCell;
	
	public Game(int k, int n, char m, String nickName) {
		super();
		this.k = k;
		this.n = n;
		this.m = m;
		this.nickName = nickName;
	}

	public int getK() {
		return k;
	}

	public int getN() {
		return n;
	}

	public char getM() {
		return m;
	}

	public String getNickName() {
		return nickName;
	}

	public Cell getFirstCell() {
		return firstCell;
	}
	
	public Cell createMatrix(int n, char m) {
		return createMatrix(n, m, firstCell);
	}
	
	private Cell createMatrix(int i, char j, Cell current) {
		if(i>=n && j>=m) {
			return null;
		}
		Cell aux = new Cell(i,j);
		aux.setPrevCell(current);
		aux.setUpCell(current);
		aux.setNextCell(createMatrix(i, (char)(j+1), current));
		aux.setPrevCell(createMatrix(i+1, j, current));
		
		return current;
		
	}
	
}
