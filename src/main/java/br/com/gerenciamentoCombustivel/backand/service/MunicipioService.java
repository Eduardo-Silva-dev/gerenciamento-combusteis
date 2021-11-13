package br.com.gerenciamentoCombustivel.backand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoCombustivel.backand.dto.ListSelectDto.ListSelect;
import br.com.gerenciamentoCombustivel.backand.entity.Municipio;
import br.com.gerenciamentoCombustivel.backand.repository.MunicipioRepository;

@Service
public class MunicipioService {

	@Autowired
	private MunicipioRepository municipioRepository;
	
	public List<ListSelect> getAllMunicipio(){
		return municipioRepository.getAllMunicipio();
	}
	
	public Municipio salvarMunicipio (Municipio municipio) {
		Municipio municipioResposta = municipioRepository.findByMunicipio(municipio.getMunicipio());
		if(municipioResposta == null) {
			municipioResposta = municipioRepository.save(municipio);
		}
		return municipioResposta;
	}
}
