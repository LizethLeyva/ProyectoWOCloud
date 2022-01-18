package com.example.desarrollo.demo.repository;

import java.util.Date;
import java.util.List;

import com.example.desarrollo.demo.hospital.Consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>, JpaSpecificationExecutor<Consulta>{
    
    List<Consulta> findConsultaByIdcaso (Long idcaso);

    List<Consulta> findByFechacons (Date fechacons);

    List<Consulta> findByTipocons (String tipocons);

    List<Consulta> findByEstado(Boolean estado);

	List<Consulta> findByNumconsIsNull();

	List<Consulta> findByEstadoTrue();

	List<Consulta> findByEstadoFalse();

    Consulta findByIdcaso (Long idcaso);

    //List<Consulta> savee(Long idcaso);

    @Query("SELECT p FROM Consulta p WHERE p.fechacons LIKE :fechacons")
    List<Consulta> getConsultasByFechacons(Date fechacons);

    @Query("SELECT u FROM Consulta u WHERE u.tipocons LIKE :tipocons")
    List<Consulta> getConsultasByTipocons(String tipocons);

    @Query("select u from Consulta u where u.numcons is null")
    List<Consulta> findByNumconsNull();
    
}
