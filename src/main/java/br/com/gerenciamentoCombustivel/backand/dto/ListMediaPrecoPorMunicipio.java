package br.com.gerenciamentoCombustivel.backand.dto;

public class ListMediaPrecoPorMunicipio {
	
	private Float mediaPreco;
	
	private String produto;

	private String municipio;

	public ListMediaPrecoPorMunicipio(Float mediaPreco, String produto, String municipio) {
		this.mediaPreco = mediaPreco;
		this.produto = produto;
		this.municipio = municipio;
	}

	public ListMediaPrecoPorMunicipio() {

	}

	public Float getMediaPreco() {
		return mediaPreco;
	}

	public void setMediaPreco(Float mediaPreco) {
		this.mediaPreco = mediaPreco;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}	
}