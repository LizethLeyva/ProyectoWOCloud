package com.example.desarrollo.demo.service.Implements;

import java.util.List;

import com.example.desarrollo.demo.hospital.Paciente;
import com.example.desarrollo.demo.repository.PacienteRepository;
import com.example.desarrollo.demo.repository.repositoryquery.CriteriaQueryRepository;
import com.example.desarrollo.demo.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private CriteriaQueryRepository queryRepository;

	public PacienteServiceImpl(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

	@Override
	public Paciente save(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	// @Override
	// public List<Consulta> findConsultasByEstadoAndTipocons(Boolean estado, String
	// tipocons) {
	// return queryRepository.findConsultasByEstadoAndTipocons(estado, tipocons);
	// }

	@Override
	public List<Paciente> listaPaciente() {
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente findByIdp(Long idp) {
		return pacienteRepository.findById(idp).orElse(null);
	}

	@Override
	public void delete(Long idp) {
		pacienteRepository.deleteById(idp);

	}

	@Override
	public boolean existsByIdp(Long idp) {
		return pacienteRepository.existsById(idp);
	}

}
