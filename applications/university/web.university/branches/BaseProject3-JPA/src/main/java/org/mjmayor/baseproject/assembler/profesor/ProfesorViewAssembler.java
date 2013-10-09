package org.mjmayor.baseproject.assembler.profesor;

import org.mjmayor.baseproject.assembler.support.AbstractAssembler;
import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.view.ProfesorView;

public class ProfesorViewAssembler extends AbstractAssembler<ProfesorDTO, ProfesorView> {

	@Override
	public ProfesorView assemble(ProfesorDTO profesorDTO) {
		ProfesorView profesorView = new ProfesorView();
		profesorView.setDni(profesorDTO.getDni());
		profesorView.setNombreCompleto(profesorDTO.getNombre() + " " + profesorDTO.getApellidos());
		return profesorView;
	}
}
