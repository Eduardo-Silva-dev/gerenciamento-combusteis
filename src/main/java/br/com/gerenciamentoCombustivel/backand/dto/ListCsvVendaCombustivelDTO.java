package br.com.gerenciamentoCombustivel.backand.dto;

public class ListCsvVendaCombustivelDTO {
	
	private String regiao;
	
	private String estado;
	
	private String municipio;
	
	private String revenda;
	
	private String cnpj;
	
	private String nomeDaRua;
	
	private String numeroRua;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	private String produto;
	
	private String dataDaColeta;
	
	private String valorDeVenda;
	
	private String valordeCompra;
	
	private String unidadeDeMedida;
	
	private String bandeira;

	public ListCsvVendaCombustivelDTO(String regiao, String estado, String municipio, String revenda, String cnpj,
			String nomeDaRua, String numeroRua, String complemento, String bairro, String cep, String produto,
			String dataDaColeta, String valorDeVenda, String valordeCompra, String unidadeDeMedida, String bandeira) {
		super();
		this.regiao = regiao;
		this.estado = estado;
		this.municipio = municipio;
		this.revenda = revenda;
		this.cnpj = cnpj;
		this.nomeDaRua = nomeDaRua;
		this.numeroRua = numeroRua;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.produto = produto;
		this.dataDaColeta = dataDaColeta;
		this.valorDeVenda = valorDeVenda;
		this.valordeCompra = valordeCompra;
		this.unidadeDeMedida = unidadeDeMedida;
		this.bandeira = bandeira;
	}

	public ListCsvVendaCombustivelDTO() {
		super();
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getRevenda() {
		return revenda;
	}

	public void setRevenda(String revenda) {
		this.revenda = revenda;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeDaRua() {
		return nomeDaRua;
	}

	public void setNomeDaRua(String nomeDaRua) {
		this.nomeDaRua = nomeDaRua;
	}

	public String getNumeroRua() {
		return numeroRua;
	}

	public void setNumeroRua(String numeroRua) {
		this.numeroRua = numeroRua;
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

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDataDaColeta() {
		return dataDaColeta;
	}

	public void setDataDaColeta(String dataDaColeta) {
		this.dataDaColeta = dataDaColeta;
	}

	public String getValorDeVenda() {
		return valorDeVenda;
	}

	public void setValorDeVenda(String valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}

	public String getValordeCompra() {
		return valordeCompra;
	}

	public void setValordeCompra(String valordeCompra) {
		this.valordeCompra = valordeCompra;
	}

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
}
