package com.example.desarrollo.demo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.desarrollo.demo.entity.MedicoDto;
import com.example.desarrollo.demo.hospital.Medico;
import com.example.desarrollo.demo.service.MedicoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Secured({ "ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_VIEWER" })
    @GetMapping("medicos")
    public ResponseEntity<List<MedicoDto>> listamedicos() {
        List<Medico> medicos = medicoService.listaMedico();
        ModelMapper model = new ModelMapper();
        List<MedicoDto> response = new ArrayList<>();

        for (Medico medico : medicos) {

            MedicoDto medicoDto = model.map(medico, MedicoDto.class);
            response.add(medicoDto);
        }

        return new ResponseEntity<List<MedicoDto>>(response, HttpStatus.OK);
    }

    @Secured({ "ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_VIEWER" })
    @GetMapping("detallemed/{idm}")
    public ResponseEntity<?> MedicoByidm(@PathVariable("idm") Long idm) {

        Medico medico = null;
        Map<String, Object> response = new HashMap<>();
        medico = medicoService.findByIdm(idm);

        if (medico == null) {
            response.put("mensaje",
                    "El medico ID: ".concat(idm.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Medico>(medico, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("crearmed")
    public ResponseEntity<?> create(@RequestBody Medico medico, BindingResult result) {

        Medico mediconew = null;
        Map<String, Object> response = new HashMap<>();

        try {
            mediconew = medicoService.save(medico);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("cliente", mediconew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @Secured({ "ROLE_ADMIN", "ROLE_CUSTOMER" })
    @PutMapping("editarmed/{idm}")
    public ResponseEntity<?> editarcons(@RequestBody Medico medico, @PathVariable("idm") Long idm) {

        Map<String, Object> response = new HashMap<>();
        Medico medicon = medicoService.findByIdm(idm);
        Medico medicoup = null;

        try {

            medicon.setIdm(medico.getIdm());
            medicon.setCedula(medico.getCedula());
            medicon.setNombre(medico.getNombre());
            medicon.setApellido(medico.getApellido());
            medicon.setEspecialidad(medico.getEspecialidad());
            medicoup = medicoService.save(medicon);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

        response.put("mensaje", "El cliente ha sido actualizado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @Secured("ROLE_ADMIN")
    @DeleteMapping("eliminarmed/{idm}")
    public ResponseEntity<?> eliminarconsulta(@PathVariable Long idm) {

        Map<String, Object> response = new HashMap<>();

        try {
            medicoService.delete(idm);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el cliente de la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
