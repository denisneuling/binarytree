package com.denisneuling.binarytree.gui.component.listener;

import java.awt.event.ActionEvent;
import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.component.BinaryTreeFileChoser;
import com.denisneuling.binarytree.gui.component.TreePanel;
import com.denisneuling.binarytree.gui.dialog.ErrorDialog;
import com.denisneuling.binarytree.model.Tree;
import com.denisneuling.binarytree.service.BinaryTreeMaterializationService;

@Component
/**
 * <p>LoadMenuItemListener class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class LoadMenuItemListener extends BaseMenuItemListener {
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
			openFileLoader();
		}catch(Throwable throwable){
			errorDialog.showError(throwable);
		}
	}

	private void openFileLoader() {
		File target = binaryTreeFileChoser.showLoadDialog();
		if(target != null){
			Tree tree = treeMaterialingService.deserializeFrom(target);
			tree.computeNodePositions();
			log.debug("Loaded...\n"+tree);
			treePanel.setTree(tree);
		}
	}
}
