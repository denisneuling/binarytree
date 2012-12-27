package com.denisneuling.binarytree.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.model.BinaryTree;

@Component
public class BinaryTreeMaterializationService {

	@Value("${defaults.ser.extension}")
	private String extension;
	
	public void serializeTo(File file, BinaryTree tree) {
		if(tree==null){
			throw new RuntimeException("BinaryTree cannot be null.");
		}
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			objectOutputStream.writeObject(tree);
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BinaryTree deserializeFrom(File file) {
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(file));
			Object object = objectInputStream.readObject();
			if(object!=null && BinaryTree.class.equals(object.getClass())){
				return (BinaryTree)object;
			}else{
				throw new RuntimeException("Serialized Binary Tree was null.");
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}finally{
			if(objectInputStream != null){
				try {
					objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
