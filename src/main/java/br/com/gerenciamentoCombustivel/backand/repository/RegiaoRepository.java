package br.com.gerenciamentoCombustivel.backand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentoCombustivel.backand.dto.ListSelectDto.ListSelect;
import br.com.gerenciamentoCombustivel.backand.entity.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long>{

	@Query(value = "select id, regiao as name from regiao", nativeQuery = true)
	List<ListSelect> getAllRegiao();
	
	@Query("select r from Regiao r where r.regiao = :regiao")
	Regiao findByRegiao(@Param("regiao") String regiao);

}
