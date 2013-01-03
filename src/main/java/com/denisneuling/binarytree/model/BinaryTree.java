package com.denisneuling.binarytree.model;

import java.io.Serializable;

import org.apache.log4j.Logger;

import static com.denisneuling.binarytree.common.Comparision.negative;
import static com.denisneuling.binarytree.common.Comparision.positive;

public class BinaryTree implements Serializable {
	private static final long serialVersionUID = 805509743118242903L;

	private int depth = 0;
	private int nodes = 0;
	private Node rootNode;

	public BinaryTree() {
	}

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	private void insert(Node parent, Node child, int depth) {
		if (negative(parent.compareTo(child))) {
			if (parent.getChildL()!= null) {
				depth++;
				insert(parent.getChildL(), child, depth);
			} else {
				Logger.getRootLogger().warn("Inserted " + child + " to left of node " + parent);
				nodes++;
				setDepth(depth);
				parent.setChildL(child);
			}
		} else if (positive(parent.compareTo(child))) {
			if (parent.getChildR() != null) {
				depth++;
				insert(parent.getChildR(), child, depth);
			} else {
				Logger.getRootLogger().warn("Inserted " + child + " to right of node " + parent);
				nodes++;
				setDepth(depth);
				parent.setChildR(child);
			}
		}
	}
	
	public int getDepth(){
		return depth;
	}
	
	public int getNodes(){
		return nodes;
	}
	
	private void setDepth(int depth){
		if(this.depth<depth){
			this.depth = depth;
		}
	}

	public void insert(Node node) {
		if (rootNode == null) {
			rootNode = node;
		} else {
			insert(rootNode, node, 0);
		}
	}
}
