package com.example.desarrollo.demo.service;

import java.util.List;

import com.example.desarrollo.demo.hospital.Medico;

import org.springframework.stereotype.Service;

@Service
public interface MedicoService {

    List<Medico> listaMedico();

    public Medico findByIdm(Long idm);

    public Medico save(Medico medico);

    public void delete(Long idm);

    public boolean existsByIdm(Long idm);


}
