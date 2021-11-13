package br.com.gerenciamentoCombustivel.backand.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "revenda")@SqlResultSetMappings({
	@SqlResultSetMapping(
		       name="ListAllDadosRevendaDto",
		       classes={
		          @ConstructorResult(
		               targetClass= br.com.gerenciamentoCombustivel.backand.dto.ListAllDadosRevendaDto.class,
		                 columns={
		                		 @ColumnResult(name="cnpj",type=String.class),
		                		 @ColumnResult(name="nomeFantasia",type=String.class),
		                		 @ColumnResult(name="bandeira",type=String.class),
		                		 @ColumnResult(name="produto",type=String.class),
		                		 @ColumnResult(name="dataColeta",type=String.class),
		                		 @ColumnResult(name="valorCompra",type=String.class),
		                		 @ColumnResult(name="valorVenda",type=String.class),
		                		 @ColumnResult(name="medidaCombustivel",type=String.class),
		                		 @ColumnResult(name="logradouro",type=String.class),
		                		 @ColumnResult(name="numero",type=String.class),
		                		 @ColumnResult(name="complemento",type=String.class),
		                		 @ColumnResult(name="bairro",type=String.class),
		                		 @ColumnResult(name="cep",type=String.class),
		                		 @ColumnResult(name="municipio",type=String.class),
		                		 @ColumnResult(name="uf",type=String.class),
		                		 @ColumnResult(name="regiao",type=String.class)
		                    }
		          )}),
})
@NamedNativeQueries({
		})
public class Revenda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    protected long id;  
	
	@NotEmpty
	@Column(name = "data_coleta")
    private Date dataColeta;
	
	@Column(name = "valor_venda")
    private Float valorVenda;
	
	@Column(name = "valor_compra")
    private Float valorCompra;
	
	@NotEmpty
	@OneToOne
	@JoinColumn(name = "produto_id")
    private Produto produto;
	
	@NotEmpty
	@OneToOne
	@JoinColumn(name = "bandeira_id")
    private Bandeira bandeira;
	
	@NotEmpty
	@OneToOne
	@JoinColumn(name = "endereco_id")
    private Endereco endereco;
	
	@NotEmpty
	@OneToOne
	@JoinColumn(name = "empresa_id")
    private Empresa empresa;

	public Revenda(@NotEmpty Date dataColeta, Float valorVenda, Float valorCompra,
			@NotEmpty Produto produto, @NotEmpty Bandeira bandeira,
			@NotEmpty Endereco endereco, @NotEmpty Empresa empresa) {
		super();
		this.dataColeta = dataColeta;
		this.valorVenda = valorVenda;
		this.valorCompra = valorCompra;
		this.produto = produto;
		this.bandeira = bandeira;
		this.endereco = endereco;
		this.empresa = empresa;
	}
	
	 public static class Builder {

		    private Date dataColeta;

		    private Float valorVenda;

		    private Float valorCompra;

		    private Produto produto;

		    private Bandeira bandeira;

		    private Endereco endereco;

		    private Empresa empresa;

	        public Builder  dataColeta(Date dataColeta) {
	            this.dataColeta = dataColeta;
	            return this;
	        }

	        public Builder  valorVenda(Float valorVenda) {
	            this.valorVenda = valorVenda;
	            return this;
	        }

	        public Builder  valorCompra(Float valorCompra) {
	            this.valorCompra = valorCompra;
	            return this;
	        }

	        public Builder  produto(Produto produto) {
	            this.produto = produto;
	            return this;
	        }

	        public Builder  bandeira(Bandeira bandeira) {
	            this.bandeira = bandeira;
	            return this;
	        }

	        public Builder  endereco(Endereco endereco) {
	            this.endereco = endereco;
	            return this;
	        }

	        public Builder  empresa(Empresa empresa) {
	            this.empresa = empresa;
	            return this;
	        }

	        public Revenda build() {
	        	return new Revenda(dataColeta, valorVenda, valorCompra, produto, bandeira, endereco, empresa);
	        }
	    }

	public Revenda() {
		super();
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public Date getData_coleta() {
		return dataColeta;
	}

	public void setData_coleta(Date data_coleta) {
		this.dataColeta = data_coleta;
	}

	public Float getValor_venda() {
		return valorVenda;
	}

	public void setValor_venda(Float valor_venda) {
		this.valorVenda = valor_venda;
	}

	public Float getValor_compra() {
		return valorCompra;
	}

	public void setValor_compra(Float valor_compra) {
		this.valorCompra = valor_compra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public long getId() {
		return id;
	}	
}	