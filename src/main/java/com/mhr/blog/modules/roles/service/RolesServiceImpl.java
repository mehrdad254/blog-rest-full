package com.mhr.blog.modules.roles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mhr.blog.modules.roles.entity.Roles;
import com.mhr.blog.modules.roles.repository.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService {
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public Roles Save(Roles roles) {
		return this.rolesRepository.save(roles);
	}
	
	@Override
	public List<Roles> findAll(){
		return this.rolesRepository.findAll();
	}

	@Override
	public Roles findById(long RoleId) {
		return this.rolesRepository.findById(RoleId).orElse(null);
	}
	
	@Override
	public void deleteOne(long RoleId) {
		this.rolesRepository.deleteById(RoleId);
	}

	@Override
	public void deleteAll() {
		this.rolesRepository.deleteAll();
	}
	
}
