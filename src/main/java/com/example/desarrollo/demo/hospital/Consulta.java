package com.example.desarrollo.demo.hospital;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcaso;

    private String tipocons;
    private int numcons;
    private Boolean estado;

    @Temporal(TemporalType.DATE)
    private Date fechacons;

    // @JoinTable(name="consulta_paciente",joinColumns = @JoinColumn(name =
    // "consulta_idcaso") ,inverseJoinColumns = @JoinColumn(name = "paciente_idp"))
    @ManyToOne()
    private Paciente paciente;

    // @JoinTable(name="consulta_medico",joinColumns = @JoinColumn(name =
    // "consulta_idcaso"),inverseJoinColumns = @JoinColumn(name = "medico_idm"))
    @ManyToOne()
    private Medico medico;

    public Consulta() {

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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}
