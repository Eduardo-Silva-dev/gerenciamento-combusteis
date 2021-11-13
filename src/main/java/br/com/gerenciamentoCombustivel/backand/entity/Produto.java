package br.com.gerenciamentoCombustivel.backand.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "produto")
@SqlResultSetMappings({
	@SqlResultSetMapping(
		       name="ListMediaPrecoPorMunicipio",
		       classes={
		          @ConstructorResult(
		               targetClass= br.com.gerenciamentoCombustivel.backand.dto.ListMediaPrecoPorMunicipio.class,
		                 columns={
		                		 @ColumnResult(name="mediaValor",type=Float.class),
		                		 @ColumnResult(name="p.produto",type=String.class),
		                		 @ColumnResult(name="m.municipio",type=String.class)
		                    }
		          )}),
	@SqlResultSetMapping(
		       name="ListMediaPrecoVendaECompra",
		       classes={
		          @ConstructorResult(
		               targetClass= br.com.gerenciamentoCombustivel.backand.dto.ListMediaPrecoVendaECompra.class,
		                 columns={
		                		 @ColumnResult(name="mediaCompra",type=Float.class),
		                		 @ColumnResult(name="mediaVenda",type=Float.class),
		                		 @ColumnResult(name="p.produto",type=String.class),
		                		 @ColumnResult(name="param",type=String.class)
		                    }
		          )}),
})
@NamedNativeQueries({
			@NamedNativeQuery(name = "Produto.mediaPrecoByMunicipio", 
						  	  query = "SELECT FORMAT(AVG(valor_venda),3) as mediaValor, p.produto ,m.municipio " + 
						  	  		" FROM revenda r " + 
						  	  		" JOIN endereco e ON e.id = r.endereco_id " + 
						  	  		" JOIN municipio m ON m.id = e.municipio_id " + 
						  	  		" JOIN produto p ON p.id = r.produto_id " + 
						  	  		" WHERE m.id = :municipio group by p.id ",
									resultSetMapping = "ListMediaPrecoPorMunicipio"),	
			@NamedNativeQuery(name = "Produto.mediaCompraMediaVendaMunicipio", 
							  query = "SELECT  FORMAT(AVG(valor_venda), 3) AS mediaVenda,FORMAT(AVG(valor_compra), 3) AS mediaCompra, p.produto, m.municipio as param " + 
						  	  		" FROM revenda r " + 
						  	  		" JOIN endereco e ON e.id = r.endereco_id " + 
						  	  		" JOIN municipio m ON m.id = e.municipio_id " + 
						  	  		" JOIN produto p ON p.id = r.produto_id " + 
						  	  		" WHERE m.id = :municipio " +
						  	  		" AND r.valor_compra is not null " + 
						  	  		" AND r.valor_venda is not null " + 
						  	  		" GROUP BY p.id ",
									resultSetMapping = "ListMediaPrecoVendaECompra"),	
			@NamedNativeQuery(name = "Produto.mediaCompraMediaVendaBandeira", 
							  query = "SELECT FORMAT(AVG(r.valor_venda), 3) AS mediaVenda, FORMAT(AVG(r.valor_compra), 3) AS mediaCompra, p.produto, b.bandeira as param " + 
							  		" FROM revenda r " + 
							  		" JOIN bandeira b ON b.id = r.bandeira_id " + 
							  		" JOIN produto p ON p.id = r.produto_id " + 
							  		" WHERE r.id = :bandeira" + 
							  		" AND r.valor_compra IS NOT NULL " + 
							  		" AND r.valor_venda IS NOT NULL " + 
							  		" GROUP BY p.id",
									resultSetMapping = "ListMediaPrecoVendaECompra"),	
		})
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    protected long id;  
	
	@NotEmpty
	@Column(name = "produto")
    private String produto;
	
	@NotEmpty
	@OneToOne
	@JoinColumn(name = "medida_combustivel_id")
    private MedidaCombustivel medidaCombustivel;

	public Produto(@NotEmpty String produto, @NotEmpty MedidaCombustivel medidaCombustivel) {
		super();
		this.produto = produto;
		this.medidaCombustivel = medidaCombustivel;
	}

	public Produto() {
		super();
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public MedidaCombustivel getMedidaCombustivel() {
		return medidaCombustivel;
	}

	public void setMedidaCombustivel(MedidaCombustivel medidaCombustivel) {
		this.medidaCombustivel = medidaCombustivel;
	}


	public long getId() {
		return id;
	}
}
