package org.mjmayor.baseproject.utils;

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
	 * @param clazz Clase que se desea que tengan los objetos de la lista
	 * @param c Coleccion generica que se desea convertir
	 * @return Lista del tipo indicado
	 */
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}
