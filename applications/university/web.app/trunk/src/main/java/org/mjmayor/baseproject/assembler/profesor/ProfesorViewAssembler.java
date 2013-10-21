package org.mjmayor.baseproject.assembler.profesor;

import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.dto.ProfesorDTO;

public class ProfesorViewAssembler extends AbstractAssembler<ProfesorDTO, ProfesorView> {

	@Override
	public ProfesorView assemble(ProfesorDTO source) {
		ProfesorView target = new ProfesorView();
		target.setDni(source.getDni());
		target.setNombreCompleto(source.getApellidos() + ", " + source.getNombre());
		return target;
	}
}
