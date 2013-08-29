package org.mjmayor.baseproject.assembler.alumno;

import org.mjmayor.baseproject.view.AlumnoView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.entity.Alumno;

public class AlumnoViewAssembler extends AbstractAssembler<Alumno, AlumnoView> {

	@Override
	public AlumnoView assemble(Alumno alumnoDTO) {
		AlumnoView alumnoView = new AlumnoView();
		alumnoView.setDni(alumnoDTO.getDni());
		alumnoView.setNombreCompleto(alumnoDTO.getNombre() + " " + alumnoDTO.getApellidos());
		alumnoView.setEmail(alumnoDTO.getEmail());
		return alumnoView;
	}
}
