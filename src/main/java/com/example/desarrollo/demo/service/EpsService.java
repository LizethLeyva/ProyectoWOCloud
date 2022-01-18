package com.example.desarrollo.demo.service;

import java.util.List;

import com.example.desarrollo.demo.hospital.Eps;

import org.springframework.stereotype.Service;

@Service
public interface EpsService {

    //public List<ConsultaDto> listaConsulta();

	List<Eps> listaEps();

    public Eps findById(Long id);

    public Eps save(Eps eps);

    public void delete(Long id);

    public boolean existsById(Long id);

}
