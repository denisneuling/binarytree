package com.denisneuling.binarytree.gui.dialog;

import javax.swing.JLabel;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class RemoveNodeDialog extends ConfirmCancelDialog{
	private static final long serialVersionUID = 8734261623116120969L;
	protected Logger log = Logger.getLogger(this.getClass());

	public RemoveNodeDialog(){
		this.setTitle("Add Node");
		
		add(new JLabel("asjndhkajsdhaskd"));
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
