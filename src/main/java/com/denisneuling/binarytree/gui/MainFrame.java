package com.denisneuling.binarytree.gui;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.component.MenuPanel;
import com.denisneuling.binarytree.gui.component.TreePanel;

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
	
	@Value("${defaults.editor.size.x}")
	private String sizeX = "600";

	@Value("${defaults.editor.size.y}")
	private String sizeY = "600";

	@Autowired
	private TreePanel treePanel;
	
	public static boolean nogui = false;
	
	@Value("${defaults.gui.mainframe.title}")
	private String title;
	
	/**
	 * <p>Constructor for MainFrame.</p>
	 */
	public MainFrame(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(true);
		
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
		setTitle(title);
		setJMenuBar(menuPanel);
		
		this.getContentPane().setLayout(new MigLayout("fill"));
		this.getContentPane().add(treePanel, "grow");
		this.setMinimumSize(new Dimension(Integer.parseInt(sizeX),Integer.parseInt(sizeY)));
		this.setVisible(true);
		
		this.pack();
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
