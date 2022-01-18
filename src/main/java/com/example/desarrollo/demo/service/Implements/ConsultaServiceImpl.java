package com.example.desarrollo.demo.service.Implements;

import java.util.List;

import com.example.desarrollo.demo.hospital.Consulta;
import com.example.desarrollo.demo.repository.ConsultaRepository;
import com.example.desarrollo.demo.repository.repositoryquery.CriteriaQueryRepository;
import com.example.desarrollo.demo.service.ConsultaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private CriteriaQueryRepository queryRepository;

	public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
		this.consultaRepository = consultaRepository;
	}

	@Override
	public List<Consulta> findConsultasByEstadoAndTipocons(Boolean estado, String tipocons) {
		return queryRepository.findConsultasByEstadoAndTipocons(estado,tipocons);
	}

	@Override
	public List<Consulta> listaConsulta() {
		return consultaRepository.findAll();
	}

	@Override
	public List<Consulta> findConsultaByIdcaso(Long idcaso) {
		return consultaRepository.findConsultaByIdcaso(idcaso);
	}

	@Override
	public Consulta findByIdcaso(Long idcaso) {
		return consultaRepository.findByIdcaso(idcaso);
	}

	@Override
	public Consulta save(Consulta consulta) {
		return consultaRepository.save(consulta);

	}

	// @Override
	// public List<Consulta> savee(Long idcaso) {
	// 	return consultaRepository.savee(idcaso);

	// }

	@Override
	public void delete(Long idcaso) {
		consultaRepository.deleteById(idcaso);

	}

	@Override
	public boolean existsById(Long idcaso) {
		return consultaRepository.existsById(idcaso);
	}


}
