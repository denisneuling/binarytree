package com.denisneuling.binarytree.gui.dialog;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
/**
 * <p>EditNodeDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Deprecated
public class EditNodeDialog extends AddNodeDialog{
	private static final long serialVersionUID = 945329649315188028L;
	protected Logger log = Logger.getLogger(this.getClass());

	/**
	 * <p>Constructor for EditNodeDialog.</p>
	 */
	public EditNodeDialog() {
		this.setTitle("Edit Node");
	}
	
	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		log.debug("Confirmed.");
	}

	/** {@inheritDoc} */
	@Override
	public void onCancel() {
		log.debug("Cancelled.");
	}
}
