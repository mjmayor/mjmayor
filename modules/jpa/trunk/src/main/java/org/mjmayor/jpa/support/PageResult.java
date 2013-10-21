package org.mjmayor.jpa.support;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
	private static final long serialVersionUID = -1469819404477393119L;
	private final int size;
	private final int offset;
	private final int number;
	private final long total;
	private final int totalPages;
	private final int numElements;
	private final List<T> items;

	public PageResult(List<T> items, long total, Criteria criteria) {
		PageRequest pageRequest = null;
		this.total = total;
		this.items = items;

		if (criteria != null) {
			pageRequest = criteria.getPageRequest();
		}
		if (pageRequest != null) {
			size = pageRequest.getSize();
			totalPages = getTotalPages(pageRequest);
			number = pageRequest.getPage();
			offset = getOffset(pageRequest);
			numElements = items.size();
		} else {
			size = items.size();
			totalPages = 1;
			number = 1;
			offset = 0;
			numElements = items.size();
		}
	}

	public PageResult(int size, int offset, int number, long total, int totalPages, int numElements, List<T> items) {
		this.size = size;
		this.offset = offset;
		this.number = number;
		this.total = total;
		this.totalPages = totalPages;
		this.numElements = numElements;
		this.items = items;
	}

	private int getTotalPages(PageRequest pageRequest) {
		int size = pageRequest.getSize();
		if (total % size == 0) {
			return (int) total / pageRequest.getSize();
		}
		return (int) total / pageRequest.getSize() + 1;
	}

	private int getOffset(PageRequest pageRequest) {
		if (items.size() <= 0) {
			return 0;
		}
		return pageRequest.getSize() * (pageRequest.getPage() - 1);
	}

	@Override
	public String toString() {
		return String.format("PageResult [size=%s, offset=%s, number=%s, total=%s, totalPages=%s, numElements=%s, items=%s]", size, offset, number, total, totalPages, numElements, items);
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @return the numElements
	 */
	public int getNumElements() {
		return numElements;
	}

	/**
	 * @return the items
	 */
	public List<T> getItems() {
		return items;
	}
}
