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
	    public static final String FIND_ALL = "from AsignaturaDTO";
	    public static final String FIND_BY_COD = "from AsignaturaDTO where codigo = :codigo";
	    public static final String FIND_BY_NAME = "from AsignaturaDTO where nombre like %:codigo%";
	}

    }

    public class Fields {
	public static final String CODIGO = "codigo";
    }

    public static final String PATH = "/asignatura";
    public static final String FORM = PATH + ApplicationConstants.FORM;
    public static final String INSERT = PATH + ApplicationConstants.INSERT;
    public static final String DELETE = PATH + ApplicationConstants.DELETE;
    public static final String GET = PATH + ApplicationConstants.GET;
    public static final String GETALL = PATH + ApplicationConstants.GETALL;
    public static final String INSERTOK = PATH + ApplicationConstants.INSERTOK;
    public static final String DELETEOK = PATH + ApplicationConstants.DELETEOK;
    public static final String DATA = PATH + ApplicationConstants.DATA;
    public static final String LIST = PATH + ApplicationConstants.LIST;
    public static final String ALUMNO_DATA = "asignaturaForm";
    public static final String ALUMNOS_LIST_DATA = "asignaturas";
}
