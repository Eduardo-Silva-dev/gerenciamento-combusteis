package br.com.gerenciamentoCombustivel.backand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoCombustivel.backand.dto.ListSelectDto.ListSelect;
import br.com.gerenciamentoCombustivel.backand.entity.Regiao;
import br.com.gerenciamentoCombustivel.backand.repository.RegiaoRepository;

@Service
public class RegiaoService {

	@Autowired
	private RegiaoRepository regiaoRepository;
	
	public List<ListSelect> getAllRegiao(){
		return regiaoRepository.getAllRegiao();
	}
	
	public Regiao salvarRegiao (Regiao regiao) {
		Regiao regiaoResposta = regiaoRepository.findByRegiao(regiao.getRegiao());
		if(regiaoResposta == null) {
			regiaoResposta = regiaoRepository.save(regiao);
		}
		return regiaoResposta;
	}
}
