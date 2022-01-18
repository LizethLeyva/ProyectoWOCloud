package com.example.desarrollo.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.desarrollo.demo.hospital.Medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository <Medico, Long>, JpaSpecificationExecutor<Medico>{

    List<Medico> findByNombreContaining (String nombre);
    
    List<Medico> findByEspecialidad (String especialidad);

    Optional<Medico> findByApellidoAndNombre(String nombre, String apellido);

	Optional<Medico> findByApellidoOrNombre(String nombre, String apellido);

    @Query("SELECT p FROM Medico p WHERE p.nombre LIKE :nombre")
    List<Medico> getMedicosByNombre(String nombre);

    @Query("SELECT u FROM Medico u WHERE u.cedula LIKE :cedula")
    List<Medico> getMedicosByCedula(Long cedula);

}
