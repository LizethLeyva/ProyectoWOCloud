package com.example.desarrollo.demo.repository;

import com.example.desarrollo.demo.hospital.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role,Long> {

    
    
}
