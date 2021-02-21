package com.dimed.testeBackend.service;

import java.util.List;
import java.util.Optional;

import com.dimed.testeBackend.dto.RaioDTO;
import com.dimed.testeBackend.model.LinhaOnibus;

public interface LinhaOnibusService {
	
	List<LinhaOnibus> findAll();
	
	void save(LinhaOnibus linhaOnibus);

	String integrarLinhasOnibus();

	List<LinhaOnibus> findByNomeIgnoreCase(String nome);

	LinhaOnibus saveOrUpdate(LinhaOnibus linhaOnibus);

	Optional<LinhaOnibus> findOne(String id);

	void delete(String id);

	List<LinhaOnibus> buscarLinhasPorRadio(RaioDTO raioDTO);

}
