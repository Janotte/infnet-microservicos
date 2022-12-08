package br.edu.infnet.pessoa.domain.utils;

import br.edu.infnet.pessoa.domain.exceptions.CampoInvalidoException;

public class PessoaUtils {

	public static String formatCep(String cep) {
		if (cep == null)
			return null;
		cep = cep.replaceAll("[^0-9]", "");
		if (cep.length() == 8) {
			cep = cep.replaceAll("(\\d{2})(\\d{3})(\\d{3})", "$1.$2-$3");
		} else {
			throw new CampoInvalidoException("O CEP deve conter 8 digitos");
		}
		return cep;
	}

	public static String formatCpfCnpj(String cpfCnpj) {
		if (cpfCnpj == null)
			return null;
		cpfCnpj = cpfCnpj.replaceAll("[^0-9]", "");
		if (cpfCnpj.length() == 11) {
			cpfCnpj = cpfCnpj.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
		} else if (cpfCnpj.length() == 14) {
			cpfCnpj = cpfCnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
		} else {
			throw new CampoInvalidoException("O CPF ou CNPJ informado não é válido");
		}
		return cpfCnpj;
	}

	public static String formatCelular(String celular) {
		if (celular == null)
			return null;

		celular = celular.replaceAll("[^0-9]", "");

		if (celular.length() != 11) {
			throw new CampoInvalidoException("O número deve conter os dois dígitos do DDD e 9 dígitos do número");
		}
		celular = celular.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");

		return celular;
	}

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
