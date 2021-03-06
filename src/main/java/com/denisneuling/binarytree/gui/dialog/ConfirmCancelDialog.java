package com.denisneuling.binarytree.gui.dialog;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/**
 * <p>Abstract ConfirmCancelDialog class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public abstract class ConfirmCancelDialog extends BaseDialog{
	private static final long serialVersionUID = 8516091888456072697L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ErrorDialog errorDialog;
	
	private MigLayout layout;
	
	private volatile boolean ready = false;
	protected JPanel contentPane;
	private JScrollPane scrollPane;
	
	protected JButton confirmButton;
	protected JButton cancelButton;
	
	/**
	 * <p>Constructor for ConfirmCancelDialog.</p>
	 */
	public ConfirmCancelDialog(){
		layout = new MigLayout("fill","","[grow]rel[grow]");
		
		this.setMinimumSize(new Dimension(600, 300));
		setLayout(layout);
		
		contentPane = new JPanel();
		contentPane.setLayout(new MigLayout("fill"));
		
		scrollPane = new JScrollPane(contentPane);
		add(scrollPane, "grow, push,wrap");
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new MigLayout("fill"));
		
		confirmButton = new JButton("Confirm");
		buttonPane.add(confirmButton, "span,split 2,growx,push");
		confirmButton.addActionListener(this);
		
		cancelButton = new JButton("Cancel");
		buttonPane.add(cancelButton,"growx, push");
		cancelButton.addActionListener(this);
		
		add(buttonPane, "growx");//, south");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		pack();
		
		ready = true;
	}
	
	/** {@inheritDoc} */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(confirmButton.equals(e.getSource())){
			try{
				onConfirm();
				this.setVisible(false);
			}catch(Exception exception){
				onError(exception);
			}
		}else if(cancelButton.equals(e.getSource())){
			try{
				onCancel();
				this.setVisible(false);
			}catch(Exception exception){
				onError(exception);
			}
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public Container getContentPane() {
		if(ready){
			return contentPane;
		}else{
			return super.getContentPane();
		}
	}
	
	/**
	 * <p>onConfirm.</p>
	 */
	public abstract void onConfirm();
	
	/**
	 * <p>onCancel.</p>
	 */
	public abstract void onCancel();
	
	/**
	 * <p>onError.</p>
	 *
	 * @param throwable a {@link java.lang.Throwable} object.
	 */
	public void onError(Throwable throwable){
		errorDialog.showError(throwable);
	}
}
