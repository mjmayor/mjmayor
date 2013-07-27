package org.mjmayor.baseproject.constants;

import org.mjmayor.baseproject.constants.application.ApplicationConstants;

/**
 * Constantes de Alumno
 * 
 * @author Manuel Jose Mayor Perez
 * @date 22/06/2013
 */
public class AlumnoConstants {

	public class Database {

		public static final String TABLE_NAME = "alumno";
		public static final String SERIAL_ID_LABEL = "serial_id_alumno";
		public static final String SERIAL_ID_STRAGEGY = "increment";

		public class Queries {
			public static final String FIND_ALL = "from AlumnoDTO";
			public static final String FIND_BY_DNI = "from AlumnoDTO where dni = :dni";
		}

	}

	public class Fields {
		public static final String DNI = "dni";
	}

	public static final String PATH = "/alumno";
	public static final String FORM = PATH + ApplicationConstants.FORM;
	public static final String INSERT = PATH + ApplicationConstants.INSERT;
	public static final String DELETE = PATH + ApplicationConstants.DELETE;
	public static final String GET = PATH + ApplicationConstants.GET;
	public static final String GETALL = PATH + ApplicationConstants.GETALL;
	public static final String INSERTOK = PATH + ApplicationConstants.INSERT_OK;
	public static final String DELETEOK = PATH + ApplicationConstants.DELETE_OK;
	public static final String DATA = PATH + ApplicationConstants.DATA;
	public static final String LIST = PATH + ApplicationConstants.LIST;
	public static final String ALUMNO_DATA = "alumnoForm";
	public static final String ALUMNOS_LIST_DATA = "alumnos";
}
