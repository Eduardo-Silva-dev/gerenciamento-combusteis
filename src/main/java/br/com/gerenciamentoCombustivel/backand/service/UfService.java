package br.com.gerenciamentoCombustivel.backand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoCombustivel.backand.entity.Uf;
import br.com.gerenciamentoCombustivel.backand.repository.UfRepository;

@Service
public class UfService {

	@Autowired
	private UfRepository ufRepository;
	
	public Uf getUfBySigla(String sigla) {
		return ufRepository.findBySigla(sigla);
	}
	
	public Uf salvarEmpresa (Uf uf) {
		Uf ufResposta = ufRepository.findBySigla(uf.getUf());
		if(ufResposta == null) {
			ufResposta = ufRepository.save(uf);
		}
		return ufResposta;
	}
}
