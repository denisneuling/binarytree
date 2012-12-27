package com.denisneuling.binarytree.gui.component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.MainFrame;
import com.denisneuling.binarytree.gui.component.listener.LoadMenuItemListener;
import com.denisneuling.binarytree.gui.component.listener.NewMenuItemListener;
import com.denisneuling.binarytree.gui.component.listener.QuitMenuItemListener;
import com.denisneuling.binarytree.gui.component.listener.SaveMenuItemListener;

@Component
/**
 * <p>MenuPanel class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class MenuPanel extends JMenuBar implements InitializingBean {
	private static final long serialVersionUID = -8033351688374778735L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private MainFrame mainFrame;
	
	@Autowired
	private QuitMenuItemListener quitMenuItemListener;

	@Autowired
	private SaveMenuItemListener saveMenuItemListener;

	@Autowired
	private LoadMenuItemListener loadMenuItemListener;

	@Autowired
	private NewMenuItemListener newMenuItemListener;

	private JMenu jMenu;
	private JMenuItem newbt;
	private JMenuItem load;
	private JMenuItem save;
	private JMenuItem exit;
	
	/**
	 * <p>Constructor for MenuPanel.</p>
	 */
	public MenuPanel(){
	}	
	
	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.removeAll();
		
		jMenu = new JMenu("File");
		
		newbt = new JMenuItem("New");
		newbt.addActionListener(newMenuItemListener);
		
		load = new JMenuItem("Load");
		load.addActionListener(loadMenuItemListener);
		
		save = new JMenuItem("Save");
		save.addActionListener(saveMenuItemListener);
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(quitMenuItemListener);
		
		jMenu.add(newbt);
		jMenu.add(save);
		jMenu.add(load);
		jMenu.add(exit);
		this.add(jMenu);
		
		this.setVisible(true);
	}
}
