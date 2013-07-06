package org.mjmayor.jpa.assembler.support;

public interface AssemblerSelector {
	<SRC, TARGET> Assembler<SRC, TARGET> getAssemblerFor(Class<?> clazz);
}
