package br.com.gerenciamentoCombustivel.backand.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoCombustivel.backand.dto.ListAllDadosRevendaDto.ListAllDadosRevenda;
import br.com.gerenciamentoCombustivel.backand.dto.ListCsvVendaCombustivelDTO;
import br.com.gerenciamentoCombustivel.backand.entity.Bandeira;
import br.com.gerenciamentoCombustivel.backand.entity.Empresa;
import br.com.gerenciamentoCombustivel.backand.entity.Endereco;
import br.com.gerenciamentoCombustivel.backand.entity.MedidaCombustivel;
import br.com.gerenciamentoCombustivel.backand.entity.Municipio;
import br.com.gerenciamentoCombustivel.backand.entity.Produto;
import br.com.gerenciamentoCombustivel.backand.entity.Regiao;
import br.com.gerenciamentoCombustivel.backand.entity.Revenda;
import br.com.gerenciamentoCombustivel.backand.entity.Uf;
import br.com.gerenciamentoCombustivel.backand.repository.RevendaRepository;

@Service
public class RevendaService {

	@Autowired
	private RevendaRepository revendaRepository;
	
	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private BandeiraService bandeiraService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private MedidaCombustivelService medidaCombustivelService;
	
	public Page<Revenda> getAll(Pageable pageable){
		return revendaRepository.findAll(pageable);
	}
	
	public Page<ListAllDadosRevenda> getRevendaBySigla(String sigla,Pageable pageable){
		return revendaRepository.getRevendaByUf(sigla,pageable);
	}
	
	public Page<ListAllDadosRevenda> getRevendaByDistribuidora(String distribuidora,Pageable pageable){
		return revendaRepository.getRevendaByCnpj(distribuidora,pageable);
	}
	
	public Page<Revenda> getRevendaByDataColeta(String data,Pageable pageable){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = formatter.parse(data);
			return revendaRepository.getRevendaByDataColeta(date,pageable);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public Revenda getRevendaById(Long idRevenda){
		return revendaRepository.getRevendaById(idRevenda);
	}
	
	public Revenda insert(Revenda revenda) {
		return this.save(revenda);
	}
	
	public void removerRevenda(Long idUsuario) {
		revendaRepository.deleteById(idUsuario);
	}
	
	public Revenda update(Revenda revenda) {
		return this.save(revenda);
	}
	
	private Revenda save(Revenda revenda) {
		return revendaRepository.save(revenda);
	}

	public void criarRegritroDeRevenda(List<ListCsvVendaCombustivelDTO> listDados) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		int i = 0;
		for (ListCsvVendaCombustivelDTO dados : listDados) {

			Date dataColeta = null;
			try {
				dataColeta = formatter.parse(dados.getDataDaColeta());
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Endereco endereco = new Endereco.Builder()
												.bairro(dados.getBairro())
												.cep(dados.getCep().replace("-", ""))
												.complemento(dados.getComplemento())
												.logradouro(dados.getNomeDaRua())
												.numero(dados.getNumeroRua())
												.build();
			
			i = i + 1;
			Endereco enderecoRevenda = enderecoService.salvarEndereco(endereco, new Municipio(dados.getMunicipio(), null), new Regiao(dados.getRegiao()), new Uf(dados.getEstado(), null));
			
			Bandeira bandeira = bandeiraService.salvarBandeira(new Bandeira(dados.getBandeira()));
			
			MedidaCombustivel medidaCombustivel = medidaCombustivelService.salvarMedidaCombustivel(new MedidaCombustivel(dados.getUnidadeDeMedida()));
			
			Produto produto = produtoService.salvarProduto(new Produto(dados.getProduto(), medidaCombustivel));
			
			Empresa empresa = empresaService.salvarEmpresa(new Empresa(dados.getCnpj().replace(".", "").replace("/", "").replace("-", "").replace(" ", ""), dados.getRevenda()));

			salvarRevenda(new Revenda.Builder()
										.bandeira(bandeira)
										.empresa(empresa)
										.endereco(enderecoRevenda)
										.produto(produto)
										.valorCompra(dados.getValordeCompra().equals("") ? null : Float.valueOf(dados.getValordeCompra().replace(",",".")))
										.valorVenda(dados.getValorDeVenda().equals("") ? null : Float.valueOf(dados.getValorDeVenda().replace(",",".")))
										.dataColeta(dataColeta)
										.build());

		}
	}

	private void salvarRevenda(Revenda revenda) {
		revendaRepository.save(revenda);
	}

}