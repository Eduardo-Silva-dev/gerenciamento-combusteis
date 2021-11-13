package br.com.gerenciamentoCombustivel.backand.dto;

public class UsuarioDto {

	private String nome;
	
	private String cargo;

	public UsuarioDto(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
	}

	public UsuarioDto() {
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