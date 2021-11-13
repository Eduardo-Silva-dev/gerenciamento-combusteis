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
@Table(name = "estado")
public class Uf implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    protected long id;  
	
	@NotEmpty
	@Column(name = "uf")
    private String uf;
	
	@NotEmpty
	@OneToOne
	@JoinColumn(name = "regiao_id")
    private Regiao regiao;

	public Uf(@NotEmpty String uf, @NotEmpty Regiao regiao) {
		super();
		this.uf = uf;
		this.regiao = regiao;
	}

	public Uf() {
		super();
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public long getId() {
		return id;
	}
}
