package org.mjmayor.baseproject.assembler.profesor;

import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.assembler.AbstractAssembler;
import org.mjmayor.model.dto.ProfesorDTO;

public class ProfesorViewAssembler extends AbstractAssembler<ProfesorDTO, ProfesorView> {

	@Override
	public ProfesorView assemble(ProfesorDTO dto) {
		ProfesorView profesorView = new ProfesorView();
		profesorView.setDni(dto.getDni());
		profesorView.setNombreCompleto(dto.getNombre() + " " + dto.getApellidos());
		return profesorView;
	}
}
