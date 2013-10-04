package org.mjmayor.baseproject.assembler.profesor;

import org.mjmayor.baseproject.assembler.support.AbstractAssembler;
import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.form.ProfesorForm;
import org.springframework.beans.BeanUtils;

public class ProfesorFormAssembler extends AbstractAssembler<ProfesorForm, ProfesorDTO> {

	@Override
	public ProfesorDTO assemble(ProfesorForm profesorForm) {
		ProfesorDTO profesorDTO = new ProfesorDTO();
		BeanUtils.copyProperties(profesorForm, profesorDTO);
		return profesorDTO;
	}
}
