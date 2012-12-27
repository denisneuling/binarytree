package com.denisneuling.binarytree.model;

import java.io.Serializable;


public class BinaryTree implements Serializable {
	private static final long serialVersionUID = 805509743118242903L;
	
	private Node rootNode = new Node();
	
	public BinaryTree(){
	}

	public Node getNode() {
		return rootNode;
	}

	public void setNode(Node rootNode) {
		this.rootNode = rootNode;
	}
	
	public void addNode(Node node){
		if(rootNode == null){
			
		}
	}
}
