package br.com.gerenciamentoCombustivel.backand.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    protected long id;  
	
	@NotEmpty
	@Column(name = "cnpj")
    private String cnpj;
	
	@NotEmpty
	@Column(name = "nome_fantasia")
    private String nomeFantasia;

	public Empresa(@NotEmpty String cnpj, @NotEmpty String nomeFantasia) {
		super();
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}

	public Empresa() {
		super();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nome_fantasia) {
		this.nomeFantasia = nome_fantasia;
	}

	public long getId() {
		return id;
	}
}
