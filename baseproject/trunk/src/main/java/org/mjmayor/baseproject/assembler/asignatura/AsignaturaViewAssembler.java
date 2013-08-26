package org.mjmayor.baseproject.assembler.asignatura;

import org.mjmayor.baseproject.entity.Asignatura;
import org.mjmayor.baseproject.view.AsignaturaView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.springframework.beans.BeanUtils;

public class AsignaturaViewAssembler extends AbstractAssembler<Asignatura, AsignaturaView> {

	@Override
	public AsignaturaView assemble(Asignatura asignaturaDTO) {
		AsignaturaView asignaturaView = new AsignaturaView();
		BeanUtils.copyProperties(asignaturaDTO, asignaturaView);
		return asignaturaView;
	}
}
