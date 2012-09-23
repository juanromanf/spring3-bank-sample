package com.pagosonline.bank.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pagosonline.bank.dao.GenericDao;

@Transactional
public class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {

		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(String orderBy) {

		final StringBuilder sql = new StringBuilder("select c from ").append(
				entityClass.getSimpleName()).append(" c ").append(orderBy);
		final Query query = entityManager.createQuery(sql.toString());

		return (List<T>) query.getResultList();
	}

	@Override
	public T findByPK(PK id) {

		return this.entityManager.find(entityClass, id);
	}

	@Override
	public T insert(T object) {

		this.entityManager.persist(object);
		return object;
	}

	@Override
	public T update(T object) {

		return this.entityManager.merge(object);
	}

	@Override
	public void delete(T object) {

		object = this.entityManager.merge(object);
		this.entityManager.remove(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPaginated(int startPosition, int maxResult) {

		final StringBuilder sql = new StringBuilder("select c from ").append(
				entityClass.getSimpleName()).append(" c");
		final Query query = entityManager.createQuery(sql.toString());
		query.setFirstResult(startPosition);
		query.setMaxResults(maxResult);

		return (List<T>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getOrderedPaginated(int startPosition, int maxResult,
			String order, int dir) {

		String direccion = "ASC";
		if (dir == 2) {
			direccion = "DESC";
		}
		final StringBuilder sql = new StringBuilder("select c from ")
				.append(entityClass.getSimpleName()).append(" c order by ")
				.append(order).append(" ").append(direccion);
		final Query query = entityManager.createQuery(sql.toString());
		query.setFirstResult(startPosition);
		query.setMaxResults(maxResult);

		return (List<T>) query.getResultList();
	}
}
