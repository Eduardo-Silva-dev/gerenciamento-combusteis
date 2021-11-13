package br.com.gerenciamentoCombustivel.backand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamentoCombustivel.backand.dto.ListSelectDto.ListSelect;
import br.com.gerenciamentoCombustivel.backand.service.RegiaoService;

@RestController
@RequestMapping(value="/regiao") 
public class RegiaoController {
	
	@Autowired
	private RegiaoService regiaoService;
	
	@GetMapping
	public ResponseEntity<List<ListSelect>> getAllRegiao(){
		return ResponseEntity.ok().body(regiaoService.getAllRegiao());
	}
	
}