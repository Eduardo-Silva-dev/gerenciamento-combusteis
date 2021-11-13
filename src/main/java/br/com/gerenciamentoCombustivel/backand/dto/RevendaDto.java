package br.com.gerenciamentoCombustivel.backand.dto;

public class RevendaDto {

	private String nome;
	
	private String cargo;

	public RevendaDto(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
	}

	public RevendaDto() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}