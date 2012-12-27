package com.denisneuling.binarytree.gui.component.listener;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.MainFrame;

@Component
/**
 * <p>QuitMenuItemListener class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class QuitMenuItemListener extends BaseMenuItemListener {

	@Autowired
	private MainFrame mainFrame;
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrame.setVisible(false);
		mainFrame.dispose();
		
		// seems to be bit buggy if we call this from an embedded window...
		mainFrame.die();
	}
}
