package com.jd.app.db.dao.impl;

import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Repository;

import com.jd.app.db.dao.common.CommonDao;
import com.jd.app.db.dao.def.LoginDao;
import com.jd.app.db.entity.primitive.LoginEntity;

@Log4j2
@Repository
public class LoginDaoImpl extends CommonDao implements LoginDao {

	private static final long serialVersionUID = -6157743926725977815L;

	public LoginDaoImpl() {
		setClass(LoginEntity.class);
	}

	public void insert(LoginEntity loginEntity) {

	}

	@Override
	public void insertLoginWithUser(LoginEntity loginEntity) {
		try {
			create(loginEntity);
		} catch (Exception e) {
			log.error("Could not write data into UserEntity table: \n"
					+ loginEntity.toString(), e);
		}
	}

	@Override
	public LoginEntity getAuthenticationInfo(LoginEntity loginEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String entityId) {
		// TODO Auto-generated method stub

	}
}
