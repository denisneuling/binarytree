package com.denisneuling.binarytree.runner;

import java.util.Map;

import com.denisneuling.binarytree.cli.CommandLineUtil;
import com.denisneuling.binarytree.common.StringGenerator;
import com.denisneuling.binarytree.gui.MainFrame;
import com.denisneuling.binarytree.model.BinaryTree;
import com.denisneuling.binarytree.model.Node;
import com.denisneuling.binarytree.spring.ApplicationContextLoader;

/**
 * <p>Runner class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Runner {

	@SuppressWarnings("unused")
	private static ApplicationContextLoader applicationContextLoader;
	
	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args){
		Map<String, String> arguments = CommandLineUtil.parseArgs(args);
		
		if(arguments.get("nogui")!=null){
			MainFrame.nogui = true;
		}
		
		applicationContextLoader = ApplicationContextLoader.getInstance();
	}
}
