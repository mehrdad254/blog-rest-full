package com.mhr.blog.modules.roles.service;

import java.util.List;

import com.mhr.blog.modules.roles.entity.Roles;

public interface RolesService {

	Roles Save(Roles roles);

	List<Roles> findAll();

	void deleteOne(long RoleId);

	Roles findById(long RoleId);

	void deleteAll();

}
