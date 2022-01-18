package com.example.desarrollo.demo.service.Implements;

import java.util.List;

import com.example.desarrollo.demo.hospital.Area;
import com.example.desarrollo.demo.repository.AreaRepository;
import com.example.desarrollo.demo.service.AreaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaRepository areaRepository;


	public AreaServiceImpl(AreaRepository areaRepository) {
		this.areaRepository = areaRepository;
	}

	@Override
	public List<Area> listaArea() {
		return areaRepository.findAll();
	}

	@Override
	public Area findById(Long id) {
		return areaRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		areaRepository.deleteById(id);

	}

	@Override
	public boolean existsById(Long id) {
		return areaRepository.existsById(id);
	}

	@Override
	public Area save(Area area) {
		return areaRepository.save(area);
	}

}
