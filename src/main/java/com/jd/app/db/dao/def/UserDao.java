package com.jd.app.db.dao.def;

import com.jd.app.db.entity.primitive.UserEntity;

public interface UserDao {

	public long insertUserWithCredentials(UserEntity userEntity);

	public void updateUser(UserEntity userEntity);
}
