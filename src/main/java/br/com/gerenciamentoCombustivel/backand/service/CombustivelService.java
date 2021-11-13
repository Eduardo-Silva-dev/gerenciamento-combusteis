package br.com.gerenciamentoCombustivel.backand.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.gerenciamentoCombustivel.backand.dto.ListCsvVendaCombustivelDTO;
import br.com.gerenciamentoCombustivel.backand.util.FileCsv;

@Service
public class CombustivelService {

	@Autowired
	private FileCsv fileCsv;
	
	@Autowired 
	private RevendaService revendaService;
	
	@SuppressWarnings("unchecked")
	public void converterFileCsv(MultipartFile file) throws ParseException {
		ListCsvVendaCombustivelDTO list = new ListCsvVendaCombustivelDTO();
		List<ListCsvVendaCombustivelDTO> r = (List<ListCsvVendaCombustivelDTO>) fileCsv.lerArquivo(list, file, ";");
		revendaService.criarRegritroDeRevenda(r);
	}
	
}
