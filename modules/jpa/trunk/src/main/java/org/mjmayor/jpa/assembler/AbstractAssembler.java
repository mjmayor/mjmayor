package org.mjmayor.jpa.assembler;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mjmayor.jpa.support.PageResult;

public abstract class AbstractAssembler<SOURCE, TARGET> implements Assembler<SOURCE, TARGET> {

	public boolean canConvert(Class<?> clazz) {
		Class<?> srcClass = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz.isAssignableFrom(srcClass);
	}

	public PageResult<TARGET> assemble(PageResult<SOURCE> source) {
		if (source == null || source.getNumElements() == 0) {
			return new PageResult<TARGET>(source.getSize(), 0, source.getNumber(), 0, 0, 0, new ArrayList<TARGET>(0));
		}
		List<TARGET> result = new ArrayList<TARGET>(source.getNumElements());
		for (SOURCE s : source.getItems()) {
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
		return new PageResult<TARGET>(source.getSize(), source.getOffset(), source.getNumber(), source.getTotal(), source.getTotalPages(), source.getNumElements(), items);
	}
}
