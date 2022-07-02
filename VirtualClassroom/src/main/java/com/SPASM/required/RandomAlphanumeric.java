package com.SPASM.required;

import java.util.Random;

public class RandomAlphanumeric {
	private final String LETTER = "abcdefghijklmnopqrstuvwxyz";
	private final char[] ALPHANUMERIC = (LETTER + LETTER.toUpperCase() + "1234567890").toCharArray();

	public String generateAlphaNumeric(int length) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < length; i++) {
			result.append(ALPHANUMERIC[new Random().nextInt(ALPHANUMERIC.length)]);

		}
		return result.toString();
	}

}
