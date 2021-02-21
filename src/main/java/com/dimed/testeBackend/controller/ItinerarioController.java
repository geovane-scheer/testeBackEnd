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
import org.springframework.web.bind.annotation.RestController;

import com.dimed.testeBackend.model.Itinerario;
import com.dimed.testeBackend.service.ItinerarioService;

@RestController
@RequestMapping("/itinerarios")
public class ItinerarioController {
	
	@Autowired
	private ItinerarioService itinerarioService;

	@GetMapping(value = "/integrar")
	public String integrar() {
		return itinerarioService.integrarItinerarios();
	}
	
	@GetMapping(value = "/all")
    public List<Itinerario> getAll() {
        return itinerarioService.findAll();
    }
	
	@GetMapping(value = "/{id}")
    public Optional<Itinerario> getById(@PathVariable("id") String id) {
        return itinerarioService.findOne(id);
    }
	
	@PostMapping(value = "/")
	public ResponseEntity<Itinerario> saveOrUpdate(@RequestBody Itinerario itinerario) {
		Itinerario it = itinerarioService.saveOrUpdate(itinerario);
		return new ResponseEntity<Itinerario>(it, HttpStatus.OK);
	}
	
	@GetMapping(value = "/byLinha/{idLinha}")
    public List<Itinerario> getByLinha(@PathVariable("idLinha") String idLinha) {
		return itinerarioService.findByIdLinha(idLinha);
    }
	
	@DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deletaItinerarioById(@PathVariable String id) {
    	Optional<Itinerario> it = itinerarioService.findOne(id);
    	if(!it.isEmpty()) {
    		itinerarioService.delete(id);
    		return new ResponseEntity<String>("Itinerário com id: " + id + " deletada com sucesso!",HttpStatus.OK);
    	}else {
    		return new ResponseEntity<String>("Itinerário com id: " + id + " NÃO foi encontrada!", HttpStatus.NOT_FOUND);
    	}
    }
	
	@DeleteMapping(value = "/deleteAll")
    public ResponseEntity<String> deleteAll() {
		itinerarioService.deleteAll();
		return new ResponseEntity<String>("TODOS itinerários deletados com sucesso!", HttpStatus.OK);
    }
	
}
