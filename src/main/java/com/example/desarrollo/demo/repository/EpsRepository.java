package com.example.desarrollo.demo.repository;

import java.util.Date;
import java.util.List;

import com.example.desarrollo.demo.hospital.Eps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EpsRepository extends JpaRepository<Eps, Long>, JpaSpecificationExecutor<Eps>{

    List<Eps> findByEstado (Boolean estado);

    List<Eps> findByTipo(String tipo);

    List<Eps> findByFechafil(Date fechafil);
    
}
