package org.mjmayor.jpa.assembler;

public interface AssemblerSelector {
	<SRC, TARGET> Assembler<SRC, TARGET> getAssemblerFor(Class<?> clazz);
}
