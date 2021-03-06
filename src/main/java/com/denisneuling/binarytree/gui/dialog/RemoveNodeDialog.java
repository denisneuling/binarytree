package com.denisneuling.binarytree.gui.dialog;

import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.service.BinaryTreeService;

@Component
/**
 * <p>RemoveNodeDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class RemoveNodeDialog extends ConfirmCancelDialog{
	private static final long serialVersionUID = 8734261623116120969L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private BinaryTreeService treeService;
	
	@Autowired
	private ErrorDialog errorDialog;
	
	private MigLayout layout;
	private JLabel key;
	private JTextField value;
	
	/**
	 * <p>Constructor for RemoveNodeDialog.</p>
	 */
	public RemoveNodeDialog(){
		this.setTitle("Remove Node");
	
		layout = new MigLayout("fill");
		getContentPane().setLayout(layout);
		
		key = new JLabel("Value: ");
		this.getContentPane().add(key, "");
		value = new JTextField(20);
		this.getContentPane().add(value, "growx,push,wrap");
		
		this.setResizable(false);
	}
	
	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		log.debug("Confirmed.");
		String representation = value.getText();
		if (representation == null || representation.isEmpty()) {
			errorDialog.showError("Value cannot be null or empty");
		} else {
			value.setText("");
			remove(representation);
		}
	}
	
	private void remove(String value){
		try{
			treeService.remove(value);
		} catch(Throwable throwable){
			errorDialog.showError(throwable);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void onCancel() {
		log.debug("Cancelled.");
		value.setText("");
	}
}
