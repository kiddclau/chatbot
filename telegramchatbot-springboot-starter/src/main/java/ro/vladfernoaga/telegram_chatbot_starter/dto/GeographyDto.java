package ro.vladfernoaga.telegram_chatbot_starter.dto;

public class GeographyDto {
	private Long id;
	private String place_name;
	private String climate;
	private Long population;
	private String history;
	private String other_details;
	
	public GeographyDto(Long id, String place_name, String climate, Long population, String history, String other_details) {
		super();
		this.id = id;
		this.place_name = place_name;
		this.climate = climate;
		this.population = population;
		this.history = history;
		this.other_details = other_details;
	}
	
	public GeographyDto() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getOther_details() {
		return other_details;
	}

	public void setOther_details(String other_details) {
		this.other_details = other_details;
	}
	
	
	
}
