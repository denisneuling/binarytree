package com.denisneuling.binarytree.gui.dialog;

import javax.swing.JLabel;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class EditNodeDialog extends AddNodeDialog{
	private static final long serialVersionUID = 945329649315188028L;
	protected Logger log = Logger.getLogger(this.getClass());

	public EditNodeDialog() {
		this.setTitle("Edit Node");
	}
	
	@Override
	public void onConfirm() {
		log.debug("Confirmed.");
	}

	@Override
	public void onCancel() {
		log.debug("Cancelled.");
	}
}
