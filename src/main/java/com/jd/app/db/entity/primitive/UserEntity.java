package com.jd.app.db.entity.primitive;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.jd.app.db.entity.CommonEntity;

@Entity
@Table(name = "users")
@ToString(callSuper = true)
public class UserEntity extends CommonEntity {

	private static final long serialVersionUID = -1728567001400964503L;

	@Id
	@Getter
	@Setter
	@Column(name = "user_id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Getter
	@Setter
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	private LoginEntity login;

	@Getter
	@Setter
	@Column(name = "username")
	private String username;

	@Getter
	@Setter
	@Column(name = "firstname")
	private String firstname;

	@Getter
	@Setter
	@Column(name = "lastname")
	private String lastname;

	@Getter
	@Setter
	@Column(name = "birthdate")
	private Date birthdate;

	@Getter
	@Setter
	@Column(name = "sex")
	private short sex;

	@Getter
	@Setter
	@Column(name = "avatar")
	private String avatar;
}
