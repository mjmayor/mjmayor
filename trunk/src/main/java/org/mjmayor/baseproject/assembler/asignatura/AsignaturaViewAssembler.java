package org.mjmayor.baseproject.assembler.asignatura;

import org.mjmayor.baseproject.assembler.support.AbstractAssembler;
import org.mjmayor.baseproject.dto.AsignaturaDTO;
import org.mjmayor.baseproject.view.AsignaturaView;
import org.springframework.beans.BeanUtils;

public class AsignaturaViewAssembler extends AbstractAssembler<AsignaturaDTO, AsignaturaView> {

	@Override
	public AsignaturaView assemble(AsignaturaDTO asignaturaDTO) {
		AsignaturaView asignaturaView = new AsignaturaView();
		BeanUtils.copyProperties(asignaturaDTO, asignaturaView);
		return asignaturaView;
	}
}
