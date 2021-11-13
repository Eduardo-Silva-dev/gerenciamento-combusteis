package br.com.gerenciamentoCombustivel.backand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoCombustivel.backand.dto.ListMediaPrecoPorMunicipio;
import br.com.gerenciamentoCombustivel.backand.dto.ListMediaPrecoVendaECompra;
import br.com.gerenciamentoCombustivel.backand.entity.Produto;
import br.com.gerenciamentoCombustivel.backand.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvarProduto (Produto produto) {
		Produto produtoResposta = produtoRepository.findByProduto(produto.getProduto());
		if(produtoResposta == null) {
			produtoResposta = produtoRepository.save(produto);
		}
		return produtoResposta;
	}

	public List<ListMediaPrecoPorMunicipio> mediaPrecoByMunicipio(Long idMunicipio) {
		return produtoRepository.mediaPrecoByMunicipio(idMunicipio);
	}

	public List<ListMediaPrecoVendaECompra> mediaCompraMediaVendaMunicipio(Long idMunicipio) {
		return produtoRepository.mediaCompraMediaVendaMunicipio(idMunicipio);
	}

	public List<ListMediaPrecoVendaECompra> mediaCompraMediaVendaBandeira(Long idBandeira) {
		return produtoRepository.mediaCompraMediaVendaBandeira(idBandeira);
	}
}
