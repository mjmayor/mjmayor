package org.mjmayor.baseproject.assembler.asignatura;

import org.mjmayor.baseproject.assembler.support.AbstractAssembler;
import org.mjmayor.baseproject.dto.AsignaturaDTO;
import org.mjmayor.baseproject.form.AsignaturaForm;
import org.springframework.beans.BeanUtils;

public class AsignaturaFormAssembler extends AbstractAssembler<AsignaturaForm, AsignaturaDTO> {

	@Override
	public AsignaturaDTO assemble(AsignaturaForm asignaturaForm) {
		AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
		BeanUtils.copyProperties(asignaturaForm, asignaturaDTO);
		return asignaturaDTO;
	}
}
