package org.mjmayor.baseproject.assembler.alumno;

import org.mjmayor.baseproject.view.AlumnoView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.entity.Alumno;

public class AlumnoViewAssembler extends AbstractAssembler<Alumno, AlumnoView> {

	@Override
	public AlumnoView assemble(Alumno source) {
		AlumnoView destination = new AlumnoView();
		destination.setDni(source.getDni());
		destination.setNombreCompleto(source.getApellidos() + ", " + source.getNombre());
		destination.setEmail(source.getEmail());
		return destination;
	}
}
