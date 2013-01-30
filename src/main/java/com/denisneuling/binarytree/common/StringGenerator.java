package com.denisneuling.binarytree.common;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * <p>StringGenerator class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class StringGenerator {

	private static SecureRandom random = new SecureRandom();

	/**
	 * <p>nextValue.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public static String nextValue() {
		return new BigInteger(130, random).toString(32).substring(0, 2);
	}
}
