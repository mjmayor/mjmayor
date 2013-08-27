package org.mjmayor.jpa.assembler;

import java.util.Collection;

public interface Assembler<SOURCE, TARGET> {

	public boolean canConvert(Class<?> clazz);

	public TARGET assemble(SOURCE source);

	public Collection<TARGET> assemble(Collection<SOURCE> source);

	public PageResult<TARGET> assemble(PageResult<SOURCE> source);
}
