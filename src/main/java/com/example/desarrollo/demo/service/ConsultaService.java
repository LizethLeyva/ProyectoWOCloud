package com.example.desarrollo.demo.service;

import java.util.List;

import com.example.desarrollo.demo.entity.ConsultaDto;
import com.example.desarrollo.demo.hospital.Consulta;

import org.springframework.stereotype.Service;

@Service
public interface ConsultaService {

    List<Consulta> findConsultasByEstadoAndTipocons(Boolean estado, String tipocons);

     //public List<ConsultaDto> listaConsulta();

	List<Consulta> listaConsulta();

    List<Consulta> findConsultaByIdcaso(Long idcaso);

    public Consulta findByIdcaso(Long idcaso);

    public Consulta save(Consulta consulta);

    //List<Consulta> savee(Long idcaso);

    public void delete(Long idcaso);

    public boolean existsById(Long idcaso);


}
