package com.api.emailNotify.application.shared.validation;

import java.util.regex.Pattern;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EmailUtils {

	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	public static boolean isValidEmail(String email) {
		if (email == null || email.isEmpty()) {
			return false;
		}

		return EMAIL_PATTERN.matcher(email).matches();
	}

}
