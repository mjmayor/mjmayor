package org.mjmayor.jpa.assembler;

import java.util.List;

public class DefaultAssemblerSelector implements AssemblerSelector {

	private List<Assembler<?, ?>> assemblerList;

	public DefaultAssemblerSelector(List<Assembler<?, ?>> assemblerList) {
		this.assemblerList = assemblerList;
	}

	@SuppressWarnings("unchecked")
	public <SRC, TARGET> Assembler<SRC, TARGET> getAssemblerFor(Class<?> clazz) {
		for (Assembler<?, ?> assembler : assemblerList) {
			if (assembler.canConvert(clazz)) {
				return (Assembler<SRC, TARGET>) assembler;
			}
		}
		throw new RuntimeException("No se puede encontrar un Assembler para " + clazz.getSimpleName());
	}

}
