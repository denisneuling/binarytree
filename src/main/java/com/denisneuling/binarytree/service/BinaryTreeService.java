package com.denisneuling.binarytree.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.denisneuling.binarytree.common.StringGenerator;
import com.denisneuling.binarytree.model.BinaryTree;
import com.denisneuling.binarytree.model.Node;

@Service
public class BinaryTreeService implements InitializingBean{

	private volatile BinaryTree binaryTree = new BinaryTree();

	public int getTotalNodes() {
		return binaryTree.getNodes();
	}

	public int getDepth() {
		return binaryTree.getDepth();
	}

	public BinaryTree getBinaryTree() {
		return binaryTree;
	}

	public void setBinaryTree(BinaryTree binaryTree) {
		this.binaryTree = binaryTree;
	}
	
	public void insertInto(BinaryTree binaryTree,Node node){
		binaryTree.insert(node);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		StringGenerator gen = new StringGenerator();
		for (int i = 0; i < 10000; i++) {
			binaryTree.insert(new Node(gen.nextValue()));
		}
		
	}
}
