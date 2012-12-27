package com.denisneuling.binarytree.gui.component;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.denisneuling.binarytree.gui.MainFrame;

@Component
public class BinaryTreeFileChoser extends JFileChooser implements InitializingBean{
	private static final long serialVersionUID = -745612620514950704L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Value("${defaults.ser.extension}")
	private String extension;
	
	@Autowired
	private MainFrame mainFrame;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File arg0) {
				return arg0.getAbsoluteFile().canRead() && arg0.getAbsoluteFile().canWrite() && arg0.getName().endsWith(extension);
			}

			@Override
			public String getDescription() {
				return "Binary Tree Serialization" + (extension != null && !extension.isEmpty() ? " (*" + extension + ")" : "");
			}
		};
		setFileFilter(filter);
	}
	
	public File showLoadDialog(){
		this.setDialogType(JFileChooser.OPEN_DIALOG);
		int returnVal = this.showOpenDialog(mainFrame); 
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File target = getSelectedFile().getAbsoluteFile();
			
			return target;
		}
		return null;
	}
	
	public File showSaveDialog(){
		this.setDialogType(JFileChooser.SAVE_DIALOG);
		int returnVal = this.showSaveDialog(mainFrame); 
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File target = getSelectedFile().getAbsoluteFile();
			if(!target.getAbsolutePath().endsWith(extension)){
				String newTarget = target.getAbsolutePath() + extension;
				target = new File(newTarget);
				return target;
			}
			return target;
		}
		return null;
	}

}
