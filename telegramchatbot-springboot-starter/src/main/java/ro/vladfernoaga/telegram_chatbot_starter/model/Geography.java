package ro.vladfernoaga.telegram_chatbot_starter.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="geography")
public class Geography {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name ="place_name")
    private String name;
    
    private Long population;
    
    private String climate;
    
    private String history;
    
    private String other_details;

	public String getPlace_name() {
		return name;
	}

	public void setPlace_name(String place_name) {
		this.name = place_name;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
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
