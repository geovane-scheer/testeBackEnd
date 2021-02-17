package com.dimed.testeBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dimed.testeBackend.model.LinhaOnibus;
import com.dimed.testeBackend.service.LinhaOnibusService;

@RestController
@RequestMapping("/linhaOnibus")
public class LinhaOnibusController {
	
	@Autowired
	private LinhaOnibusService linhaOnibusService;
	
	@GetMapping(value = "/integrar")
	public String integrar() {
		return linhaOnibusService.integrarLinhasOnibus();
	}
	
	@GetMapping(value = "/buscarPorNome")
	public List<LinhaOnibus> getLinhasOnibusPorNome(@RequestParam(name="nome", required=false) String nome) {
		return linhaOnibusService.findByNomeIgnoreCase(nome);
	}

}	
