package com.example.desarrollo.demo.service;

import java.util.List;

import com.example.desarrollo.demo.hospital.Area;

import org.springframework.stereotype.Service;

@Service
public interface AreaService {

    //public List<ConsultaDto> listaConsulta();

	List<Area> listaArea();

    public Area findById(Long id);

    public Area save(Area area);

    public void delete(Long id);

    public boolean existsById(Long id);

}
