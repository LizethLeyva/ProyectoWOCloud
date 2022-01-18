package com.example.desarrollo.demo.service;

import java.util.List;

import com.example.desarrollo.demo.hospital.Paciente;

import org.springframework.stereotype.Service;

@Service
public interface PacienteService {

    //public List<Paciente> findConsultasByEstadoAndTipocons(Boolean estado, String tipocons);

    //public List<ConsultaDto> listaConsulta();

	List<Paciente> listaPaciente();

    public Paciente findByIdp(Long idp);

    public Paciente save(Paciente paciente);

    public void delete(Long idp);

    public boolean existsByIdp(Long idp);
    
}
