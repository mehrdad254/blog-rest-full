package com.mhr.blog.modules.roles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhr.blog.modules.roles.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository <Roles,Long> {

	
}
