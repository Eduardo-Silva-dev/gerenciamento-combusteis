package br.com.gerenciamentoCombustivel.backand.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gerenciamentoCombustivel.backand.dto.ListAllDadosRevendaDto.ListAllDadosRevenda;
import br.com.gerenciamentoCombustivel.backand.entity.Revenda;
import br.com.gerenciamentoCombustivel.backand.service.RevendaService;

@RestController
@RequestMapping(value="/revenda") 
public class RevenaController {
	
	@Autowired
	private RevendaService revendaService;
	
	@GetMapping
	public ResponseEntity<Page<Revenda>> getAllRevenda(Pageable pageable){
		return ResponseEntity.ok().body(revendaService.getAll(pageable));
	}
	
	@GetMapping("/{idRevenda}")
	public ResponseEntity<Revenda> getRevendaById(@PathVariable Long idRevenda){
		return ResponseEntity.ok().body(revendaService.getRevendaById(idRevenda));
	}
	
	@GetMapping("/sigla/{sigla}")
	public ResponseEntity<Page<ListAllDadosRevenda>> getRevendaBySigla(@PathVariable String sigla,Pageable pageable){
		return ResponseEntity.ok().body(revendaService.getRevendaBySigla(sigla,pageable));
	}
	
	@GetMapping("/distribuidora/{distribuidora}")
	public ResponseEntity<Page<ListAllDadosRevenda>> getRevendaByDistribuidora(@PathVariable String distribuidora,Pageable pageable){
		return ResponseEntity.ok().body(revendaService.getRevendaByDistribuidora(distribuidora,pageable));
	}
	
	@GetMapping("/dataColeta/{dataColeta}")
	public ResponseEntity<Page<Revenda>> getRevendaByDataColeta(@PathVariable String dataColeta,Pageable pageable){
		return ResponseEntity.ok().body(revendaService.getRevendaByDataColeta(dataColeta,pageable));
	}
	
	@PostMapping
	public ResponseEntity<Void> insertRevenda(@Valid @RequestBody Revenda revenda){
		Revenda obj = revendaService.insert(revenda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping()
	public ResponseEntity<Void> updateRevenda(@RequestBody Revenda revenda){
		Revenda obj = revendaService.update(revenda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{idRevenda}")
	public ResponseEntity<Void> removerRevenda(@PathVariable Long idRevenda){
		revendaService.removerRevenda(idRevenda);
		return ResponseEntity.noContent().build();
	}

}