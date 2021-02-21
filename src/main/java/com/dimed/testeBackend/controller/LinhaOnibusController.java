package com.dimed.testeBackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dimed.testeBackend.dto.RaioDTO;
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
	
	@PostMapping(value = "/")
	public ResponseEntity<LinhaOnibus> saveOrUpdate(@RequestBody LinhaOnibus linhaOnibus) {
		LinhaOnibus lo = linhaOnibusService.saveOrUpdate(linhaOnibus);
		return new ResponseEntity<LinhaOnibus>(lo, HttpStatus.OK);
	}
	
    @GetMapping(value = "/{id}")
    public Optional<LinhaOnibus> getById(@PathVariable("id") String id) {
        return linhaOnibusService.findOne(id);
    }
    
    @GetMapping(value = "/all")
    public List<LinhaOnibus> getAll() {
        return linhaOnibusService.findAll();
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deletaLinhaOnibusById(@PathVariable String id) {
    	Optional<LinhaOnibus> lo = linhaOnibusService.findOne(id);
    	if(!lo.isEmpty()) {
    		linhaOnibusService.delete(id);
    		return new ResponseEntity<String>("Linha de ônibus com id: " + id + " deletada com sucesso!",HttpStatus.OK);
    	}else {
    		return new ResponseEntity<String>("Linha de ônibus com id: " + id + " NÃO foi encontrada!", HttpStatus.NOT_FOUND);
    	}
    }
    
    @PostMapping(value = "/dentroDoRaio")
	public ResponseEntity<List<LinhaOnibus>> buscarLinhasPorRadio(@RequestBody RaioDTO raioDTO) {
    	List<LinhaOnibus> listaRetorno = linhaOnibusService.buscarLinhasPorRadio(raioDTO);
    	if(!listaRetorno.isEmpty()) {
    		return new ResponseEntity<List<LinhaOnibus>>(listaRetorno,HttpStatus.OK);
    	}else {
    		return new ResponseEntity<List<LinhaOnibus>>(HttpStatus.NOT_FOUND);
    	}
	}
    
    

}	
