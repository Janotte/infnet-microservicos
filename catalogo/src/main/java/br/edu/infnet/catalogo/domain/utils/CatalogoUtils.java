package br.edu.infnet.catalogo.domain.utils;

public class CatalogoUtils {
	
	public static String capitalize(String str) {
		String saida = "";

		if (str == null) {
			saida = null;
		} else {
			str = " " + str;
			for (int i = 0; i < str.length();) {
				char ch = str.charAt(i);

				if (ch == ' ') {
					saida = saida + ' ' + Character.toUpperCase(str.charAt(i + 1));
					i = i + 2;
				} else {
					saida = saida + Character.toLowerCase(str.charAt(i));
					i++;
				}
			}
		}
		saida = saida.replaceFirst(" ", "");
		return saida;
	}

	public static String makeLowerCase(String stringToLower) {
		String stringLowered = "";

		if (stringToLower == null)
			return null;

		for (int i = 0; i < stringToLower.length(); i++) {
			stringLowered = stringLowered + Character.toLowerCase(stringToLower.charAt(i));
		}

		return stringLowered;
	}

	public static String makeUpperCase(String stringToUpper) {
		String stringUppered = "";

		if (stringToUpper == null)
			return null;

		for (int i = 0; i < stringToUpper.length(); i++) {
			stringUppered = stringUppered + Character.toUpperCase(stringToUpper.charAt(i));
		}

		return stringUppered;
	}
}
