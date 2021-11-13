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
@Table(name = "regiao")
public class Regiao  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    protected long id;  
	
	@NotEmpty
	@Column(name = "regiao")
    private String regiao;

	public Regiao(@NotEmpty String regiao) {
		super();
		this.regiao = regiao;
	}

	public Regiao() {
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public long getId() {
		return id;
	}
}
