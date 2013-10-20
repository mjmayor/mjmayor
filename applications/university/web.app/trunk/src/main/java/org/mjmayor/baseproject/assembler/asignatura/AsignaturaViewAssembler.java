package org.mjmayor.baseproject.assembler.asignatura;

import org.mjmayor.baseproject.view.AsignaturaView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.entity.Asignatura;
import org.springframework.beans.BeanUtils;

public class AsignaturaViewAssembler extends AbstractAssembler<Asignatura, AsignaturaView> {

	@Override
	public AsignaturaView assemble(Asignatura source) {
		AsignaturaView destination = new AsignaturaView();
		BeanUtils.copyProperties(source, destination);
		return destination;
	}
}
