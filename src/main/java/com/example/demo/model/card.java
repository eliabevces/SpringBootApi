package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {
	
	@Id
	@GeneratedValue
	private Patient patient;
	private HealthInsurance healthinsurance;
	private Bill bill;
	private int visitId;
	private Date CreatedIn;
	private Activity activity;




	public Card(Patient patient, HealthInsurance healthinsurance, Bill bill, int visitId, Date createdIn,
			Activity activity) {
		this.patient = patient;
		this.healthinsurance = healthinsurance;
		this.bill = bill;
		this.visitId = visitId;
		CreatedIn = createdIn;
		this.activity = activity;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public HealthInsurance getHealthinsurance() {
		return healthinsurance;
	}

	public void setHealthinsurance(HealthInsurance healthinsurance) {
		this.healthinsurance = healthinsurance;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	
	
	
	
	
	
}
