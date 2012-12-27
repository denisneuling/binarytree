package com.denisneuling.binarytree.gui.component.listener;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.component.BinaryTreeEditorPane;
import com.denisneuling.binarytree.gui.component.BinaryTreeFileChoser;
import com.denisneuling.binarytree.service.BinaryTreeMaterializationService;

@Component
public class SaveMenuItemListener extends BaseMenuItemListener{
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

		openFileSaver();
	}

	private void openFileSaver() {
		File target = binaryTreeFileChoser.showSaveDialog();
		if(target != null){
			if(!target.exists()){
				try {
					target.createNewFile();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			treeMaterialingService.serializeTo(target, binaryTreeEditorPlex.getBinaryTree());
		}
	}
}
