package com.example.desarrollo.demo.hospital;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreesp;
    private String tipoesp;

    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Medico> medicos;

    public Area() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreesp() {
        return nombreesp;
    }

    public void setNombreesp(String nombreesp) {
        this.nombreesp = nombreesp;
    }

    public String getTipoesp() {
        return tipoesp;
    }

    public void setTipoesp(String tipoesp) {
        this.tipoesp = tipoesp;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

}
