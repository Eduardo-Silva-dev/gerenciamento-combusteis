package br.com.gerenciamentoCombustivel.backand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentoCombustivel.backand.dto.ListSelectDto.ListSelect;
import br.com.gerenciamentoCombustivel.backand.entity.Bandeira;

@Repository
public interface BandeiraRepository extends CrudRepository<Bandeira, Long>{

	@Query(value = "select id, bandeira as name from bandeira", nativeQuery = true)
	List<ListSelect> findBandeira();

	@Query("select u from Bandeira u where u.bandeira = :bandeira")
	Bandeira findByBandeira(@Param("bandeira") String bandeira);
	
}
