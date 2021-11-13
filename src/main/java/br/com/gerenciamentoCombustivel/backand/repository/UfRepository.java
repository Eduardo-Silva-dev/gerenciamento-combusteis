package br.com.gerenciamentoCombustivel.backand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentoCombustivel.backand.entity.Uf;

@Repository
public interface UfRepository extends JpaRepository<Uf, Long>{
	
	@Query("select u from Uf u where u.uf = :uf")
	Uf findBySigla(@Param("uf") String uf);

}