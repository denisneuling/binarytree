package com.denisneuling.binarytree.gui.dialog;

import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AddNodeDialog extends ConfirmCancelDialog{
	private static final long serialVersionUID = -7573773938195016710L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	private MigLayout layout;
	private JLabel key;
	private JTextField value;
	
	public AddNodeDialog(){
		this.setTitle("Add Node");
	
		layout = new MigLayout("fill");
		getContentPane().setLayout(layout);
		
		key = new JLabel("Value: ");
		this.getContentPane().add(key, "");
		value = new JTextField(20);
		this.getContentPane().add(value, "growx,push,wrap");
		
		this.setResizable(false);
	}
	
	@Override
	public void onConfirm() {
		log.debug("Confirmed.");
		String representation = value.getText();
		value.setText("");
		log.debug("Val: "+representation);
	}

	@Override
	public void onCancel() {
		log.debug("Cancelled.");
		value.setText("");
	}
}
