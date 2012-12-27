package com.denisneuling.binarytree.cli;

import java.util.HashMap;
import java.util.Map;

public class CommandLineUtil {

	public static String PREFIX = "--";

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
