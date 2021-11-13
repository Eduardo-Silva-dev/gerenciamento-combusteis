package br.com.gerenciamentoCombustivel.backand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoCombustivel.backand.entity.Endereco;
import br.com.gerenciamentoCombustivel.backand.entity.Municipio;
import br.com.gerenciamentoCombustivel.backand.entity.Regiao;
import br.com.gerenciamentoCombustivel.backand.entity.Uf;
import br.com.gerenciamentoCombustivel.backand.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private RegiaoService regiaoService;
	
	@Autowired
	private UfService ufService;	
	
	public Endereco salvarEndereco(Endereco endereco, Municipio municipio, Regiao regiao, Uf uf) {
		Endereco end = enderecoRepository.findByEndereco(endereco.getLogradouro(),endereco.getComplemento(),endereco.getBairro(),endereco.getCep(),endereco.getNumero());
		
		if(end == null) {		
			regiao = regiaoService.salvarRegiao(regiao);
			
			if(uf.getRegiao() == null) {
				uf.setRegiao(regiao);
			}
			uf = ufService.salvarEmpresa(uf);
			
			if(municipio.getUf() == null) {
				municipio.setUf(uf);
			}
			municipio = municipioService.salvarMunicipio(municipio);
			
			if(endereco.getMunicipio() == null) {
				endereco.setMunicipio(municipio);
			}
			
			return this.salvarEndereco(endereco);
		}
		
		return end;
	}
	
	private Endereco salvarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);		
	}
}
