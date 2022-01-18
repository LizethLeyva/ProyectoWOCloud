package com.example.desarrollo.demo.entity;

public class MedicoDto {

    private Long idm;
    private Long cedula;
    private String nombre;
    private String apellido;
    private String especialidad;

    // private List
    // ConsultaDto consulta;

    public AreaDto area;

    public MedicoDto() {

    }

    public Long getIdm() {
        return idm;
    }

    public void setIdm(Long idm) {
        this.idm = idm;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }

    // public ConsultaDto getConsulta() {
    // return consulta;
    // }

    // public void setConsulta(ConsultaDto consulta) {
    // this.consulta = consulta;
    // }

}
