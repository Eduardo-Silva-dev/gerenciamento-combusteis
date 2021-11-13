package br.com.gerenciamentoCombustivel.backand.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentoCombustivel.backand.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Page<Usuario> findAll(Pageable pageable);
	
	@Query("select u from Usuario u where u.id = ?1")
	Usuario findByIdUsuario(Long idUsuario);
	
	@Query("select u from Usuario u where u.nome = :nome and u.cargo = :cargo")
	Usuario findByUsuarioNomeCargo(@Param("nome") String nome,@Param("cargo") String cargo);
	
} 