package com.jd.app.db.dao.common;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jd.app.db.entity.CommonEntity;

@SuppressWarnings("unchecked")
public class CommonDao implements Serializable {

	private static final long serialVersionUID = -749545283292765905L;

	@Autowired
	protected SessionFactory sessionFactory;

	private Class<?> clazz;

	protected final void setClass(@NotNull final Class<?> clazz) {
		this.clazz = clazz;
	}

	public CommonEntity findById(final long id) {
		return (CommonEntity) getSession().get(clazz, id);
	}

	public CommonEntity findById(@NotNull final String id) {
		return (CommonEntity) getSession().get(clazz, id);
	}

	public List<CommonEntity> findAll() {
		return getSession().createQuery("from " + clazz.getName())
				.getResultList();
	}

	public Serializable create(@NotNull final CommonEntity entity) {
		return getSession().save(entity);
	}

	public CommonEntity update(@NotNull final CommonEntity entity) {
		return (CommonEntity) getSession().merge(entity);
	}

	public void delete(@NotNull final CommonEntity entity) {
		getSession().delete(entity);
	}

	public void deleteById(@NotNull final long entityId) {
		final CommonEntity entity = findById(entityId);
		delete(entity);
	}

	public void deleteById(String entityId) {
		final CommonEntity entity = findById(entityId);
		delete(entity);

	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
