package com.jd.app.db.entity.primitive;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.jd.app.db.entity.CommonEntity;

@Entity
@Table(name = "login")
@ToString(callSuper = true)
public class LoginEntity extends CommonEntity {

	private static final long serialVersionUID = 1346916903410587607L;

	@Id
	@Getter
	@Setter
	@Column(name = "login_id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loginId;

	@Getter
	@Setter
	@Column(name = "email")
	private String email;

	@Getter
	@Setter
	@Column(name = "password")
	private String password;
}
