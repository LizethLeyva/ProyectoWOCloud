package com.example.desarrollo.demo.entity;

public class PacienteDto {

	private Long idp;
	private Long cedula;
	private String nombre;
	private String apellido;
	private String diagnostico;
	private Integer edad;
	private Integer triage;
	private Boolean sexo;

	// private List
	// ConsultaDto consulta;
	private EpsDto eps;

	public PacienteDto() {

	}

	public Long getIdp() {
		return idp;
	}

	public void setIdp(Long idp) {
		this.idp = idp;
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

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getTriage() {
		return triage;
	}

	public void setTriage(Integer triage) {
		this.triage = triage;
	}

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}

	public EpsDto getEps() {
		return eps;
	}

	public void setEps(EpsDto eps) {
		this.eps = eps;
	}

	// public ConsultaDto getConsulta() {
	// return consulta;
	// }

	// public void setConsulta(ConsultaDto consulta) {
	// this.consulta = consulta;
	// }

}
