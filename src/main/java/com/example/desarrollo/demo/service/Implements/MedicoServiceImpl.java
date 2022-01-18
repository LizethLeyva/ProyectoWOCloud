package com.example.desarrollo.demo.service.Implements;

import java.util.List;

import com.example.desarrollo.demo.hospital.Medico;
import com.example.desarrollo.demo.repository.MedicoRepository;
import com.example.desarrollo.demo.repository.repositoryquery.CriteriaQueryRepository;
import com.example.desarrollo.demo.service.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

	//@Autowired
	//private CriteriaQueryRepository queryRepository;

	public MedicoServiceImpl(MedicoRepository medicoRepository) {
		this.medicoRepository = medicoRepository;
	}

	// @Override
	// public List<Consulta> findConsultasByEstadoAndTipocons(Boolean estado, String
	// tipocons) {
	// return queryRepository.findConsultasByEstadoAndTipocons(estado,tipocons);
	// }

	@Override
	public List<Medico> listaMedico() {
		return medicoRepository.findAll();
	}

	@Override
	public Medico findByIdm(Long idm) {
		return medicoRepository.findById(idm).orElse(null);
	}

	@Override
	public Medico save(Medico Medico) {
		return medicoRepository.save(Medico);

	}

	@Override
	public void delete(Long idm) {
		medicoRepository.deleteById(idm);

	}

	@Override
	public boolean existsByIdm(Long idm) {
		return medicoRepository.existsById(idm);
	}

}