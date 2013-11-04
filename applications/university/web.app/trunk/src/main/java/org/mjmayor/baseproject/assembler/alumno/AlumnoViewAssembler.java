package org.mjmayor.baseproject.assembler.alumno;

import org.mjmayor.baseproject.view.AlumnoView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.dto.AlumnoDTO;

public class AlumnoViewAssembler extends AbstractAssembler<AlumnoDTO, AlumnoView> {

	@Override
	public AlumnoView assemble(AlumnoDTO source) {
		AlumnoView target = new AlumnoView();
		target.setDni(source.getDni());
		target.setNombreCompleto(source.getApellidos() + ", " + source.getNombre());
		target.setFechaNacimiento(source.getFechaNacimiento());
		target.setEmail(source.getEmail());
		return target;
	}
}
