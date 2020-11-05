package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HealthInsurance {
	
	@Id
	@GeneratedValue
	private int healthInsuranceId; // health insurance identifier
	
	private String name; // Health Insurance name
	
	@OneToMany(mappedBy = "healthinsurance") //bidirectinal relation
    private List<Card> cards;	//Cards that belong to certain Health Insurance
	
	
	//default constructor
	
	
	public HealthInsurance() {}
	
	//constructor
	public HealthInsurance(String name) {
		this.name = name;
	}
	
	//getters and setters
	public int getHealthInsuranceId() {
		return healthInsuranceId;
	}
	public void setHealthInsuranceId(int healthInsuranceId) {
		this.healthInsuranceId = healthInsuranceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
}
