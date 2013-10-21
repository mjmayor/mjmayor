package org.mjmayor.jpa.support;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PageResultTest {

	private <T> PageResult<T> createGenericPageResultGenerator(int total, int size, int page, int numElements) {
		List<T> items = new ArrayList<T>();
		for (int i = 0; i < numElements; i++) {
			items.add(null);
		}
		Criteria criteria = new Criteria();
		criteria.setPageRequest(new PageRequest(page, size));
		PageResult<T> pageResult = new PageResult<T>(items, total, criteria);
		return pageResult;
	}

	private <T> PageResult<T> createPageResultGenerator1() {
		return createGenericPageResultGenerator(37, 10, 1, 10);
	}

	private <T> PageResult<T> createPageResultGenerator2() {
		return createGenericPageResultGenerator(37, 5, 4, 5);
	}

	private <T> PageResult<T> createPageResultGenerator3() {
		return createGenericPageResultGenerator(20, 10, 2, 10);
	}

	private <T> PageResult<T> createPageResultGenerator4() {
		return createGenericPageResultGenerator(10, 7, 2, 3);
	}

	@Test
	public void testTotalPages() {
		PageResult<Object> pageResult = createPageResultGenerator1();
		assertEquals(pageResult.getTotalPages(), 4);

		pageResult = createPageResultGenerator2();
		assertEquals(pageResult.getTotalPages(), 8);

		pageResult = createPageResultGenerator3();
		assertEquals(pageResult.getTotalPages(), 2);

		pageResult = createPageResultGenerator4();
		assertEquals(pageResult.getTotalPages(), 2);
	}

	@Test
	public void testNumElements() {
		PageResult<Object> pageResult = createPageResultGenerator1();
		assertEquals(pageResult.getNumElements(), 10);

		pageResult = createPageResultGenerator2();
		assertEquals(pageResult.getNumElements(), 5);

		pageResult = createPageResultGenerator3();
		assertEquals(pageResult.getNumElements(), 10);

		pageResult = createPageResultGenerator4();
		assertEquals(pageResult.getNumElements(), 3);
	}

	@Test
	public void testOffset() {
		PageResult<Object> pageResult = createPageResultGenerator1();
		assertEquals(pageResult.getOffset(), 0);

		pageResult = createPageResultGenerator2();
		assertEquals(pageResult.getOffset(), 15);

		pageResult = createPageResultGenerator3();
		assertEquals(pageResult.getOffset(), 10);

		pageResult = createPageResultGenerator4();
		assertEquals(pageResult.getOffset(), 7);
	}

}
