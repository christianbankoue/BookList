package com.cbankoue.booklist.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbankoue.booklist.entity.Role;
import com.cbankoue.booklist.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	
	public Collection<Role> findAll() {
		return roleRepository.findAll();
	}

	
	public Optional<Role> findById(Long id) {
		return roleRepository.findById(id);
	}
	
	
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

	
	public Role saveOrUpdate(Role role) {
		return roleRepository.saveAndFlush(role);
	}
}
