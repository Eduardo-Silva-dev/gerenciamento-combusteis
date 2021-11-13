package br.com.gerenciamentoCombustivel.backand.util;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Component
public class FileCsv {

	public List<?> lerArquivo(Object listDados, MultipartFile file, String separator) {
		 try {
			 
				Reader reader = new InputStreamReader(file.getInputStream());
				
				CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(new CSVParserBuilder().withSeparator(separator.charAt(0)).build()).build();
				
		        String[] nextRecord;
		       
				List<List<String>> linhas = new ArrayList<>();

		        while ((nextRecord = csvReader.readNext()) != null) {
		        	linhas.add(Arrays.asList(nextRecord));
		        }
		    	
				List<String> nameColunasObject = new ArrayList<>();
		
				Class<?> clazz = listDados.getClass();
				Constructor<?> ctor = clazz.getConstructor();
		
				for (Field field : clazz.getDeclaredFields()) {
					nameColunasObject.add(field.getName());
				}
		        
		        List<Object> dadosSaida = new ArrayList<>();
		    	
				for (List<String> dados : linhas) {
					dadosSaida.add(mapperDadosObject(ctor,clazz,dados,nameColunasObject));
				}
				
				return dadosSaida;
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
	}
	
	private Object mapperDadosObject(Constructor<?> ctor, Class<?> clazz, List<String> dados, List<String> nameColunasObject) {
		Object object = null;
		try {
				object = ctor.newInstance();
			
			for (int i = 0; i < dados.size(); i++) {							
				
					Field field = null;
					try {
						field = clazz.getDeclaredField(nameColunasObject.get(i));
					} catch (NoSuchFieldException | SecurityException e) {
						e.printStackTrace();
					}
					field.setAccessible(true);
					try {
						field.set(object, dados.get(i));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}						
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
			e1.printStackTrace();
		}
		return object;
	}
}
