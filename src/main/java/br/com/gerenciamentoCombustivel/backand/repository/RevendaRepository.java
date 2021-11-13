package br.com.gerenciamentoCombustivel.backand.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentoCombustivel.backand.dto.ListAllDadosRevendaDto.ListAllDadosRevenda;
import br.com.gerenciamentoCombustivel.backand.entity.Revenda;

@Repository
public interface RevendaRepository extends CrudRepository<Revenda, Long>{

	Page<Revenda> findAll(Pageable pageable);

	@Query(value = "select r from Revenda r where r.id = :idRevenda")
	Revenda getRevendaById(@Param("idRevenda") Long idRevenda);
	
	@Query(value = "SELECT "
			+ "r.empresa.cnpj as cnpj, "
			+ "r.empresa.nomeFantasia as nomeFantasia, "
			+ "r.bandeira.bandeira as bandeira, "
			+ "r.produto.produto as produto, "
			+ "r.produto.medidaCombustivel.medidaCombustivel as medidaCombustivel, "
			+ "r.dataColeta as dataColeta, "
			+ "r.valorCompra as valorCompra, "
			+ "r.valorVenda as valorVenda, "
			+ "r.endereco.logradouro as logradouro, "
			+ "r.endereco.complemento as complemento, "
			+ "r.endereco.bairro as bairro, "
			+ "r.endereco.cep as cep, "
			+ "r.endereco.municipio.municipio as municipio, "
			+ "r.endereco.municipio.uf.uf as uf, "
			+ "r.endereco.municipio.uf.regiao.regiao as regiao "
			+ "FROM Revenda r where r.endereco.municipio.uf.uf = :idEstado ")
	Page<ListAllDadosRevenda> getRevendaByUf(@Param("idEstado") String idEstado, Pageable pageable);
	
	@Query(value = "SELECT "
			+ "r.empresa.cnpj as cnpj, "
			+ "r.empresa.nomeFantasia as nomeFantasia, "
			+ "r.bandeira.bandeira as bandeira, "
			+ "r.produto.produto as produto, "
			+ "r.produto.medidaCombustivel.medidaCombustivel as medidaCombustivel, "
			+ "r.dataColeta as dataColeta, "
			+ "r.valorCompra as valorCompra, "
			+ "r.valorVenda as valorVenda, "
			+ "r.endereco.logradouro as logradouro, "
			+ "r.endereco.complemento as complemento, "
			+ "r.endereco.bairro as bairro, "
			+ "r.endereco.cep as cep, "
			+ "r.endereco.municipio.municipio as municipio, "
			+ "r.endereco.municipio.uf.uf as uf, "
			+ "r.endereco.municipio.uf.regiao.regiao as regiao "
			+ "FROM Revenda r where r.empresa.cnpj = :cnpj ")
	Page<ListAllDadosRevenda> getRevendaByCnpj(@Param("cnpj") String cnpj, Pageable pageable);
	
//	@Query(value = "SELECT "
//			+ "r.empresa.cnpj as cnpj, "
//			+ "r.empresa.nomeFantasia as nomeFantasia, "
//			+ "r.bandeira.bandeira as bandeira, "
//			+ "r.produto.produto as produto, "
//			+ "r.produto.medidaCombustivel.medidaCombustivel as medidaCombustivel, "
//			+ "r.dataColeta as dataColeta, "
//			+ "r.valorCompra as valorCompra, "
//			+ "r.valorVenda as valorVenda, "
//			+ "r.endereco.logradouro as logradouro, "
//			+ "r.endereco.complemento as complemento, "
//			+ "r.endereco.bairro as bairro, "
//			+ "r.endereco.cep as cep, "
//			+ "r.endereco.municipio.municipio as municipio, "
//			+ "r.endereco.municipio.uf.uf as uf, "
//			+ "r.endereco.municipio.uf.regiao.regiao as regiao "
//			+ "FROM Revenda r where r.dataColeta = :dataColeta ")
	@Query(value = "select r from Revenda r where r.dataColeta = :dataColeta ")
	Page<Revenda> getRevendaByDataColeta(@Param("dataColeta") Date dataColeta, Pageable pageable);
	
}