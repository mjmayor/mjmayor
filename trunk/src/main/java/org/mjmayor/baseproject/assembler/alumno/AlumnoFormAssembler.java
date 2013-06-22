package org.mjmayor.baseproject.assembler.alumno;

import org.mjmayor.baseproject.assembler.support.AbstractAssembler;
import org.mjmayor.baseproject.dto.AlumnoDTO;
import org.mjmayor.baseproject.form.AlumnoForm;

public class AlumnoFormAssembler extends AbstractAssembler<AlumnoForm, AlumnoDTO> {

    @Override
    public AlumnoDTO assemble(AlumnoForm alumnoForm) {

	AlumnoDTO alumnoDTO = new AlumnoDTO();

	alumnoDTO.setDni(alumnoForm.getDni());
	alumnoDTO.setNombre(alumnoForm.getNombre());
	alumnoDTO.setApellidos(alumnoForm.getApellidos());
	alumnoDTO.setEmail(alumnoForm.getEmail());

	return alumnoDTO;
    }
}
