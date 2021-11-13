package br.com.gerenciamentoCombustivel.backand.dto;

public class ListSelectDto {
	
	private Long id;
	
	private String name;
	
	public static interface ListSelect{
		Long getId();
		String getName();
	}
	
	public ListSelectDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public ListSelectDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
