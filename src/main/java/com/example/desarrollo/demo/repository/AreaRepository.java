package com.example.desarrollo.demo.repository;

import java.util.List;

import com.example.desarrollo.demo.hospital.Area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long>, JpaSpecificationExecutor<Area>{

    List<Area> findByNombreesp (String nombreesp);

    List<Area> findByTipoesp(String tipoesp);
    
}
