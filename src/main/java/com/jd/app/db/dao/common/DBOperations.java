package com.jd.app.db.dao.common;

import java.util.List;

import com.jd.app.db.entity.CommonEntity;

public interface DBOperations {

	CommonEntity findById(final long id);

	CommonEntity findById(final String id);

	List<CommonEntity> findAll();

	void create(final CommonEntity entity);

	CommonEntity update(final CommonEntity entity);

	void delete(final CommonEntity entity);

	void deleteById(final long entityId);

	void deleteById(final String entityId);
}
