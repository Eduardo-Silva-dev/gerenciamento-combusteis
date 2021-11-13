package br.com.gerenciamentoCombustivel.backand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentoCombustivel.backand.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	@Query("select e from Endereco e where e.logradouro = :logradouro AND " + 
			"e.complemento = :complemento AND " + 
			"e.bairro = :bairro AND " + 
			"e.cep = :cep AND " + 
			"e.numero = :numero")
	Endereco findByEndereco(@Param("logradouro") String logradouro, @Param("complemento") String complemento, @Param("bairro") String bairro,
			@Param("cep") String cep, @Param("numero") String numero);

}
