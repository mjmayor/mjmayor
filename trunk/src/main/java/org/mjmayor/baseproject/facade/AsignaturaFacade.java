package org.mjmayor.baseproject.facade;

import java.util.List;

import org.mjmayor.baseproject.form.AsignaturaForm;
import org.mjmayor.baseproject.view.AsignaturaView;

public interface AsignaturaFacade {

	/**
	 * Añade una asignatura
	 * 
	 * @param asignaturaForm
	 *            Formulario con los datos de la asignatura
	 */
	public void addAsignatura(AsignaturaForm asignaturaForm);

	/**
	 * Obtiene el listado completo de asinaturas
	 * 
	 * @return Listado de todas las asignaturas
	 */
	public List<AsignaturaView> getAsignaturas();

	/**
	 * Busca asignaturas por codigo
	 * 
	 * @param asignaturaForm
	 *            Formulario con los datos de la asignatura a buscar
	 * @return Listado de asignaturas que coinciden con los valores dados en el formulario
	 */
	public List<AsignaturaView> getAsignaturasByCod(AsignaturaForm asignaturaForm);

	/**
	 * Busca asignaturas por codigo de forma aproximada
	 * 
	 * @param asignaturaForm
	 *            Formulario con los datos de la asignatura a buscar
	 * @return Listado de asignaturas que coinciden con los valores dados en el formulario
	 */
	public List<AsignaturaView> getAsignaturasLikeCod(AsignaturaForm asignaturaForm);

	/**
	 * Busca asignaturas por nombre de forma aproximada
	 * 
	 * @param asignaturaForm
	 *            Formulario con los datos de la asignatura a buscar
	 * @return Listado de asignaturas que coinciden con los valores dados en el formulario
	 */
	public List<AsignaturaView> getAsignaturasLikeName(AsignaturaForm asignaturaForm);

	/**
	 * Elimina una asignatura
	 * 
	 * @param asignaturaForm
	 *            Formulario con los datos de la asignatura a eliminar
	 */
	public void removeAsignatura(AsignaturaForm asignaturaForm);
}
