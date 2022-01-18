package com.example.desarrollo.demo.entity;

import java.util.Date;

public class EpsDto {

    private Long id;
    private Boolean estado;
    private Date fechafil;
    private String tipo;

    public EpsDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechafil() {
        return fechafil;
    }

    public void setFechafil(Date fechafil) {
        this.fechafil = fechafil;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // public PacienteDto getPaciente() {
    //     return paciente;
    // }

    // public void setPaciente(PacienteDto paciente) {
    //     this.paciente = paciente;
    // }

}
