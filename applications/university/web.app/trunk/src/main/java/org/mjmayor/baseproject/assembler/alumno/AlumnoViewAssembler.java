package org.mjmayor.baseproject.assembler.alumno;

import java.text.ParseException;

import org.mjmayor.baseproject.view.AlumnoView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.dto.AlumnoDTO;
import org.mjmayor.utils.date.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlumnoViewAssembler extends AbstractAssembler<AlumnoDTO, AlumnoView> {

	private static final Logger logger = LoggerFactory.getLogger(AlumnoViewAssembler.class);

	private static final String DATE_FORMAT = "dd/MM/yyyy";

	@Override
	public AlumnoView assemble(AlumnoDTO source) {
		AlumnoView target = new AlumnoView();
		target.setDni(source.getDni());
		target.setNombreCompleto(source.getApellidos() + ", " + source.getNombre());
		String fechaNacimiento = "";
		try {
			fechaNacimiento = DateUtils.dateToString(source.getFechaNacimiento(), DATE_FORMAT);
		} catch (ParseException e) {
			logger.error("Error en el parseo de la fecha: " + e);
		}
		target.setFechaNacimiento(fechaNacimiento);
		target.setEmail(source.getEmail());
		return target;
	}
}
