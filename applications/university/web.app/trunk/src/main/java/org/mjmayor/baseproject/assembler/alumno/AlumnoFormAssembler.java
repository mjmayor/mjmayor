package org.mjmayor.baseproject.assembler.alumno;

import org.mjmayor.baseproject.form.AlumnoForm;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.dto.AlumnoDTO;
import org.springframework.beans.BeanUtils;

public class AlumnoFormAssembler extends AbstractAssembler<AlumnoForm, AlumnoDTO> {

	@Override
	public AlumnoDTO assemble(AlumnoForm source) {
		AlumnoDTO target = new AlumnoDTO();
		BeanUtils.copyProperties(source, target);
		return target;
	}
}
