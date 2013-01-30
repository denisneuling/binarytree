package com.denisneuling.binarytree.gui.component.listener;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.dialog.NewDialog;

@Component
/**
 * <p>NewMenuItemListener class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class NewMenuItemListener extends BaseMenuItemListener {
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private NewDialog newDialog;
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		newDialog.setVisible(true);
	}
}
