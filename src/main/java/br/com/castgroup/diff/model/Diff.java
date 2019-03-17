package br.com.castgroup.diff.model;

public class Diff {

	private String diffLeft;
	private String diffRight;

	public Diff(String diffLeft, String diffRight) {
		super();
		this.diffLeft = diffLeft;
		this.diffRight = diffRight;
	}
	
	public Diff() {
	};

	public String getDiffLeft() {
		return diffLeft;
	}

	public void setDiffLeft(String diffLeft) {
		this.diffLeft = diffLeft;
	}

	public String getDiffRight() {
		return diffRight;
	}

	public void setDiffRight(String diffRight) {
		this.diffRight = diffRight;
	}
	
	@Override
	public String toString() {
		return "diffRight "+diffRight+" - diffLeft "+diffLeft;
	}
}
