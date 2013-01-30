package com.denisneuling.binarytree.cli;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>CommandLineUtil class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class CommandLineUtil {

	/** Constant <code>PREFIX="--"</code> */
	public static String PREFIX = "--";

	/**
	 * <p>parseArgs.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 * @return a {@link java.util.Map} object.
	 */
	public static Map<String, String> parseArgs(String[] args) {
		Map<String, String> argt = new HashMap<String, String>();

		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith(PREFIX)) {
				String value = null;
				if (i < args.length - 1) {
					if (!args[i + 1].startsWith(PREFIX)) {
						value = args[i + 1];
					}
				}
				String key = args[i].substring(PREFIX.length());
				argt.put(key, (value==null?key:value));
			}
		}
		return argt;
	}
}
