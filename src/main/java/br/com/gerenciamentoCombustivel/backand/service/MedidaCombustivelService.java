package br.com.gerenciamentoCombustivel.backand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoCombustivel.backand.entity.MedidaCombustivel;
import br.com.gerenciamentoCombustivel.backand.repository.MedidaCombustivelRepository;

@Service
public class MedidaCombustivelService {

	@Autowired
	private MedidaCombustivelRepository medidaCombustivelRepository;
	
	public MedidaCombustivel salvarMedidaCombustivel (MedidaCombustivel medidaCombustivel) {
		MedidaCombustivel medidaCombustivelResposta = medidaCombustivelRepository.findByMedidaCombustivel(medidaCombustivel.getMedidaCombustivel());
		if(medidaCombustivelResposta == null) {
			medidaCombustivelResposta = medidaCombustivelRepository.save(medidaCombustivel);
		}
		return medidaCombustivelResposta;
	}
}
