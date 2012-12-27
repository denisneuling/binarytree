package com.denisneuling.binarytree.model;

import java.io.Serializable;

public class Node extends Leaf implements Serializable {
	private static final long serialVersionUID = 7237352710185333892L;

	private Leaf childl;
	private Leaf childr;

	public Leaf getChildL() {
		return childl;
	}

	public void setChildL(Leaf childl) {
		this.childl = childl;
	}

	public Leaf getChildR() {
		return childr;
	}

	public void setChildR(Leaf childr) {
		this.childr = childr;
	}

}
