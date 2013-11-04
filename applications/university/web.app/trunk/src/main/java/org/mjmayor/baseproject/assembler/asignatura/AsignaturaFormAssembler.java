package org.mjmayor.baseproject.assembler.asignatura;

import org.mjmayor.baseproject.form.AsignaturaForm;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.dto.AsignaturaDTO;
import org.springframework.beans.BeanUtils;

public class AsignaturaFormAssembler extends AbstractAssembler<AsignaturaForm, AsignaturaDTO> {

	@Override
	public AsignaturaDTO assemble(AsignaturaForm source) {
		AsignaturaDTO target = new AsignaturaDTO();
		BeanUtils.copyProperties(source, target);
		return target;
	}
}
