package org.mjmayor.persistence.assembler.alumno;

import org.mjmayor.jpa.assembler.AbstractBidirectionalAssembler;
import org.mjmayor.model.dto.AlumnoDTO;
import org.mjmayor.model.entity.Alumno;
import org.springframework.beans.BeanUtils;

public class AlumnoDTOAssembler extends AbstractBidirectionalAssembler<Alumno, AlumnoDTO> {

	@Override
	public AlumnoDTO assemble(Alumno source) {
		AlumnoDTO target = new AlumnoDTO();
		BeanUtils.copyProperties(source, target);
		return target;
	}

	@Override
	public Alumno reverseAssemble(AlumnoDTO source) {
		Alumno target = new Alumno();
		BeanUtils.copyProperties(source, target);
		return target;
	}
}
