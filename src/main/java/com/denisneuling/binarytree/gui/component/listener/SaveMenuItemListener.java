package com.denisneuling.binarytree.gui.component.listener;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.component.BinaryTreeFileChoser;
import com.denisneuling.binarytree.gui.component.TreePanel;
import com.denisneuling.binarytree.gui.dialog.ErrorDialog;
import com.denisneuling.binarytree.service.BinaryTreeMaterializationService;

@Component
public class SaveMenuItemListener extends BaseMenuItemListener{
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private TreePanel treePanel;
	
	@Autowired
	private BinaryTreeMaterializationService treeMaterialingService;
	
	@Autowired
	private BinaryTreeFileChoser binaryTreeFileChoser;
	
	@Autowired
	private ErrorDialog errorDialog;

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			openFileSaver();
		}catch(Throwable throwable){
			errorDialog.showError(throwable);
		}
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
			log.debug("Saving...\n"+treePanel.getTree().toString());
			treeMaterialingService.serializeTo(target, treePanel.getTree());
		}
	}
}
