package org.mjmayor.baseproject.assembler.profesor;

import org.mjmayor.baseproject.dto.ProfesorDTO;
import org.mjmayor.baseproject.view.ProfesorView;
import org.mjmayor.jpa.assembler.AbstractBidirectionalAssembler;

public class ProfesorViewAssembler extends AbstractBidirectionalAssembler<ProfesorDTO, ProfesorView> {

	@Override
	public ProfesorView assemble(ProfesorDTO profesorDTO) {
		ProfesorView profesorView = new ProfesorView();
		profesorView.setDni(profesorDTO.getDni());
		profesorView.setNombreCompleto(profesorDTO.getNombre() + " " + profesorDTO.getApellidos());
		return profesorView;
	}

	@Override
	public ProfesorDTO reverseAssemble(ProfesorView target) {
		// TODO Auto-generated method stub
		return null;
	}
}
