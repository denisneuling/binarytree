package com.denisneuling.binarytree.model;

import java.io.Serializable;

public class Tree implements Serializable{
	private static final long serialVersionUID = 3275396160274101426L;
	
	private String inputString = new String("asdasd");
	private Node root;
	int totalnodes = 0; 
	int maxheight = 0;

	public Tree() {
		root = null;
	}
	
	public int treeHeigth(){
		return treeHeight(root);
	}

	public int treeHeight(Node t) {
		if (t == null)
			return -1;
		else
			return 1 + max(treeHeight(t.getChildL()), treeHeight(t.getChildR()));
	}

	public int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public void computeNodePositions() {
		int depth = 1;
		totalnodes = 0;
		inorder_traversal(root, depth);
	}

	public void inorder_traversal(Node t, int depth) {
		if (t != null) {
			inorder_traversal(t.getChildL(), depth + 1); 
			t.setPosx(totalnodes++); 
			t.setPosy(depth);
			inorder_traversal(t.getChildR(), depth + 1);
		}
	}

	public Node insert(Node root, String s) {
		if (root == null) {
			root = new Node(s);
			return root;
		} else {
			if (s.compareTo((String) (root.getValue())) == 0) {
				return root;
			} else if (s.compareTo((String) (root.getValue())) < 0)
				root.setChildL(insert(root.getChildL(), s));
			else
				root.setChildR(insert(root.getChildR(), s));
			return root;
		}
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getTotalNodes() {
		return totalnodes;
	}

	public void setTotalNodes(int totalnodes) {
		this.totalnodes = totalnodes;
	}

	public int getMaxHeight() {
		return maxheight;
	}

	public void setMaxHeight(int maxheight) {
		this.maxheight = maxheight;
	}

	@Override
	public String toString() {
		return "Tree [root=" + root + ", totalnodes=" + totalnodes + ", maxheight=" + maxheight + "]";
	}
}
