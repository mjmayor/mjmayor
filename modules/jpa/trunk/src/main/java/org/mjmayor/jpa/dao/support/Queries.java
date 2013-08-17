package org.mjmayor.jpa.dao.support;

/**
 * Clase de utilidad con las consultas necesarias para el DAO
 * 
 * @author Manuel Jose Mayor Perez
 * @date 17/08/2013
 */
public class Queries {

	private static final String COUNT_ALL = "select count(*) from %s";

	private static final String GET_ALL = "from %s";

	/**
	 * Devuelve la consulta para obtener todos los elementos de una tabla
	 * 
	 * @param persistentClass
	 *            Clase sobre la que realizar la consulta
	 * @return Consulta para obtener todos los elementos de una tabla
	 */
	public static String getAll(Class<?> persistentClass) {
		return String.format(GET_ALL, persistentClass.getSimpleName());
	}

	/**
	 * Devuelve la consulta para contar todos los elementos de una tabla
	 * 
	 * @param persistentClass
	 *            Clase sobre la que realizar la consulta
	 * @return Consulta para contar todos los elementos de una tabla
	 */
	public static String countAll(Class<?> persistentClass) {
		return String.format(COUNT_ALL, persistentClass.getSimpleName());
	}
}
