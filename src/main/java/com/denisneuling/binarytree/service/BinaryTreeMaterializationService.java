package com.denisneuling.binarytree.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.denisneuling.binarytree.model.Tree;

@Service
/**
 * <p>BinaryTreeMaterializationService class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class BinaryTreeMaterializationService {
	protected Logger log = Logger.getLogger(this.getClass());

	@Value("${defaults.ser.extension}")
	private String extension;

	/**
	 * <p>serializeTo.</p>
	 *
	 * @param file a {@link java.io.File} object.
	 * @param tree a {@link com.denisneuling.binarytree.model.Tree} object.
	 */
	public void serializeTo(File file, Tree tree) {
		if (tree == null) {
			throw new RuntimeException("BinaryTree cannot be null.");
		}
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			objectOutputStream.writeObject(tree);
		} catch (Exception e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			try {
				if (objectOutputStream != null) {
					objectOutputStream.close();
				}
			} catch (IOException e) {
				log.error("Closing OutputStream accidentially failed.", e);
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * <p>deserializeFrom.</p>
	 *
	 * @param file a {@link java.io.File} object.
	 * @return a {@link com.denisneuling.binarytree.model.Tree} object.
	 */
	public Tree deserializeFrom(File file) {
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(file));
			Object object = objectInputStream.readObject();
			if (object != null && Tree.class.equals(object.getClass())) {
				return (Tree) object;
			} else {
				throw new RuntimeException("Serialized object was null or not accessible to Binary Tree.");
			}
		} catch (Exception e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			try {
				if (objectInputStream != null) {
					objectInputStream.close();
				}
			} catch (IOException e) {
				log.error("Closing InputStream accidentally failed.", e);
				throw new RuntimeException(e);
			}
		}
	}
}
