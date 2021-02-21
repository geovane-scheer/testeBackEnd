package com.dimed.testeBackend.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ItinerarioDTO {

	private String idlinha;
	private String nome;
	private String codigo;
	@JsonIgnore
    public Map<String, LatLngDTO> mapItinerario = new HashMap<>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getIdlinha() {
		return idlinha;
	}
	public void setIdlinha(String idlinha) {
		this.idlinha = idlinha;
	}
	
	 @JsonAnyGetter
     public Map<String, LatLngDTO> getItinerario() {
         return this.mapItinerario;
     }

     @JsonAnySetter
     public void setItinerario(String name, LatLngDTO value) {
             mapItinerario.put(name, value);
     }
	
}
