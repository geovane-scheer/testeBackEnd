package com.dimed.testeBackend.service;

import java.util.List;

import com.dimed.testeBackend.dto.PontoDeTaxiDTO;

public interface PontoDeTaxiService {

	List<PontoDeTaxiDTO> getAll();

	List<String> getLinhasDoTXT();

	PontoDeTaxiDTO save(PontoDeTaxiDTO pontoDeTaxi);

}
