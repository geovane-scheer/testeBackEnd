package com.dimed.testeBackend.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dimed.testeBackend.model.LinhaOnibus;

public interface LinhaOnibusRepository extends MongoRepository<LinhaOnibus, String>{

	List<LinhaOnibus> findByNomeIgnoreCase(String nome);

}
