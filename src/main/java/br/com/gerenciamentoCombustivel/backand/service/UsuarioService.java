package br.com.gerenciamentoCombustivel.backand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoCombustivel.backand.entity.Usuario;
import br.com.gerenciamentoCombustivel.backand.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Page<Usuario> listAllUsuario(Pageable pageable){
		return usuarioRepository.findAll(pageable);
	}
	
	public Usuario listUsuarioById(Long idUsuario) {
		return usuarioRepository.findByIdUsuario(idUsuario);
	}
	
	public Usuario insert(Usuario usuario) {
		Usuario user = usuarioExistir(usuario);
		if(user == null) {
			return this.save(user);
		}
		return null;
	}
	
	public void removerUsuario(Long idUsuario) {
		Usuario user = listUsuarioById(idUsuario);
		if(user != null) {
			usuarioRepository.deleteById(idUsuario);
		}
	}
	
	public Usuario update(Usuario usuario) {
		Usuario user = listUsuarioById(usuario.getId());
		if(user != null) {
			return this.save(user);
		}
		return null;
	}
	
	private Usuario usuarioExistir(Usuario usuario) {
		return usuarioRepository.findByUsuarioNomeCargo(usuario.getNome(), usuario.getCargo());
	}
	
	private Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}