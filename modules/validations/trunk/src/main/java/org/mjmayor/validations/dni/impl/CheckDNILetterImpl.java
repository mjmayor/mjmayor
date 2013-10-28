package org.mjmayor.validations.dni.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.mjmayor.validations.dni.CheckDNILetter;

public class CheckDNILetterImpl implements ConstraintValidator<CheckDNILetter, String> {

	public void initialize(CheckDNILetter arg0) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(String obj, ConstraintValidatorContext context) {

		if (obj != null && !"".equals(obj)) {
			try {
				int dni = Integer.parseInt(obj.substring(0, obj.length() - 1));
				char letra = obj.substring(obj.length() - 1).toUpperCase().charAt(0);

				return letra == calculaLetra(dni);
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Devuelve la letra a partir del DNI
	 * 
	 * @param dni
	 *            DNI del que se quiere calcular la letra
	 * @return Letra correspondiente al DNI
	 */
	private char calculaLetra(int dni) {
		String juegoCaracteres = "TRWAGMYFPDXBNJZSQVHLCKET";
		int modulo = dni % 23;
		char letra = juegoCaracteres.charAt(modulo);
		return letra;
	}
}
