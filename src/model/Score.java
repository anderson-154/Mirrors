package model;

public class Score {

	private int score;
	private String nickname;
	
	private Score left;
	private Score right;
	private Score root;
	
	
	public Score(int score, String nickname) {
		this.score = score;
		this.nickname = nickname;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public Score getLeft() {
		return left;
	}
	
	public Score getRight() {
		return right;
	}
	
	public Score getRoot() {
		return root;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setLeft(Score left) {
		this.left = left;
	}
	
	public void setRight(Score right) {
		this.right = right;
	}
	
	public void setRoot(Score root) {
		this.root = root;
	}
	
}
