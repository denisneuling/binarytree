package com.denisneuling.binarytree.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.component.BinaryTreeEditorPane;
import com.denisneuling.binarytree.gui.component.MenuPanel;

/**
 * <p>MainFrame class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class MainFrame extends JFrame implements InitializingBean, WindowListener{
	private static final long serialVersionUID = 5600053042913706544L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private MenuPanel menuPanel;
	
	@Autowired
	private BinaryTreeEditorPane binaryTreeEditorPlex;
	
	public static boolean nogui = false;
	
	/**
	 * <p>Constructor for MainFrame.</p>
	 */
	public MainFrame(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		addWindowListener(this);
	}
	
	/**
	 * <p>die.</p>
	 */
	public void die(){
		try{
			log.info("Closing applicationContext.");
			((ClassPathXmlApplicationContext) applicationContext).close();
			log.info("Destroying applicationContext.");
			((ClassPathXmlApplicationContext) applicationContext).destroy();

			// hard kill
			log.info("Died.");
			System.exit(0);
		}catch(Exception castError){
			log.fatal(String.format("Destroying applicationContext failed. Reason: %s", castError.getMessage()), castError);
		}
	}
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		setJMenuBar(menuPanel);
		
		MigLayout layout = new MigLayout();
		
		this.getContentPane().setLayout(layout);
		this.getContentPane().add(binaryTreeEditorPlex, "north, grow");
		
		this.pack();
		
		if(!nogui){
			this.setVisible(true);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void windowActivated(WindowEvent e) {
		log.debug("Window activated");
	}

	/** {@inheritDoc} */
	@Override
	public void windowClosed(WindowEvent e) {
		log.debug("Window closed");
		
		die();
	}

	/** {@inheritDoc} */
	@Override
	public void windowClosing(WindowEvent e) {
		log.debug("Window closing");
	}

	/** {@inheritDoc} */
	@Override
	public void windowDeactivated(WindowEvent e) {
		log.debug("Window deactivated");
	}

	/** {@inheritDoc} */
	@Override
	public void windowDeiconified(WindowEvent e) {
		log.debug("Window deiconified");
	}

	/** {@inheritDoc} */
	@Override
	public void windowIconified(WindowEvent e) {
		log.debug("Window iconified");
	}

	/** {@inheritDoc} */
	@Override
	public void windowOpened(WindowEvent e) {
		log.debug("Window opened");
	}
}
