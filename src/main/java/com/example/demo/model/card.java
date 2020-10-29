package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Card {
	
	@Id
	@GeneratedValue
	private int visitId;
	
//	@JoinColumn(name = "patient_id")
//	private Patient patient;
	
//	@JoinColumn(name = "healthInsurance_id")
//	private HealthInsurance healthinsurance;
	
//	@JoinColumn(name = "bill_id")
//	private Bill bill;
	private Date CreatedIn;
	
//	@JoinColumn(name = "activity_id")
//	private Activity activity;







	public Card() {}




	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public Date getCreatedIn() {
		return CreatedIn;
	}

	public void setCreatedIn(Date createdIn) {
		CreatedIn = createdIn;
	}


	
	
	
	
	
	
}
