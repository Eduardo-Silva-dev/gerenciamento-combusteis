package br.com.gerenciamentoCombustivel.backand.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "endereco")
public class Endereco  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    protected long id;  
	
	@NotEmpty
	@Column(name = "logradouro")
    private String logradouro;
	
	@NotEmpty
	@Column(name = "complemento")
    private String complemento;
	
	@NotEmpty
	@Column(name = "bairro")
    private String bairro;
	
	@NotEmpty
	@Column(name = "cep")
    private String cep;
	
	@NotEmpty
	@Column(name = "numero")
    private String numero;
	
	@NotEmpty
	@OneToOne
	@JoinColumn(name = "municipio_id")
    private Municipio municipio;

	public Endereco(@NotEmpty String logradouro, @NotEmpty String complemento, @NotEmpty String bairro,
			@NotEmpty String cep, @NotNull String numero, @NotEmpty Municipio municipio) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.municipio = municipio;
	}

	public Endereco(@NotEmpty String logradouro, @NotEmpty String complemento, @NotEmpty String bairro,
			@NotEmpty String cep, @NotEmpty String numero) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
	}

	public Endereco() {
		super();
	}
	
	public static class Builder{

	    private String logradouro;

	    private String complemento;

	    private String bairro;

	    private String cep;

	    private String numero;

		public Builder logradouro(String logradouro) {
			this.logradouro = logradouro;
			return this;
		}

		public Builder complemento(String complemento) {
			this.complemento = complemento;
			return this;
		}

		public Builder bairro(String bairro) {
			this.bairro = bairro;
			return this;
		}

		public Builder cep(String cep) {
			this.cep = cep;
			return this;
		}

		public Builder numero(String numero) {
			this.numero = numero;
			return this;
		}
	    
	    public Endereco build() {
	    	return new Endereco(logradouro, complemento, bairro, cep, numero);
	    }
		
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public long getId() {
		return id;
	}
}
