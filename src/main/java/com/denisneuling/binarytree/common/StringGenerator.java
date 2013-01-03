package com.denisneuling.binarytree.common;

import java.math.BigInteger;
import java.security.SecureRandom;

public class StringGenerator {

	private static SecureRandom random = new SecureRandom();

	public static String nextValue() {
		return new BigInteger(130, random).toString(32).substring(0, 2);
	}
}
