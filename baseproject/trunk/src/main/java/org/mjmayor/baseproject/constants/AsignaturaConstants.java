package org.mjmayor.baseproject.constants;

import org.mjmayor.baseproject.constants.application.ApplicationConstants;

/**
 * Constantes de Asignatura
 * 
 * @author Manuel Jose Mayor Perez
 * @date 22/06/2013
 */
public class AsignaturaConstants {

	public class Database {

		public static final String TABLE_NAME = "asignatura";
		public static final String SERIAL_ID_LABEL = "serial_id_asignatura";
		public static final String SERIAL_ID_STRAGEGY = "increment";

		public class Queries {
			public static final String FIELD = "field";
			public static final String VALUE = "value";
			public static final String FIND_ALL = "from AsignaturaDTO";
			public static final String FIND_BY_FIELD = "from AsignaturaDTO where %s = :value";
			public static final String FIND_LIKE_FIELD = "from AsignaturaDTO where %s like :value";
			public static final String FIND_LIKE = "from AsignaturaDTO where ";
		}

	}

	public class Fields {
		public static final String CODIGO = "codigo";
		public static final String NOMBRE = "nombre";
		public static final String CURSO = "curso";
		public static final String CREDITOS = "creditos";
	}

	public static final String PATH = "/asignatura";
	public static final String FORM = PATH + ApplicationConstants.FORM;
	public static final String INSERT = PATH + ApplicationConstants.INSERT;
	public static final String DELETE = PATH + ApplicationConstants.DELETE;
	public static final String GETALL = PATH + ApplicationConstants.GETALL;
	public static final String INSERTOK = PATH + ApplicationConstants.INSERT_OK;
	public static final String DELETEOK = PATH + ApplicationConstants.DELETE_OK;
	public static final String DATA = PATH + ApplicationConstants.DATA;
	public static final String LIST = PATH + ApplicationConstants.LIST;
	public static final String ASIGNATURA_DATA = "asignaturaForm";
	public static final String ASIGNATURAS_LIST_DATA = "asignaturas";
}
