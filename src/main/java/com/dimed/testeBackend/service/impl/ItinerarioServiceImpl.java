package com.dimed.testeBackend.service.impl;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dimed.testeBackend.dto.ItinerarioDTO;
import com.dimed.testeBackend.dto.LatLngDTO;
import com.dimed.testeBackend.model.Itinerario;
import com.dimed.testeBackend.model.LinhaOnibus;
import com.dimed.testeBackend.repo.ItinerarioRepository;
import com.dimed.testeBackend.service.ItinerarioService;
import com.dimed.testeBackend.service.LinhaOnibusService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ItinerarioServiceImpl implements ItinerarioService{

	@Autowired
	private LinhaOnibusService linhaOnibusService;
	
	@Autowired
	private ItinerarioRepository itinerarioRepository;
	
	@Override
	public String integrarItinerarios() {
		List<LinhaOnibus> listaLinhaOnibus = linhaOnibusService.findAll();
		listaLinhaOnibus.forEach(linhaOnibus -> {
			try {
				ItinerarioDTO itinerarioDTO = getItinerarioByIdLinha(linhaOnibus.getId());
				Itinerario itinerario = new Itinerario();
				itinerario.setCodigo(itinerarioDTO.getCodigo());
				itinerario.setIdlinha(itinerarioDTO.getIdlinha());
				itinerario.setNome(itinerarioDTO.getNome());
				Map<Integer, LatLngDTO> mapItinerario = new HashMap<>();
				itinerarioDTO.getItinerario().entrySet().forEach(mapDTO -> {
					mapItinerario.put(Integer.parseInt(mapDTO.getKey()), mapDTO.getValue());
				});
				itinerario.setMapItinerario(mapItinerario);
				itinerarioRepository.save(itinerario);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return "integração de itinerários concluída com sucesso";
	}
	
	public ItinerarioDTO getItinerarioByIdLinha(String idLinha) throws Exception{
		ItinerarioDTO dto = new ItinerarioDTO();
		try {
			URL url = new URL("http://www.poatransporte.com.br/php/facades/process.php?a=il&p=" + idLinha);
			ObjectMapper mapper = new ObjectMapper();
			dto = mapper.readValue(url, ItinerarioDTO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<Itinerario> findAll() {
		return itinerarioRepository.findAll();
	}

	@Override
	public Optional<Itinerario> findOne(String id) {
		return itinerarioRepository.findById(id);
	}

	@Override
	public Itinerario saveOrUpdate(Itinerario itinerario) {
		return itinerarioRepository.save(itinerario);
	}

	@Override
	public List<Itinerario> findByIdLinha(String idLinha) {
		return itinerarioRepository.findByIdlinhaOrderByIdlinhaDesc(idLinha);
	}

	@Override
	public void deleteAll() {
		itinerarioRepository.deleteAll();
	}

	@Override
	public void delete(String id) {
		itinerarioRepository.deleteById(id);
	}

}
