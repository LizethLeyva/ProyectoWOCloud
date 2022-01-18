package com.example.desarrollo.demo.repository;

import com.example.desarrollo.demo.hospital.MedicoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoUserRepository extends JpaRepository<MedicoUser, Long> {

    MedicoUser findByUsuario(String usuario);
}
