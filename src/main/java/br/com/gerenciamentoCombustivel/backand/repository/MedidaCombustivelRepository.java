package br.com.gerenciamentoCombustivel.backand.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentoCombustivel.backand.entity.MedidaCombustivel;

@Repository
public interface MedidaCombustivelRepository extends CrudRepository<MedidaCombustivel, Long>{

	@Query("select u from MedidaCombustivel u where u.medidaCombustivel = :medidaCombustivel")
	MedidaCombustivel findByMedidaCombustivel(@Param("medidaCombustivel") String medidaCombustivel);

}
