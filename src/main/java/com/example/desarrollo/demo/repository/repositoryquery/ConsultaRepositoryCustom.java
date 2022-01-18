package com.example.desarrollo.demo.repository.repositoryquery;


import java.util.List;

import com.example.desarrollo.demo.hospital.Consulta;

import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepositoryCustom {

    List<Consulta> findConsultasByEstadoAndTipocons(Boolean estado, String tipocons);
    
    
}
