package com.denisneuling.binarytree.gui.component;

import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.model.BinaryTree;

@Component
public class BinaryTreeEditorPlex extends JPanel{
	private static final long serialVersionUID = -381553764719490920L;
	
	private volatile BinaryTree binaryTree;

	public BinaryTree getBinaryTree() {
		return binaryTree;
	}

	public void setBinaryTree(BinaryTree binaryTree) {
		this.binaryTree = binaryTree;
	}
}
