package com.denisneuling.binarytree.gui.dialog;

import javax.swing.JLabel;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.component.TreePanel;
import com.denisneuling.binarytree.model.Tree;

@Component
/**
 * <p>NewDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class NewDialog extends ConfirmCancelDialog implements InitializingBean{
	private static final long serialVersionUID = 8734261623116120969L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Value("${gui.dialog.new.title}")
	private String title;
	
	@Autowired
	private TreePanel treePanel;
	
	/**
	 * <p>Constructor for NewDialog.</p>
	 */
	public NewDialog(){
	}
	
	/** {@inheritDoc} */
	@Override
	public void onConfirm() {
		treePanel.setTree(new Tree());
	}
	
	/** {@inheritDoc} */
	@Override
	public void onCancel() {
		// nothing to do
	}

	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setTitle(title);
		this.getContentPane().add(new JLabel("Do you really want to erase your working progress?"));
	}
}
