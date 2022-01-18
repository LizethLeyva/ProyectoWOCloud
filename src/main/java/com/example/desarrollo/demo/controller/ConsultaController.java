package com.example.desarrollo.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.desarrollo.demo.entity.ConsultaDto;
import com.example.desarrollo.demo.hospital.Consulta;
import com.example.desarrollo.demo.service.ConsultaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.SslStoreProvider;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    private ModelMapper model;

    @Secured({ "ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_VIEWER" })
    @GetMapping("consultas")
    public ResponseEntity<List<ConsultaDto>> listaConsulta() {
        List<Consulta> lista = consultaService.listaConsulta();
        ModelMapper model = new ModelMapper();
        List<ConsultaDto> response = new ArrayList<>();

        for (Consulta consulta : lista) {

            ConsultaDto consultaDto = model.map(consulta, ConsultaDto.class);
            response.add(consultaDto);
        }

        return new ResponseEntity<List<ConsultaDto>>(response, HttpStatus.OK);
    }


    @Secured({ "ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_VIEWER" })
    @GetMapping("detallecons/{idcaso}")
    public ResponseEntity<List<ConsultaDto>> findConsultaByIdcaso(@PathVariable("idcaso") Long idcaso) {
        List<Consulta> lista = consultaService.findConsultaByIdcaso(idcaso);
        ModelMapper model1 = new ModelMapper();
        List<ConsultaDto> response = new ArrayList<>();

        for (Consulta consulta : lista) {

            ConsultaDto consultaDto = model1.map(consulta, ConsultaDto.class);
            response.add(consultaDto);
        }

        return new ResponseEntity<List<ConsultaDto>>(response, HttpStatus.OK);
    }

    // @Secured("ROLE_ADMIN")
    // @PostMapping("crearcons")
    // public ResponseEntity<List<ConsultaDto>> create(@RequestBody Consulta consulta) {

    //     List<Consulta> lista = consultaService.savee(consulta);
    //     ModelMapper model2 = new ModelMapper();
    //     List<ConsultaDto> response = new ArrayList<>();

    //     for (Consulta cons : lista) {

    //         ConsultaDto consultaDto = model2.map(cons, ConsultaDto.class);
    //         response.add(consultaDto);
    //     }

    //     return new ResponseEntity<List<ConsultaDto>>(response, HttpStatus.CREATED);
    // }


    @Secured("ROLE_ADMIN")
    @PostMapping("crearcons")
    public ResponseEntity<?> create(@RequestBody Consulta consulta, BindingResult result) {

        Consulta consultanew = null;
        Map<String, Object> response = new HashMap<>();

        try {
            consultanew = consultaService.save(consulta);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("cliente", consultanew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @Secured({ "ROLE_ADMIN", "ROLE_CUSTOMER" })
    @PutMapping("editarcons/{idcaso}")
    public ResponseEntity<?> editarcons(@RequestBody Consulta consulta, @PathVariable("idcaso") Long idcaso) {

        Map<String, Object> response = new HashMap<>();
        Consulta consultan = consultaService.findByIdcaso(idcaso);
        Consulta consultaup = null;

        try {

            consultan.setIdcaso(consulta.getIdcaso());
            consultan.setTipocons(consulta.getTipocons());
            consultan.setNumcons(consulta.getNumcons());
            consultan.setEstado(consulta.getEstado());
            consultan.setFechacons(consulta.getFechacons());
            consultaup = consultaService.save(consultan);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el cliente en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido actualizado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("eliminarcons/{idcaso}")
    public ResponseEntity<?> eliminarconsulta(@PathVariable Long idcaso) {

        Map<String, Object> response = new HashMap<>();

        try {
            consultaService.delete(idcaso);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el cliente de la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("estados")
    public List<Consulta> listaEstados(@RequestParam (required = false) Boolean estado, @RequestParam (required = false) String tipocons) {
        return consultaService.findConsultasByEstadoAndTipocons(estado, tipocons);
    }

    private ConsultaDto toDTO(Consulta consulta) {
        return model.map(consulta, ConsultaDto.class);
    }

    private Consulta toEntity(ConsultaDto dto) {
        return model.map(dto, Consulta.class);
    }

}