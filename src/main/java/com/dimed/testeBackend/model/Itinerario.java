package com.dimed.testeBackend.model;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.dimed.testeBackend.dto.LatLngDTO;

@Document(collection = "itinerarios")
public class Itinerario {
	
	@Id
	private String id;
	private String idlinha;
	private String nome;
	private String codigo;
    public Map<Integer, LatLngDTO> mapItinerario = new TreeMap<>();
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdlinha() {
		return idlinha;
	}
	public void setIdlinha(String idlinha) {
		this.idlinha = idlinha;
	}
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
	public Map<Integer, LatLngDTO> getMapItinerario() {
		return mapItinerario;
	}
	public void setMapItinerario(Map<Integer, LatLngDTO> mapItinerario) {
		this.mapItinerario = mapItinerario;
	}

}
