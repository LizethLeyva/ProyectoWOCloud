package com.example.desarrollo.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.desarrollo.demo.hospital.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>, JpaSpecificationExecutor<Paciente>{

    List<Paciente> findByNombreContaining(String nombre);

    List<Paciente> findByEdad(Integer edad);

    Optional<Paciente> findByApellidoAndNombre(String nombre, String apellido);

    Optional<Paciente> findByApellidoOrNombre(String nombre, String apellido);

    List<Paciente> findByEdadLessThan(Integer edad);

    List<Paciente> findByEdadLessThanEqual(Integer edad);

    List<Paciente> findByEdadGreaterThanEqual(Integer edad);

    List<Paciente> findByEdadIsNull();

    List<Paciente> findBySexoTrue();

    List<Paciente> findBySexoFalse();

    @Query("SELECT p FROM Paciente p WHERE p.nombre LIKE :nombre")
    List<Paciente> getPacientesByNombre(String nombre);

    @Query("SELECT u FROM Paciente u WHERE u.cedula LIKE :cedula")
    List<Paciente> getPacientesByCedula(Long cedula);

    @Query("SELECT u FROM Paciente u WHERE u.edad > ?1")
    List<Paciente> findByEdadGreaterThan(Integer edad);

    @Query("select u from Paciente u where u.triage is null")
    List<Paciente> findByTriageNull();

}
