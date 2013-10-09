package org.mjmayor.persistence.assembler.profesor;

import org.mjmayor.jpa.assembler.AbstractBidirectionalAssembler;
import org.mjmayor.model.dto.ProfesorDTO;
import org.mjmayor.model.entity.Profesor;
import org.springframework.beans.BeanUtils;

public class ProfesorDTOAssembler extends AbstractBidirectionalAssembler<Profesor, ProfesorDTO> {

	@Override
	public ProfesorDTO assemble(Profesor profesor) {
		ProfesorDTO profesorDTO = new ProfesorDTO();
		BeanUtils.copyProperties(profesor, profesorDTO);
		return profesorDTO;
	}

	@Override
	public Profesor reverseAssemble(ProfesorDTO profesorDTO) {
		Profesor profesor = new Profesor();
		BeanUtils.copyProperties(profesorDTO, profesor);
		return profesor;
	}
}
