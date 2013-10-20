package org.mjmayor.baseproject.assembler.profesor;

import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.dto.ProfesorDTO;

public class ProfesorViewAssembler extends AbstractAssembler<ProfesorDTO, ProfesorView> {

	@Override
	public ProfesorView assemble(ProfesorDTO source) {
		ProfesorView destination = new ProfesorView();
		destination.setDni(source.getDni());
		destination.setNombreCompleto(source.getApellidos() + ", " + source.getNombre());
		return destination;
	}
}
