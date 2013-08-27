package org.mjmayor.jpa.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.mjmayor.jpa.constants.PersistentConstants;

/**
 * Clase generica usada por todos los objetos de la capa de persistencia <br/>
 * Asegura que todos los objetos de persistencia tengan un id autogenerado unico
 * 
 * @author Manuel Jose Mayor Perez
 * @date 21/08/2013
 */
@MappedSuperclass
public class PersistentObject implements Serializable {

	private static final long serialVersionUID = -6732218939665196308L;

	@Id
	@GenericGenerator(name = PersistentConstants.SERIAL_ID_LABEL, strategy = PersistentConstants.SERIAL_ID_STRATEGY)
	@GeneratedValue(generator = PersistentConstants.SERIAL_ID_LABEL)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
