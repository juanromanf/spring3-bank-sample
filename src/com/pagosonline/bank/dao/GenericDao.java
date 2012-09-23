package com.pagosonline.bank.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

	public List<T> getAll(String orderBy);

	public T findByPK(PK id);

	public T insert(T object);

	public T update(T object);

	public void delete(T object);

	public List<T> getPaginated(int startPosition, int maxResult);

	public List<T> getOrderedPaginated(int startPosition, int maxResult,
			String order, int dir);

}
