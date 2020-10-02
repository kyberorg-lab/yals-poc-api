package eu.kyberorg.yals.api.core;

import org.apache.commons.lang3.RandomStringUtils;

public class IdentGenerator {
	private static final int IDENT_DEFAULT_LENGTH = 6;

	private IdentGenerator() {
		throw new UnsupportedOperationException("Static class");
	}

	public static String generateNewIdent() {
		return RandomStringUtils.randomAlphabetic(IDENT_DEFAULT_LENGTH);
	}
}
