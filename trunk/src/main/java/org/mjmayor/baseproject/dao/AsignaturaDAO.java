package org.mjmayor.baseproject.dao;

import java.util.List;

import org.mjmayor.baseproject.dto.AsignaturaDTO;
import org.mjmayor.baseproject.form.AsignaturaForm;

public interface AsignaturaDAO {

	/**
	 * Añade una asignatura
	 * 
	 * @param asignaturaForm Formulario con los datos de la asignatura
	 */
	public void addAsignatura(AsignaturaForm asignaturaForm);

	/**
	 * Obtiene el listado completo de asinaturas
	 * 
	 * @return Listado de todas las asignaturas
	 */
	public List<AsignaturaDTO> getAsignaturas();

	/**
	 * Busca un valor exacto por un campo concreto
	 * 
	 * @param field
	 *            Campo por el que buscar
	 * @param value
	 *            Valor buscado
	 * @return Listado de asignaturas que cumplen la condicion
	 */
	public List<AsignaturaDTO> getAsignaturasByField(String field, Object value);

	/**
	 * Busca un valor aproximado por un campo concreto
	 * 
	 * @param field
	 *            Campo por el que buscar
	 * @param value
	 *            Valor buscado
	 * @return Listado de asignaturas que cumplen la condicion
	 */
	public List<AsignaturaDTO> getAsignaturasLikeField(String field, Object value);

	/**
	 * Obtiene el listado de asignaturas que cumplen de forma aproximada con los campos de un formulario
	 * 
	 * @param asignaturaForm
	 *            Formulario cno los datos de la asignatura
	 * @return Listado de asignaturas que cumplen la condicion
	 */
	public List<AsignaturaDTO> getAsignaturas(AsignaturaForm asignaturaForm);

	/**
	 * Elimina una asignatura por codigo
	 * 
	 * @param cod
	 *            Codigo de la asignatura a eliminar
	 */
	public void removeAsignatura(String cod);
}
