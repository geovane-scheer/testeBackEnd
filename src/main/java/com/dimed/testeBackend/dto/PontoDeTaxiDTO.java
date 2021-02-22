package com.dimed.testeBackend.dto;

public class PontoDeTaxiDTO {
	
	private String nomeDoPonto;
	private String latitude;
	private String longitutde;
	private String dataHoraCadastro;
	
	
	public String getNomeDoPonto() {
		return nomeDoPonto;
	}
	public void setNomeDoPonto(String nomeDoPonto) {
		this.nomeDoPonto = nomeDoPonto;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitutde() {
		return longitutde;
	}
	public void setLongitutde(String longitutde) {
		this.longitutde = longitutde;
	}
	public String getDataHoraCadastro() {
		return dataHoraCadastro;
	}
	public void setDataHoraCadastro(String dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}
	

}
