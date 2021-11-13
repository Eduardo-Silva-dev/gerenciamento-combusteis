package br.com.gerenciamentoCombustivel.backand.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentoCombustivel.backand.dto.ListMediaPrecoPorMunicipio;
import br.com.gerenciamentoCombustivel.backand.dto.ListMediaPrecoVendaECompra;
import br.com.gerenciamentoCombustivel.backand.entity.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	@Query(name = "Produto.mediaPrecoByMunicipio", nativeQuery = true)
	List<ListMediaPrecoPorMunicipio> mediaPrecoByMunicipio(@Param("municipio") Long idMunicipio);
	
	@Query(name = "Produto.mediaCompraMediaVendaMunicipio", nativeQuery = true)
	List<ListMediaPrecoVendaECompra> mediaCompraMediaVendaMunicipio(@Param("municipio") Long idMunicipio);
	
	@Query(name = "Produto.mediaCompraMediaVendaBandeira", nativeQuery = true)
	List<ListMediaPrecoVendaECompra> mediaCompraMediaVendaBandeira(@Param("bandeira") Long idBandeira);

	@Query("select u from Produto u where u.produto = :produto")
	Produto findByProduto(@Param("produto") String produto);

}
