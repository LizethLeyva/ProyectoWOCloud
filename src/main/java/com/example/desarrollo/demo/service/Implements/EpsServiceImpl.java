package com.example.desarrollo.demo.service.Implements;

import java.util.List;

import com.example.desarrollo.demo.hospital.Eps;
import com.example.desarrollo.demo.repository.EpsRepository;
import com.example.desarrollo.demo.service.EpsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpsServiceImpl implements EpsService {

	@Autowired
	private EpsRepository epsRepository;


	public EpsServiceImpl(EpsRepository epsRepository) {
		this.epsRepository = epsRepository;
	}

	@Override
	public List<Eps> listaEps() {
		return epsRepository.findAll();
	}

	@Override
	public Eps findById(Long id) {
		return epsRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		epsRepository.deleteById(id);

	}

	@Override
	public boolean existsById(Long id) {
		return epsRepository.existsById(id);
	}

	@Override
	public Eps save(Eps eps) {
		return epsRepository.save(eps);
	}

}
