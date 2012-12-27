package com.denisneuling.binarytree.model;

import java.io.Serializable;

public class Leaf implements Serializable{
	private static final long serialVersionUID = -3382347273465646713L;

	private Serializable value;

	public Serializable getValue() {
		return value;
	}

	public void setValue(Serializable value) {
		this.value = value;
	}
}
