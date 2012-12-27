package com.denisneuling.binarytree.model;

import java.io.Serializable;

public class Node implements Serializable {
	private static final long serialVersionUID = 7237352710185333892L;

	private int posx;
	private int posy;
	
	private Node childL;
	private Node childR;
	
	private Serializable value;

	public Serializable getValue() {
		return value;
	}

	public void setValue(Serializable value) {
		this.value = value;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public Node getChildL() {
		return childL;
	}

	public void setChildL(Node childL) {
		this.childL = childL;
	}

	public Node getChildR() {
		return childR;
	}

	public void setChildR(Node childR) {
		this.childR = childR;
	}
}
