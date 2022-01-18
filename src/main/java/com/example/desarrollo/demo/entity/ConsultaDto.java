package com.example.desarrollo.demo.entity;

import java.util.Date;

public class ConsultaDto {

    private Long idcaso;
    private String tipocons;
    private int numcons;
    private Boolean estado;
    private Date fechacons;

    private PacienteDto paciente;
    private MedicoDto medico;

    public ConsultaDto() {

    }

    public Long getIdcaso() {
        return idcaso;
    }

    public void setIdcaso(Long idcaso) {
        this.idcaso = idcaso;
    }

    public String getTipocons() {
        return tipocons;
    }

    public void setTipocons(String tipocons) {
        this.tipocons = tipocons;
    }

    public int getNumcons() {
        return numcons;
    }

    public void setNumcons(int numcons) {
        this.numcons = numcons;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechacons() {
        return fechacons;
    }

    public void setFechacons(Date fechacons) {
        this.fechacons = fechacons;
    }

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    public MedicoDto getMedico() {
        return medico;
    }

    public void setMedico(MedicoDto medico) {
        this.medico = medico;
    }

}
