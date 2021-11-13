package br.com.gerenciamentoCombustivel.backand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoCombustivel.backand.dto.ListSelectDto.ListSelect;
import br.com.gerenciamentoCombustivel.backand.entity.Empresa;
import br.com.gerenciamentoCombustivel.backand.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<ListSelect> getAllEmpresa(){
		return empresaRepository.getAllEmpresa();
	}
	
	public Empresa getEmpresaByCnpj(String cnpj) {
		Empresa empresa  = new Empresa(cnpj, "");
		return empresaRepository.findEmpresaByCnpj(empresa.getCnpj());
	}
	
	public Empresa salvarEmpresa (Empresa empresa) {
		Empresa empresaResposta = empresaRepository.findEmpresaByCnpj(empresa.getCnpj());
		if(empresaResposta == null) {
			empresaResposta = empresaRepository.save(empresa);
		}
		return empresaResposta;
	}
}
