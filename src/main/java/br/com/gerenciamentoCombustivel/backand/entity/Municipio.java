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

@Entity
@Table(name = "municipio")
public class Municipio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    protected long id;  
	
	@NotEmpty
	@Column(name = "municipio")
    private String municipio;
	
	@NotEmpty
	@OneToOne
	@JoinColumn(name = "uf_id")
    private Uf uf;

	public Municipio(@NotEmpty String municipio, @NotEmpty Uf uf) {
		this.municipio = municipio;
		this.uf = uf;
	}

	public Municipio() {
		
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public long getId() {
		return id;
	}
}
