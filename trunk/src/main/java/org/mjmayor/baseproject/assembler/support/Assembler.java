package org.mjmayor.baseproject.assembler.support;

import java.util.Collection;

public interface Assembler<SOURCE, TARGET> {

    boolean canConvert(Class<?> clazz);

    TARGET assemble(SOURCE source);

    Collection<TARGET> assemble(Collection<SOURCE> source);

    PageResult<TARGET> assemble(PageResult<SOURCE> source);
}
