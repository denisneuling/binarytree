package com.denisneuling.binarytree.gui.component.listener;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.dialog.RemoveNodeDialog;

@Component
public class RemoveNodeMenuListener  extends BaseMenuItemListener {
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private RemoveNodeDialog removeNodeDialog;
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		removeNodeDialog.setVisible(true);
	}
}