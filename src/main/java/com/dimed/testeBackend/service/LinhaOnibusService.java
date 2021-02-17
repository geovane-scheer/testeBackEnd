package com.dimed.testeBackend.service;

import java.util.List;

import com.dimed.testeBackend.model.LinhaOnibus;

public interface LinhaOnibusService {
	
	List<LinhaOnibus> findAll();
	
	void save(LinhaOnibus linhaOnibus);

	String integrarLinhasOnibus();

	List<LinhaOnibus> findByNomeIgnoreCase(String nome);

}
