package com.denisneuling.binarytree.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.model.Tree;

@Component
public class TreeMaterializer {

	@Value("${defaults.file.extension}")
	private String extension;
	
	public void serializeTo(String path, Tree tree) {
		File f = new File(path);
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(f));
			objectOutputStream.writeObject(tree);
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Tree deserializeFrom(String path) {
		File f = new File(path);
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(f));
			Object object = objectInputStream.readObject();
			if(Tree.class.equals(object.getClass())){
				return (Tree)object;
			}else{
				throw new RuntimeException();
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
