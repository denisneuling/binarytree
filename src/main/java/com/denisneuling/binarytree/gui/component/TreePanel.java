package com.denisneuling.binarytree.gui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.MainFrame;
import com.denisneuling.binarytree.model.Node;
import com.denisneuling.binarytree.model.Tree;

@Component
/**
 * <p>TreePanel class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class TreePanel extends JPanel {
	private static final long serialVersionUID = -381553764719490920L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	int xs;
	int ys;

	@Autowired
	private MainFrame mainFrame;
	
	private volatile Tree tree = new Tree();

	/**
	 * <p>Setter for the field <code>tree</code>.</p>
	 *
	 * @param tree a {@link com.denisneuling.binarytree.model.Tree} object.
	 */
	public void setTree(Tree tree) {
		this.tree = tree;
		this.tree.computeNodePositions();
		
		this.updateUI();
	}
	/**
	 * <p>Getter for the field <code>tree</code>.</p>
	 *
	 * @return a {@link com.denisneuling.binarytree.model.Tree} object.
	 */
	public Tree getTree(){
		return tree;
	}

	/**
	 * <p>Constructor for TreePanel.</p>
	 */
	public TreePanel() {
		setVisible(true);
		setBorder(BorderFactory.createEmptyBorder());
		setBackground(Color.white);
		setForeground(Color.black);
		
		this.setMinimumSize(new Dimension(400, 400));
	}

	/** {@inheritDoc} */
	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(getForeground());
		Font font = new Font("SansSerif", Font.BOLD, 10);
		g.setFont(font);
		xs = 10;
		ys = 10;
		g.setFont(font);
		this.drawTree(g, tree.getRoot());
		revalidate();
	}

	/**
	 * <p>drawTree.</p>
	 *
	 * @param g a {@link java.awt.Graphics} object.
	 * @param root a {@link com.denisneuling.binarytree.model.Node} object.
	 */
	public void drawTree(Graphics g, Node root) {
		tree.setMaxHeight(tree.treeHeigth());
		int dx, dy, dx2, dy2;
		int SCREEN_WIDTH = (int)this.getSize().getWidth()-10;
		int SCREEN_HEIGHT = (int)this.getSize().getHeight()-10;
		int XSCALE, YSCALE;
		if(tree.getTotalNodes() > 0){
			XSCALE = SCREEN_WIDTH / (tree.getTotalNodes()); 
			YSCALE = (SCREEN_HEIGHT - ys) / ((tree.getMaxHeight() + 1));
			if (root != null) {
				drawTree(g, root.getChildL()); 
				dx = root.getPosx() * XSCALE; 
				dy = root.getPosy() * YSCALE + ys;
				String s = (String) root.getValue(); 
				g.drawString(s, dx, dy); 
				if (root.getChildL() != null) {
					dx2 = root.getChildL().getPosx() * XSCALE;
					dy2 = root.getChildL().getPosy() * YSCALE + ys;
					
					g.setColor(Color.GRAY);
					g.drawLine(dx, dy, dx2, dy2);
					g.setColor(Color.BLACK);
				}
				if (root.getChildR() != null) { 
					dx2 = root.getChildR().getPosx() * XSCALE;
					dy2 = root.getChildR().getPosy() * YSCALE + ys;
					
					g.setColor(Color.GRAY);
					g.drawLine(dx, dy, dx2, dy2);
					g.setColor(Color.BLACK);
				}
				drawTree(g, root.getChildR());
			}
		}
	}
}
