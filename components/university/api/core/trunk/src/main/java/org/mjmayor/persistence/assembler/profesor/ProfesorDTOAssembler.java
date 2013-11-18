package org.mjmayor.persistence.assembler.profesor;

import org.mjmayor.jpa.assembler.AbstractBidirectionalAssembler;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.springframework.beans.BeanUtils;

public class ProfesorDTOAssembler extends AbstractBidirectionalAssembler<Profesor, ProfesorDTO> {

	@Override
	public ProfesorDTO assemble(Profesor source) {
		ProfesorDTO target = new ProfesorDTO();
		BeanUtils.copyProperties(source, target);
		return target;
	}

	@Override
	public Profesor reverseAssemble(ProfesorDTO source) {
		Profesor target = new Profesor();
		BeanUtils.copyProperties(source, target);
		return target;
	}
}
