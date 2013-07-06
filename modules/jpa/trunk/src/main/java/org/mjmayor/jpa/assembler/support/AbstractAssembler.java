package org.mjmayor.jpa.assembler.support;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractAssembler<SOURCE, TARGET> implements Assembler<SOURCE, TARGET> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.irtve.plataforma.components.core.assembler.Assembler#canConver(java .lang.Class)
	 */
	public boolean canConvert(Class<?> clazz) {
		Class<?> srcClass = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz.isAssignableFrom(srcClass);
	}

	public PageResult<TARGET> assemble(PageResult<SOURCE> source) {
		if (source == null || source.numElements == 0) {
			return new PageResult<TARGET>(0, 0, 0, 0, 0, 0, new ArrayList<TARGET>(0));
		}
		List<TARGET> result = new ArrayList<TARGET>(source.numElements);
		for (SOURCE s : source.items) {
			result.add(assemble(s));
		}
		return createPageResult(source, result);
	}

	public Collection<TARGET> assemble(Collection<SOURCE> source) {
		if (source == null || source.isEmpty()) {
			return new ArrayList<TARGET>(0);
		}
		List<TARGET> items = new ArrayList<TARGET>(source.size());
		for (SOURCE s : source) {
			items.add(assemble(s));
		}
		return items;
	}

	private PageResult<TARGET> createPageResult(PageResult<SOURCE> source, List<TARGET> items) {
		return new PageResult<TARGET>(source.size, source.offset, source.number, source.total, source.totalPages, source.numElements, items);
	}
}
