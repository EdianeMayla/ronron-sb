package ronron.spring.boot.model.entities;

import ronron.spring.boot.model.enuns.AnimalType;
import ronron.spring.boot.model.enuns.Gender;
import ronron.spring.boot.model.enuns.Situation;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Animals {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Enumerated(EnumType.STRING)
	private AnimalType type;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String collors;
	private String date;
	private String tutorname;
	private String tutorphone;
	private Boolean solved;
	private String reward;
	private Double price;
    private String observations;
	@Enumerated(EnumType.STRING)
	private Situation situation;

    @ManyToOne //(fetch = FetchType.EAGER)
    private Users user;
    
    public Animals() {
	}

	public Animals(Integer id, String name, AnimalType type, Gender gender, String collors, String date, String tutorname, String tutorphone, Boolean found, String reward, Double price, String observations, Situation situation, Users user) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.gender = gender;
		this.collors = collors;
		this.date = date;
		this.tutorname = tutorname;
		this.tutorphone = tutorphone;
		this.solved = found;
		this.reward = reward;
		this.price = price;
		this.observations = observations;
		this.situation = situation;
		this.user = user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AnimalType getType() {
		return type;
	}

	public void setType(AnimalType type) {
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

	public Boolean getSolved() {
		return solved;
	}

	public void setSolved(Boolean solved) {
		this.solved = solved;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}
}


	
