package com.denisneuling.binarytree.gui.component.listener;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.common.StringGenerator;
import com.denisneuling.binarytree.gui.component.TreePanel;
import com.denisneuling.binarytree.model.Tree;
import com.denisneuling.binarytree.service.BinaryTreeService;

@Component
public class NewRandomMenuListener extends BaseMenuItemListener {
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private TreePanel treePanel;
	
	@Autowired
	private BinaryTreeService treeService;
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		treePanel.setTree(new Tree());
		
		for(int i = 0; i<200; i++){
			treeService.insert(StringGenerator.nextValue());
		}
	}
}
