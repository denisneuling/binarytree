package com.denisneuling.binarytree.model;

import java.io.Serializable;

/**
 * <p>Tree class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Tree implements Serializable{
	private static final long serialVersionUID = 3275396160274101426L;
	
	private String inputString = new String("asdasd");
	private Node root;
	int totalnodes = 0; 
	int maxheight = 0;

	/**
	 * <p>Constructor for Tree.</p>
	 */
	public Tree() {
		root = null;
	}
	
	/**
	 * <p>treeHeigth.</p>
	 *
	 * @return a int.
	 */
	public int treeHeigth(){
		return treeHeight(root);
	}

	/**
	 * <p>treeHeight.</p>
	 *
	 * @param t a {@link com.denisneuling.binarytree.model.Node} object.
	 * @return a int.
	 */
	public int treeHeight(Node t) {
		if (t == null)
			return -1;
		else
			return 1 + max(treeHeight(t.getChildL()), treeHeight(t.getChildR()));
	}

	/**
	 * <p>max.</p>
	 *
	 * @param a a int.
	 * @param b a int.
	 * @return a int.
	 */
	public int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	/**
	 * <p>computeNodePositions.</p>
	 */
	public void computeNodePositions() {
		int depth = 1;
		totalnodes = 0;
		inorder_traversal(root, depth);
	}

	/**
	 * <p>inorder_traversal.</p>
	 *
	 * @param t a {@link com.denisneuling.binarytree.model.Node} object.
	 * @param depth a int.
	 */
	public void inorder_traversal(Node t, int depth) {
		if (t != null) {
			inorder_traversal(t.getChildL(), depth + 1); 
			t.setPosx(totalnodes++); 
			t.setPosy(depth);
			inorder_traversal(t.getChildR(), depth + 1);
		}
	}

	/**
	 * <p>insert.</p>
	 *
	 * @param root a {@link com.denisneuling.binarytree.model.Node} object.
	 * @param s a {@link java.lang.String} object.
	 * @return a {@link com.denisneuling.binarytree.model.Node} object.
	 */
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

	/**
	 * <p>Getter for the field <code>inputString</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getInputString() {
		return inputString;
	}

	/**
	 * <p>Setter for the field <code>inputString</code>.</p>
	 *
	 * @param inputString a {@link java.lang.String} object.
	 */
	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	/**
	 * <p>Getter for the field <code>root</code>.</p>
	 *
	 * @return a {@link com.denisneuling.binarytree.model.Node} object.
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * <p>Setter for the field <code>root</code>.</p>
	 *
	 * @param root a {@link com.denisneuling.binarytree.model.Node} object.
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * <p>getTotalNodes.</p>
	 *
	 * @return a int.
	 */
	public int getTotalNodes() {
		return totalnodes;
	}

	/**
	 * <p>setTotalNodes.</p>
	 *
	 * @param totalnodes a int.
	 */
	public void setTotalNodes(int totalnodes) {
		this.totalnodes = totalnodes;
	}

	/**
	 * <p>getMaxHeight.</p>
	 *
	 * @return a int.
	 */
	public int getMaxHeight() {
		return maxheight;
	}

	/**
	 * <p>setMaxHeight.</p>
	 *
	 * @param maxheight a int.
	 */
	public void setMaxHeight(int maxheight) {
		this.maxheight = maxheight;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Tree [root=" + root + ", totalnodes=" + totalnodes + ", maxheight=" + maxheight + "]";
	}
}
