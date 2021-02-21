package com.dimed.testeBackend.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dimed.testeBackend.model.Itinerario;

public interface ItinerarioRepository extends MongoRepository<Itinerario, String>{

	List<Itinerario> findByIdlinha(String idLinha);

	List<Itinerario> findByIdlinhaOrderByIdlinhaDesc(String idLinha);

}
