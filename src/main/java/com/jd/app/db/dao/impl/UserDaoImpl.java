package com.jd.app.db.dao.impl;

import java.util.Date;

import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Repository;

import com.jd.app.db.dao.common.CommonDao;
import com.jd.app.db.dao.def.UserDao;
import com.jd.app.db.entity.primitive.LoginEntity;
import com.jd.app.db.entity.primitive.UserEntity;

@Log4j2
@Repository
public class UserDaoImpl extends CommonDao implements UserDao {

	private static final long serialVersionUID = -3665023914005000010L;

	@Override
	public long insertUserWithCredentials(UserEntity userEntity) {
		long loginId = 0;
		try {
			userEntity.setActive(true);
			userEntity.setCreatedAt(new Date());
			userEntity.setUpdatedAt(new Date());

			LoginEntity loginEntity = userEntity.getLogin();
			userEntity.setActive(true);
			userEntity.setCreatedAt(new Date());
			userEntity.setUpdatedAt(new Date());
			create(userEntity);

			loginId = loginEntity.getLoginId();
		} catch (Exception e) {
			log.error("Could not write data into UserEntity table: \n"
					+ userEntity.toString(), e);
		}

		return loginId;
	}

	@Override
	public void updateUser(UserEntity userEntity) {
		// TODO Auto-generated method stub

	}
}
