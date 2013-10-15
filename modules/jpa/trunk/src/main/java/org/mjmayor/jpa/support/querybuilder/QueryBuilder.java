package org.mjmayor.jpa.support.querybuilder;

import java.util.List;

/**
 * Clase para construir consultar genericas
 * 
 * @author Manuel Jose Mayor Perez
 * @date 15/10/2013
 */
public class QueryBuilder<T> {

	/**
	 * Clase a la que se accedera en la consulta
	 */
	private Class<T> from;

	/**
	 * Condiciones de la clausula where
	 */
	private Object where;

	/**
	 * Parametros para la clausula orderBy
	 */
	private List<OrderField> orderBy;

	private Object groupBy;

	private Object having;
}
