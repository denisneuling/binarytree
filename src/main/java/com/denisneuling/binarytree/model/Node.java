package com.denisneuling.binarytree.model;

import java.io.Serializable;

/**
 * <p>Node class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Node implements Serializable, Comparable<Serializable> {
	private static final long serialVersionUID = 7237352710185333892L;

	private int posx = 1;
	private int posy = 1;
	
	private Node childL;
	private Node childR;
	
	private Serializable value;

	/**
	 * <p>Constructor for Node.</p>
	 */
	public Node(){
	}
	
	/**
	 * <p>Constructor for Node.</p>
	 *
	 * @param value a {@link java.io.Serializable} object.
	 */
	public Node(Serializable value){
		this.value = value;
	}
	
	/**
	 * <p>Getter for the field <code>value</code>.</p>
	 *
	 * @return a {@link java.io.Serializable} object.
	 */
	public Serializable getValue() {
		return value;
	}

	/**
	 * <p>Setter for the field <code>value</code>.</p>
	 *
	 * @param value a {@link java.io.Serializable} object.
	 */
	public void setValue(Serializable value) {
		this.value = value;
	}

	/**
	 * <p>Getter for the field <code>posx</code>.</p>
	 *
	 * @return a int.
	 */
	public int getPosx() {
		return posx;
	}

	/**
	 * <p>Setter for the field <code>posx</code>.</p>
	 *
	 * @param posx a int.
	 */
	public void setPosx(int posx) {
		this.posx = posx;
	}

	/**
	 * <p>Getter for the field <code>posy</code>.</p>
	 *
	 * @return a int.
	 */
	public int getPosy() {
		return posy;
	}

	/**
	 * <p>Setter for the field <code>posy</code>.</p>
	 *
	 * @param posy a int.
	 */
	public void setPosy(int posy) {
		this.posy = posy;
	}

	/**
	 * <p>Getter for the field <code>childL</code>.</p>
	 *
	 * @return a {@link com.denisneuling.binarytree.model.Node} object.
	 */
	public Node getChildL() {
		return childL;
	}

	/**
	 * <p>Setter for the field <code>childL</code>.</p>
	 *
	 * @param childL a {@link com.denisneuling.binarytree.model.Node} object.
	 */
	public void setChildL(Node childL) {
		this.childL = childL;
	}

	/**
	 * <p>Getter for the field <code>childR</code>.</p>
	 *
	 * @return a {@link com.denisneuling.binarytree.model.Node} object.
	 */
	public Node getChildR() {
		return childR;
	}

	/**
	 * <p>Setter for the field <code>childR</code>.</p>
	 *
	 * @param childR a {@link com.denisneuling.binarytree.model.Node} object.
	 */
	public void setChildR(Node childR) {
		this.childR = childR;
	}
	
	/** {@inheritDoc} */
	@Override
	public int compareTo(Serializable o) {
		if(this.hashCode() < o.hashCode()){
			return -1;
		}
		if(this.hashCode() > o.hashCode()){
			return 1;
		}
		return 0;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Node [posx=" + posx + ", posy=" + posy + ", childL=" + childL + ", childR=" + childR + ", value=" + value + "]";
	}
}
