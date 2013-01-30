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
 * <p>AddNodeDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class AddNodeDialog extends ConfirmCancelDialog {
	private static final long serialVersionUID = -7573773938195016710L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private BinaryTreeService treeService;

	@Autowired
	private ErrorDialog errorDialog;

	private MigLayout layout;
	private JLabel key;
	private JTextField value;

	/**
	 * <p>Constructor for AddNodeDialog.</p>
	 */
	public AddNodeDialog() {
		this.setTitle("Add Node");

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
			insert(representation);
		}
	}

	private void insert(String value) {
		try{
			treeService.insert(value);
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
