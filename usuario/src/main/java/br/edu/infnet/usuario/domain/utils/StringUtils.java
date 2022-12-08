package br.edu.infnet.usuario.domain.utils;

public class StringUtils {

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
					saida = saida + ch;
					i++;
				}
			}
		}
		return saida;
	}
	
	public static String makeLowerCase (String str) {
		String saida = "";
		
		if (str == null)  {
			saida = null;
		} else {
			for(int i = 0; i < str.length(); i++) {
				saida = saida + Character.toLowerCase(str.charAt(i));
			}
		}
		return saida;
	}
	
	public static String makeUpperCase (String str) {
		String saida = "";
		
		if (str == null)  {
			saida = null;
		} else {
			for(int i = 0; i < str.length(); i++) {
				saida = saida + Character.toUpperCase(str.charAt(i));
			}
		}
		return saida;
	}
}
