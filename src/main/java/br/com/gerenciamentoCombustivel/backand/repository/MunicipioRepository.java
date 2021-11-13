package br.com.gerenciamentoCombustivel.backand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentoCombustivel.backand.dto.ListSelectDto.ListSelect;
import br.com.gerenciamentoCombustivel.backand.entity.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>{

	@Query(value = "select id, municipio as name from municipio", nativeQuery = true)
	List<ListSelect> getAllMunicipio();
	
	@Query("select m from Municipio m where m.municipio = :municipio")
	Municipio findByMunicipio(@Param("municipio") String municipio);

}
