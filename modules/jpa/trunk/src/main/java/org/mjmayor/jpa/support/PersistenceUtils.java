package org.mjmayor.jpa.support;

/**
 * Clase con utilidades para persistencia
 * 
 * @author Manuel Jose Mayor Perez
 * @date 13/10/2013
 */
public class PersistenceUtils {

	/**
	 * Devuelve el indice del primer resultado a mostrar
	 * 
	 * @param pageRequest
	 *            Parametros de paginacion
	 * @return Indice del primer valor sobre el que se debe empezar la paginacion
	 */
	public static int getFirstResult(PageRequest pageRequest) {
		return (pageRequest.getPage() - 1) * pageRequest.getSize();
	}
}
