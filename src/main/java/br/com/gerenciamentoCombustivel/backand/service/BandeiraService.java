package br.com.gerenciamentoCombustivel.backand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoCombustivel.backand.dto.ListSelectDto.ListSelect;
import br.com.gerenciamentoCombustivel.backand.entity.Bandeira;
import br.com.gerenciamentoCombustivel.backand.repository.BandeiraRepository;

@Service
public class BandeiraService {

	@Autowired
	private BandeiraRepository bandeiraRepository;
	
	public List<ListSelect> getAllBandeira(){
		return bandeiraRepository.findBandeira();
	}
	
	public Bandeira salvarBandeira (Bandeira bandeira) {
		Bandeira bandeiraResposta = bandeiraRepository.findByBandeira(bandeira.getBandeira());
		if(bandeiraResposta == null) {
			bandeiraResposta = bandeiraRepository.save(bandeira);
		}
		return bandeiraResposta;
	}
}
