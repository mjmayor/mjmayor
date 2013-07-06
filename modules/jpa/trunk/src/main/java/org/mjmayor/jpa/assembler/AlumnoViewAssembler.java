package org.mjmayor.jpa.assembler;

import org.mjmayor.jpa.assembler.support.AbstractAssembler;
import org.mjmayor.jpa.dto.AlumnoDTO;
import org.mjmayor.jpa.view.AlumnoView;

public class AlumnoViewAssembler extends AbstractAssembler<AlumnoDTO, AlumnoView> {

	public AlumnoView assemble(AlumnoDTO alumnoDTO) {
		AlumnoView alumnoView = new AlumnoView();
		alumnoView.setDni(alumnoDTO.getDni());
		alumnoView.setNombreCompleto(alumnoDTO.getNombre() + " " + alumnoDTO.getApellidos());
		alumnoView.setEmail(alumnoDTO.getEmail());
		return alumnoView;
	}
}
