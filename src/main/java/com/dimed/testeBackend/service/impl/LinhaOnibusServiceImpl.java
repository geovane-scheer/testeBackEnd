package com.dimed.testeBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dimed.testeBackend.dto.LinhaOnibusDTO;
import com.dimed.testeBackend.model.LinhaOnibus;
import com.dimed.testeBackend.repo.LinhaOnibusRepository;
import com.dimed.testeBackend.service.LinhaOnibusService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LinhaOnibusServiceImpl implements LinhaOnibusService {
	
	@Autowired
	private LinhaOnibusRepository linhaOnibusRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<LinhaOnibus> findAll() {
		return linhaOnibusRepository.findAll();
	}

	@Override
	public void save(LinhaOnibus linhaOnibus) {
		linhaOnibusRepository.save(linhaOnibus);
	}

	@Override
	public String integrarLinhasOnibus() {
		ObjectMapper objectMapper = new ObjectMapper();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<String> response = restTemplate.exchange("http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o", HttpMethod.GET, entity,  String.class);
		
		try {
			List<LinhaOnibusDTO> listaLinhasOnibus = objectMapper.readValue(response.getBody(), new TypeReference<List<LinhaOnibusDTO>>(){});
			for(LinhaOnibusDTO linhaDTO : listaLinhasOnibus) {
				LinhaOnibus linhaOnibus = new LinhaOnibus(linhaDTO.getId(), linhaDTO.getCodigo(), linhaDTO.getNome());
				linhaOnibusRepository.save(linhaOnibus);
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return "Erro na Integração de linhas de ônibus";
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Erro na Integração de linhas de ônibus";
		}
		
		return "Integração de linhas de ônibus finalizada com sucesso";
		
	}

	@Override
	public List<LinhaOnibus> findByNomeIgnoreCase(String nome) {
		return linhaOnibusRepository.findByNomeIgnoreCase(nome);
	}

}
