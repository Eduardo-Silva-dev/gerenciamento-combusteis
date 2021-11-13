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
@Table(name = "medida_combustivel")
public class MedidaCombustivel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    protected long id;  
	
	@NotEmpty
	@Column(name = "medida_combustivel")
    private String medidaCombustivel;

	public MedidaCombustivel(@NotEmpty String medidaCombustivel) {
		super();
		this.medidaCombustivel = medidaCombustivel;
	}

	public MedidaCombustivel() {
		super();
	}

	public String getMedidaCombustivel() {
		return medidaCombustivel;
	}

	public void setMedidaCombustivel(String medidaCombustivel) {
		this.medidaCombustivel = medidaCombustivel;
	}

	public long getId() {
		return id;
	}	
}
