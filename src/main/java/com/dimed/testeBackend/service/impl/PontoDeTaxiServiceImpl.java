package com.dimed.testeBackend.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dimed.testeBackend.dto.PontoDeTaxiDTO;
import com.dimed.testeBackend.service.PontoDeTaxiService;

@Service
public class PontoDeTaxiServiceImpl implements PontoDeTaxiService{

	@Override
	public List<String> getLinhasDoTXT() {
		Path path = Paths.get("src/main/resources/pontosDeTaxi.txt");
		try {
			List<String> read = Files.readAllLines(path);
			return read;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PontoDeTaxiDTO> getAll() {
		List<PontoDeTaxiDTO> retorno = new ArrayList<PontoDeTaxiDTO>();
		List<String> linhas = getLinhasDoTXT();
		for(String s : linhas) {
			PontoDeTaxiDTO pontoDeTaxi = new PontoDeTaxiDTO();
			String[] split = s.split("#");
			pontoDeTaxi.setNomeDoPonto(split[0]);
			pontoDeTaxi.setLatitude(split[1]);
			pontoDeTaxi.setLongitutde(split[2]);
			pontoDeTaxi.setDataHoraCadastro(split[3]);
			retorno.add(pontoDeTaxi);
		}
		return retorno;
	}

	@Override
	public PontoDeTaxiDTO save(PontoDeTaxiDTO pontoDeTaxi) {
		String linhaPraSalvar = pontoDeTaxi.getNomeDoPonto() + "#" + pontoDeTaxi.getLatitude() + "#" + pontoDeTaxi.getLongitutde() + "#" + pontoDeTaxi.getDataHoraCadastro();
		salvarPonto(linhaPraSalvar);
		return pontoDeTaxi;
	}

	private void salvarPonto(String linhaPraSalvar) {
		try {
		    Files.write(Paths.get("src/main/resources/pontosDeTaxi.txt"), linhaPraSalvar.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		    e.printStackTrace();
		}
	}

}
