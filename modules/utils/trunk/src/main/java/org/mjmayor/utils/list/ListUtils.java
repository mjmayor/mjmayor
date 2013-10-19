package org.mjmayor.utils.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Clase de utilidades para listas
 * 
 * @author Manuel Jose Mayor Perez
 * @date 24/04/2013
 */
public class ListUtils {

	/**
	 * Convierte una coleccion generica a una lista de un tipo determinado
	 * 
	 * @param c
	 *            Coleccion generica que se desea convertir
	 * @param clazz
	 *            Clase que se desea que tengan los objetos de la lista
	 * @return Lista del tipo indicado
	 */
	public static <T> List<T> castList(Collection<?> c, Class<? extends T> clazz) {
		List<T> r = new ArrayList<T>(c.size());
		for (Object o : c) {
			r.add(clazz.cast(o));
		}
		return r;
	}
}
