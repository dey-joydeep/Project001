package com.jd.app.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CommonEntity implements Serializable {

	private static final long serialVersionUID = -7887717628165506L;

	@Getter
	@Setter
	@Column(name = "created_at")
	private Date createdAt;

	@Getter
	@Setter
	@Column(name = "updated_at")
	private Date updatedAt;

	@Getter
	@Setter
	@Column(name = "deleted_at")
	private Date deletedAt;

	@Getter
	@Setter
	@Column(name = "active")
	private boolean active;
}
