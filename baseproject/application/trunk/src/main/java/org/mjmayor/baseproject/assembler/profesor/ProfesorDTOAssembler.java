package org.mjmayor.baseproject.assembler.profesor;

import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.entity.Profesor;
import org.mjmayor.jpa.assembler.AbstractBidirectionalAssembler;
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
