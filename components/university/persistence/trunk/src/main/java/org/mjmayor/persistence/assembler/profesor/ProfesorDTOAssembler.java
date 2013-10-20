package org.mjmayor.persistence.assembler.profesor;

import org.mjmayor.jpa.assembler.AbstractBidirectionalAssembler;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.springframework.beans.BeanUtils;

public class ProfesorDTOAssembler extends AbstractBidirectionalAssembler<Profesor, ProfesorDTO> {

	@Override
	public ProfesorDTO assemble(Profesor source) {
		ProfesorDTO destination = new ProfesorDTO();
		BeanUtils.copyProperties(source, destination);
		return destination;
	}

	@Override
	public Profesor reverseAssemble(ProfesorDTO source) {
		Profesor destination = new Profesor();
		BeanUtils.copyProperties(source, destination);
		return destination;
	}
}
