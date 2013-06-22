package org.mjmayor.baseproject.assembler.support;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -1469819404477393119L;
    public final int size;
    public final int offset;
    public final int number;
    public final long total;
    public final int totalPages;
    public final int numElements;
    public final List<T> items;

    public PageResult(int size, int offset, int number, long total, int totalPages, int numElements, List<T> items) {
	this.size = size;
	this.offset = offset;
	this.number = number;
	this.total = total;
	this.totalPages = totalPages;
	this.numElements = numElements;
	this.items = items;
    }

    public String toString() {
	return String.format("PageResult [size=%s, offset=%s, number=%s, total=%s, totalPages=%s, numElements=%s, items=%s]",
		new Object[] { Integer.valueOf(this.size), Integer.valueOf(this.offset), Integer.valueOf(this.number), Long.valueOf(this.total),
			Integer.valueOf(this.totalPages), Integer.valueOf(this.numElements), this.items });
    }
}
