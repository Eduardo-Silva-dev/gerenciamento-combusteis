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

import br.com.gerenciamentoCombustivel.backand.dto.UsuarioDto;
import br.com.gerenciamentoCombustivel.backand.entity.Usuario;
import br.com.gerenciamentoCombustivel.backand.service.UsuarioService;

@RestController
@RequestMapping(value="/usuario") 
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<Page<Usuario>> listAll(Pageable pageable){
		return ResponseEntity.ok().body(usuarioService.listAllUsuario(pageable));
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> listUsuarioByI(@PathVariable Long idUsuario){
		return ResponseEntity.ok().body(usuarioService.listUsuarioById(idUsuario));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDto usuarioDto){
		Usuario obj = usuarioService.insert(new Usuario(usuarioDto.getNome(), usuarioDto.getCargo()));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping()
	public ResponseEntity<Void> update(@RequestBody Usuario usuario){
		Usuario obj = usuarioService.update(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<Void> removerUsuario(@PathVariable Long idUsuario){
		usuarioService.removerUsuario(idUsuario);
		return ResponseEntity.noContent().build();
	}
	
}