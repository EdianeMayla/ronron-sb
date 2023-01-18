package ronron.spring.boot.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Animals {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @NotBlank
	private String name;
    
    @NotBlank
	private String type;
    
    @NotBlank
	private String gender;
    
    @NotBlank
	private String collors;
    
    @NotBlank
	private String date;
    
    @NotBlank
	private String tutorname;
    
    @NotBlank
	private String tutorphone;
    
    @NotBlank
	private String found;
    
    @NotBlank
	private String reward;

	private Double price;

    private String observations;
    
    @ManyToOne
    private Users user;
    
    public Animals() {
	}
    
	
//    @Min(0)
//	private double preco;
//	
//    @Min(0)
//    @Max(1)
//	private double desconto;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCollors() {
		return collors;
	}

	public void setCollors(String collors) {
		this.collors = collors;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTutorname() {
		return tutorname;
	}

	public void setTutorname(String tutorname) {
		this.tutorname = tutorname;
	}

	public String getTutorphone() {
		return tutorphone;
	}

	public void setTutorphone(String tutorphone) {
		this.tutorphone = tutorphone;
	}

	public String getFound() {
		return found;
	}


	public void setFound(String found) {
		this.found = found;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}


	
