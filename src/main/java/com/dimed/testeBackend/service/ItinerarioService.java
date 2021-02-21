package com.dimed.testeBackend.service;

import java.util.List;
import java.util.Optional;

import com.dimed.testeBackend.model.Itinerario;

public interface ItinerarioService {

	String integrarItinerarios();

	List<Itinerario> findAll();

	Optional<Itinerario> findOne(String id);

	Itinerario saveOrUpdate(Itinerario itinerario);

	List<Itinerario> findByIdLinha(String idLinha);

	void deleteAll();

	void delete(String id);

}
