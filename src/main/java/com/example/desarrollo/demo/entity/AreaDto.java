package com.example.desarrollo.demo.entity;

public class AreaDto {

    private Long id;
    private String nombreesp;
    private String tipoesp;

    //public MedicoDto medico;

    public AreaDto() {

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

    // public MedicoDto getMedico() {
    //     return medico;
    // }

    // public void setMedico(MedicoDto medico) {
    //     this.medico = medico;
    // }

    

    // public List<MedicoDto> getMedicos() {
    //     return medicos;
    // }

    // public void setMedicos(List<MedicoDto> medicos) {
    //     this.medicos = medicos;
    // }

}
