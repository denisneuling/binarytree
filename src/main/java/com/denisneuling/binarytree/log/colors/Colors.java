package com.denisneuling.binarytree.log.colors;

public class Colors {

	public static final String REDB = "\033[1;41m";
	public static final String REDF = "\033[31m";
	public static final String GREENB = "\033[1;42m";
	public static final String GREENF = "\033[1;32m";
	public static final String YELLOWB = "\033[1;43m";
	public static final String YELLOWF = "\033[1;33m";
	public static final String BLUEB = "\033[1;44m";
	public static final String BLUEF = "\033[1;34m";
	public static final String MAGENTAB = "\033[1;45m";
	public static final String MAGENTAF = "\033[1;35m";
	public static final String CYANB = "\033[1;46m";
	public static final String CYANF = "\033[1;36m";
	public static final String WHITEB = "\033[1;47m";
	public static final String WHITEF = "\033[1;37m";
	public static final String RESET = "\033[0m";

	public static String colored(String message, String color) {
		if (color == null) {
			return message;
		}
		return String.format("%s%s%s%s", RESET, color, (message == null ? "" : message), RESET);
	}
}