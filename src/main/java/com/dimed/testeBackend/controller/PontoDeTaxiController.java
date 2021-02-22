package com.dimed.testeBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dimed.testeBackend.dto.PontoDeTaxiDTO;
import com.dimed.testeBackend.service.PontoDeTaxiService;

@RestController
@RequestMapping("/pontosDeTaxi")
public class PontoDeTaxiController {
	
	@Autowired
	private PontoDeTaxiService pontoDeTaxiService;
	
	@GetMapping(value = "/all")
	public List<PontoDeTaxiDTO> getAll() {
		return pontoDeTaxiService.getAll();
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<PontoDeTaxiDTO> save(@RequestBody PontoDeTaxiDTO pontoDeTaxi) {
		PontoDeTaxiDTO pdt = pontoDeTaxiService.save(pontoDeTaxi);
		return new ResponseEntity<PontoDeTaxiDTO>(pdt, HttpStatus.OK);
	}

}
