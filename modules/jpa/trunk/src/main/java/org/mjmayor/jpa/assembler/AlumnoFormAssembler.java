package org.mjmayor.jpa.assembler;

import org.mjmayor.jpa.assembler.support.AbstractAssembler;
import org.mjmayor.jpa.dto.AlumnoDTO;
import org.mjmayor.jpa.form.AlumnoForm;
import org.springframework.beans.BeanUtils;

public class AlumnoFormAssembler extends AbstractAssembler<AlumnoForm, AlumnoDTO> {

	public AlumnoDTO assemble(AlumnoForm alumnoForm) {
		AlumnoDTO alumnoDTO = new AlumnoDTO();
		BeanUtils.copyProperties(alumnoForm, alumnoDTO);
		return alumnoDTO;
	}
}
