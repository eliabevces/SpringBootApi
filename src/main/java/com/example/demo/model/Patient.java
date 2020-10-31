package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Patient {

	
	@Id
	@GeneratedValue
	private int patientId;
	
	
	private String name;
	
    @OneToMany(mappedBy = "patient") //bidirectinal relation
    private List<Card> cards;
	
    
	
	
	public Patient(String name) {
		this.name = name;
	}
	
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
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
