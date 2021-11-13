package br.com.gerenciamentoCombustivel.backand.dto;

public class ListMediaPrecoVendaECompra {
	
	private Float mediaPrecoCompra;
	
	private Float mediaPrecoVenda;
	
	private String produto;

	private String param;

	public ListMediaPrecoVendaECompra(Float mediaPrecoCompra, Float mediaPrecoVenda, String produto, String param) {
		this.mediaPrecoCompra = mediaPrecoCompra;
		this.mediaPrecoVenda = mediaPrecoVenda;
		this.produto = produto;
		this.param = param;
	}

	public ListMediaPrecoVendaECompra() {

	}

	public Float getMediaPrecoCompra() {
		return mediaPrecoCompra;
	}

	public void setMediaPrecoCompra(Float mediaPrecoCompra) {
		this.mediaPrecoCompra = mediaPrecoCompra;
	}

	public Float getMediaPrecoVenda() {
		return mediaPrecoVenda;
	}

	public void setMediaPrecoVenda(Float mediaPrecoVenda) {
		this.mediaPrecoVenda = mediaPrecoVenda;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getMunicipio() {
		return param;
	}

	public void setMunicipio(String param) {
		this.param = param;
	}
}