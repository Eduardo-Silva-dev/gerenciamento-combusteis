package br.com.gerenciamentoCombustivel.backand.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentoCombustivel.backand.dto.ListSelectDto.ListSelect;
import br.com.gerenciamentoCombustivel.backand.entity.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long>{

	@Query(value = "select id, nome_fantasia as name from empresa", nativeQuery = true)
	List<ListSelect> getAllEmpresa();

	@Query("select u from Empresa u where u.cnpj = :cnpj")
	Empresa findEmpresaByCnpj(@Param("cnpj") String cnpj);
	
}