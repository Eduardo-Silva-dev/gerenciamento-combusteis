package br.com.gerenciamentoCombustivel.backand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamentoCombustivel.backand.dto.ListSelectDto.ListSelect;
import br.com.gerenciamentoCombustivel.backand.service.BandeiraService;

@RestController
@RequestMapping(value="/bandeira") 
public class BandeiraController {
	
	@Autowired
	private BandeiraService bandeiraService;
	
	@GetMapping
	public ResponseEntity<List<ListSelect>> getAllBandeira(){
		return ResponseEntity.ok().body(bandeiraService.getAllBandeira());
	}
	
}