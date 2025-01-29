package com.example.authsystem.service;

import com.example.authsystem.entity.Role;
import com.example.authsystem.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Optional<Role> getRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}