package org.mjmayor.jpa.assembler;

import java.util.Collection;

import org.mjmayor.jpa.support.PageResult;

public interface Assembler<SOURCE, TARGET> {

	boolean canConvert(Class<?> clazz);

	TARGET assemble(SOURCE source);

	Collection<TARGET> assemble(Collection<SOURCE> source);

	PageResult<TARGET> assemble(PageResult<SOURCE> source);
}
