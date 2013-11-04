package org.mjmayor.persistence.assembler.asignatura;

import org.mjmayor.jpa.assembler.AbstractBidirectionalAssembler;
import org.mjmayor.model.dto.AsignaturaDTO;
import org.mjmayor.model.entity.Asignatura;
import org.springframework.beans.BeanUtils;

public class AsignaturaDTOAssembler extends AbstractBidirectionalAssembler<Asignatura, AsignaturaDTO> {

	@Override
	public AsignaturaDTO assemble(Asignatura source) {
		AsignaturaDTO target = new AsignaturaDTO();
		BeanUtils.copyProperties(source, target);
		return target;
	}

	@Override
	public Asignatura reverseAssemble(AsignaturaDTO source) {
		Asignatura target = new Asignatura();
		BeanUtils.copyProperties(source, target);
		return target;
	}
}
