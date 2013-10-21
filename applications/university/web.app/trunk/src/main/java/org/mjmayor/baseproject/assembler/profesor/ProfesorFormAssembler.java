package org.mjmayor.baseproject.assembler.profesor;

import org.mjmayor.baseproject.form.ProfesorForm;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.dto.ProfesorDTO;
import org.springframework.beans.BeanUtils;

public class ProfesorFormAssembler extends AbstractAssembler<ProfesorForm, ProfesorDTO> {

	@Override
	public ProfesorDTO assemble(ProfesorForm source) {
		ProfesorDTO target = new ProfesorDTO();
		BeanUtils.copyProperties(source, target);
		return target;
	}
}
