package com.jd.app.db.dao.def;

import com.jd.app.db.entity.primitive.LoginEntity;

public interface LoginDao {

	public void insertLoginWithUser(LoginEntity loginEntity);

	public LoginEntity getAuthenticationInfo(LoginEntity loginEntity);
}
