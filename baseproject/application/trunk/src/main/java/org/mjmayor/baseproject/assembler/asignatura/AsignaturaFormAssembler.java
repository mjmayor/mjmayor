package org.mjmayor.baseproject.assembler.asignatura;

import org.mjmayor.baseproject.form.AsignaturaForm;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.entity.Asignatura;
import org.springframework.beans.BeanUtils;

public class AsignaturaFormAssembler extends AbstractAssembler<AsignaturaForm, Asignatura> {

	@Override
	public Asignatura assemble(AsignaturaForm asignaturaForm) {
		Asignatura asignaturaDTO = new Asignatura();
		BeanUtils.copyProperties(asignaturaForm, asignaturaDTO);
		return asignaturaDTO;
	}
}
