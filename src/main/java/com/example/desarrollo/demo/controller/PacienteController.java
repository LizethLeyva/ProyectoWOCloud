package com.example.desarrollo.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PacienteController {

    @Secured("ROLE_ADMIN")
    @PostMapping("crearpac")
    public String crearpaciente() {
        return "hola";
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("eliminarpac")
    public String eliminarpaciente() {
        return "hola";
    }

    @Secured({ "ROLE_ADMIN", "ROLE_CUSTOMER" })
    @PutMapping("editarpac")
    public String editarpaciente() {
        return "hola";
    }

    @Secured("ROLE_VIEWER")
    @GetMapping("pacientes")
    public String pacientes() {
        return "hola"; 
    }

    @Secured("ROLE_VIEWER")
    @GetMapping(value="medicos/{id}")
    public String medicosById(@PathVariable("id") Long id) {
        return "hola";
    }
}
