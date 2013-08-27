package org.mjmayor.baseproject.assembler.profesor;

import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.entity.Profesor;
import org.mjmayor.jpa.assembler.AbstractBidirectionalAssembler;
import org.springframework.beans.BeanUtils;

public class ProfesorDTOAssembler extends AbstractBidirectionalAssembler<ProfesorDTO, Profesor> {

	@Override
	public Profesor assemble(ProfesorDTO profesorDTO) {
		Profesor profesor = new Profesor();
		BeanUtils.copyProperties(profesorDTO, profesor);
		return profesor;
	}

	@Override
	public ProfesorDTO reverseAssemble(Profesor profesor) {
		ProfesorDTO profesorDTO = new ProfesorDTO();
		BeanUtils.copyProperties(profesor, profesorDTO);
		return profesorDTO;
	}
}
