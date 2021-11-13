package br.com.gerenciamentoCombustivel.backand.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ListAllDadosRevendaDto {
	
	private String cnpj;
	
	private String nomeFantasia;
	
	private String bandeira;
	
	private String produto;
	
	private String dataColeta;
	
	private String valorCompra;
	
	private String valorVenda;
	
	private String medidaCombustivel;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;

	private String municipio;

	private String estado;
	
	private String regiao;
	
	public ListAllDadosRevendaDto() {
		super();
	}

	public ListAllDadosRevendaDto(String cnpj, String nomeFantasia, String bandeira, String produto, String dataColeta,
			String valorCompra, String valorVenda, String medidaCombustivel, String logradouro, String numero,
			String complemento, String bairro, String cep, String municipio, String estado, String regiao) {
		super();
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.bandeira = bandeira;
		this.produto = produto;
		this.dataColeta = dataColeta;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.medidaCombustivel = medidaCombustivel;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.municipio = municipio;
		this.estado = estado;
		this.regiao = regiao;
	}

	public static interface ListAllDadosRevenda {
		String getCnpj();
		String getNomeFantasia();
		String getBandeira();
		String getProduto();
		String getDataColeta();
		String getValorCompra();
		String getValorVenda();
		String getMedidaCombustivel();
		String getLogradouro();
		String getNumero();
		String getComplemento();
		String getBairro();
		String getCep();
		String getMunicipio();
		String getUf();
		String getRegiao();
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

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public String getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(String dataColeta) {
		this.dataColeta = dataColeta;
	}

	public String getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(String valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(String valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getMedidaCombustivel() {
		return medidaCombustivel;
	}

	public void setMedidaCombustivel(String medidaCombustivel) {
		this.medidaCombustivel = medidaCombustivel;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
}