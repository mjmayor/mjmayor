package org.mjmayor.jpa.assembler;

import java.util.Collection;

public interface BidirectionalAssembler<SOURCE, TARGET> {

	public boolean canConvert(Class<?> clazz);

	public TARGET assemble(SOURCE source);

	public Collection<TARGET> assemble(Collection<SOURCE> source);

	public PageResult<TARGET> assemble(PageResult<SOURCE> source);

	public SOURCE reverseAssemble(TARGET target);

	public Collection<SOURCE> reverseAssemble(Collection<TARGET> source);

	public PageResult<SOURCE> reverseAssemble(PageResult<TARGET> source);
}
