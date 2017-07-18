package com.ovm.uy.aviation.util.pagination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rmpestano on 9/7/14. class which holds database pagination
 * metadata
 */
@SuppressWarnings("rawtypes")
public class PaginatorFilter<T extends Serializable> {
	private T entity;
	private int first;
	private int pageSize;
	private String sortField;
	private SortOrder sortOrder;
	private Map<String, Object> params = new HashMap<String, Object>();
	private List<String> select = new ArrayList<String> ();

	public PaginatorFilter() {
	}

	public PaginatorFilter(T entity) {
		this.entity = entity;
	}

	public PaginatorFilter setFirst(int first) {
		this.first = first;
		return this;
	}

	public int getFirst() {
		return first;
	}

	public PaginatorFilter setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	public PaginatorFilter setSortField(String sortField) {
		this.sortField = sortField;
		return this;
	}

	public String getSortField() {
		return sortField;
	}

	public PaginatorFilter setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
		return this;
	}

	public SortOrder getSortOrder() {
		return sortOrder;
	}

	public PaginatorFilter setParams(Map<String, Object> params) {
		this.params = params;
		return this;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public List<String> getSelect() {
		return select;
	}

	public PaginatorFilter setSelect(List<String> select) {
		this.select = select;
		return this;
	}

	public T getEntity() {
		return entity;
	}

	public PaginatorFilter setEntity(T entity) {
		this.entity = entity;
		return this;
	}

	public PaginatorFilter addParam(String key, Object value) {
		getParams().put(key, value);
		return this;
	}

	public boolean hasParam(String key) {
		return getParams().containsKey(key) && getParam(key) != null;
	}

	public Object getParam(String key) {
		return getParams().get(key);
	}
}
