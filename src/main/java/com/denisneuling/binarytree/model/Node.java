package com.denisneuling.binarytree.model;

import java.io.Serializable;

public class Node implements Serializable, Comparable<Serializable> {
	private static final long serialVersionUID = 7237352710185333892L;

	private int posx = 1;
	private int posy = 1;
	
	private Node childL;
	private Node childR;
	
	private Serializable value;

	public Node(){
	}
	
	public Node(Serializable value){
		this.value = value;
	}
	
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
	
	@Override
	public int compareTo(Serializable o) {
		if(this.hashCode() < o.hashCode()){
			return -1;
		}
		if(this.hashCode() > o.hashCode()){
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Node [posx=" + posx + ", posy=" + posy + ", childL=" + childL + ", childR=" + childR + ", value=" + value + "]";
	}
}
