package com.denisneuling.binarytree.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denisneuling.binarytree.common.SerializableComparator;
import com.denisneuling.binarytree.gui.component.TreePanel;
import com.denisneuling.binarytree.model.Node;
import com.denisneuling.binarytree.model.Tree;

@Service
public class BinaryTreeService {
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private TreePanel treePanel;
	
	@Autowired
	private SerializableComparator serializableComparator;
	
	public void remove(String value){
		List<String> values = extractValues(treePanel.getTree());
		values.remove(value);
		
		Tree newTree = new Tree();
		for(String s : values){
			newTree.setRoot(newTree.insert(newTree.getRoot(), s));
		}
		treePanel.setTree(newTree);
	}
	
	private List<String> extractValues(Tree tree){
		return extractedValue(null, tree.getRoot());
	}
	
	private List<String> extractedValue(List<String> list, Node node){
		if(list==null){
			list = new LinkedList<String>();
		}
		if(node == null){
			return list;
		}
		list.add((String) node.getValue());
		extractedValue(list, node.getChildL());
		extractedValue(list, node.getChildR());
		return list;
		
	}
	
	public void insert(String value){
		if (treePanel.getTree() == null) {
			treePanel.setTree(new Tree());
		}
		treePanel.getTree().setInputString(treePanel.getTree().getInputString()+value);
		treePanel.getTree().setRoot(treePanel.getTree().insert(treePanel.getTree().getRoot(), value));
		treePanel.setTree(treePanel.getTree());
	}
}
