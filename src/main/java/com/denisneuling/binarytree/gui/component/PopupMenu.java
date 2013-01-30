package com.denisneuling.binarytree.gui.component;

import javax.swing.JPopupMenu;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
/**
 * <p>PopupMenu class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class PopupMenu extends JPopupMenu /*implements ActionListener,InitializingBean*/{
	private static final long serialVersionUID = -5478903794243320305L;
	protected Logger log = Logger.getLogger(this.getClass());
	
//	@Autowired
//	private AddNodeDialog addNodeDialog;
//	
//	@Autowired
//	private EditNodeDialog editNodeDialog;
//	
//	@Autowired
//	private RemoveNodeDialog removeNodeDialog;
//	
//	@Autowired
//	private MainFrame mainFrame;
//	
//	@Autowired
//	private BinaryTreeEditorPane binaryTreeEditorPane;
//	
//	private JMenuItem add;
//	private JMenuItem edit;
//	private JMenuItem remove;
//	
//	public PopupMenu(){
//		add = new JMenuItem("Add Node");
//		edit = new JMenuItem("Edit Node");
//		remove = new JMenuItem("Remove Node");
//		
//		this.add(add);
//		this.add(edit);
//		this.add(remove);
//		
//		this.pack();
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		if(add.equals(arg0.getSource())){
//			log.info("Add");
//			addNodeDialog.setVisible(true);
//		}else if(edit.equals(arg0.getSource())){
//			log.info("Edit");
//			editNodeDialog.setVisible(true);
//		}else if(remove.equals(arg0.getSource())){
//			log.info("Remove");
//			removeNodeDialog.setVisible(true);
//		}
//	}
//	
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		add.addActionListener(this);
//		edit.addActionListener(this);
//		remove.addActionListener(this);
//		
//		setInvoker(binaryTreeEditorPane);
//	}
//	
//	public void relocate(Point point){
//		Point mainFrameLocation = mainFrame.getLocation();
//		this.setLocation((int)(mainFrameLocation.getX() + point.getX()) - 30, (int)(mainFrameLocation.getY() + point.getY()) + 40);
//	}
}
