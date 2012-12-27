package com.denisneuling.binarytree.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.denisneuling.binarytree.model.BinaryTree;

@Service
public class BinaryTreeService implements InitializingBean{

	private volatile BinaryTree binaryTree = new BinaryTree();
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
	}

	public int getTotalNodes() {
		// TODO Auto-generated method stub
		return 1;
	}

	public int getDepth() {
		// TODO Auto-generated method stub
		return 1;
	}

	public BinaryTree getBinaryTree() {
		return binaryTree;
	}

	public void setBinaryTree(BinaryTree binaryTree) {
		this.binaryTree = binaryTree;
	}
}
