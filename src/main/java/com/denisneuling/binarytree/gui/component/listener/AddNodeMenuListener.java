package com.denisneuling.binarytree.gui.component.listener;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.dialog.AddNodeDialog;

@Component
/**
 * <p>AddNodeMenuListener class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class AddNodeMenuListener extends BaseMenuItemListener {
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private AddNodeDialog addNodeDialog;
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		addNodeDialog.setVisible(true);
	}
}
