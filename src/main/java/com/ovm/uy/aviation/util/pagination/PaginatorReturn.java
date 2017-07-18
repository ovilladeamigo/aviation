package com.ovm.uy.aviation.util.pagination;

import java.io.Serializable;
import java.util.List;

public class PaginatorReturn<T extends Serializable> implements Serializable {
	private static final long serialVersionUID = 3429003285703979090L;
	private List<T> results;
	private int size;

	public PaginatorReturn(List<T> results, int size) {
		super();
		this.results = results;
		this.size = size;
	}

	public List<T> getResults() {
		return results;
	}

	public int getSize() {
		return size;
	}
}
