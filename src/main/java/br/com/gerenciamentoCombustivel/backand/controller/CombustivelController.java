package br.com.gerenciamentoCombustivel.backand.controller;

import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gerenciamentoCombustivel.backand.dto.ListMediaPrecoPorMunicipio;
import br.com.gerenciamentoCombustivel.backand.dto.ListMediaPrecoVendaECompra;
import br.com.gerenciamentoCombustivel.backand.service.CombustivelService;
import br.com.gerenciamentoCombustivel.backand.service.ProdutoService;

@RestController
@RequestMapping(value="/combustivel") 
public class CombustivelController {

	@Autowired
	private CombustivelService combustivelService;

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/mediaPrecoPorMunicipio/{idMunicipio}")
	public ResponseEntity<List<ListMediaPrecoPorMunicipio>> mediaPrecoByMunicipio(@PathVariable Long idMunicipio){
		return ResponseEntity.ok().body(produtoService.mediaPrecoByMunicipio(idMunicipio));
	} 

	@GetMapping("/mediaCompraMediaVendaPorMunicipio/{idMunicipio}")
	public ResponseEntity<List<ListMediaPrecoVendaECompra>> mediaCompraMediaVendaMunicipio(@PathVariable Long idMunicipio){
		return ResponseEntity.ok().body(produtoService.mediaCompraMediaVendaMunicipio(idMunicipio));
	} 

	@GetMapping("/mediaCompraMediaVendaPorBandeira/{idBandeira}")
	public ResponseEntity<List<ListMediaPrecoVendaECompra>> mediaCompraMediaVendaBandeira(@PathVariable Long idBandeira){
		return ResponseEntity.ok().body(produtoService.mediaCompraMediaVendaBandeira(idBandeira));
	} 

	@PostMapping("/fileCsv")
	public ResponseEntity<Void> insertTratamentoVideo(@RequestParam("file") MultipartFile file) throws IOException, ParseException{
		combustivelService.converterFileCsv(file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/fileCsv").buildAndExpand().toUri();
		return ResponseEntity.created(uri).build();
	}
}