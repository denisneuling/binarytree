package com.denisneuling.binarytree.gui.component.listener;

import java.awt.event.ActionEvent;
import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.component.BinaryTreeEditorPane;
import com.denisneuling.binarytree.gui.component.BinaryTreeFileChoser;
import com.denisneuling.binarytree.model.BinaryTree;
import com.denisneuling.binarytree.service.BinaryTreeMaterializationService;

@Component
public class LoadMenuItemListener extends BaseMenuItemListener {
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private BinaryTreeEditorPane binaryTreeEditorPlex;
	
	@Autowired
	private BinaryTreeMaterializationService treeMaterialingService;
	
	@Autowired
	private BinaryTreeFileChoser binaryTreeFileChoser;

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);

		openFileLoader();
	}

	private void openFileLoader() {
		File target = binaryTreeFileChoser.showLoadDialog();
		if(target != null){
			BinaryTree binaryTree = treeMaterialingService.deserializeFrom(target);
			binaryTreeEditorPlex.setBinaryTree(binaryTree);
		}
	}
}
