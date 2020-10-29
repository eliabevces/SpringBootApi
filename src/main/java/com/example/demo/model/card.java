package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Card {
	
	@Id
	@GeneratedValue
	private int visitId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	private Patient patient;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	@JoinColumn(name = "healthInsurance_id")
	private HealthInsurance healthinsurance;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	@JoinColumn(name = "bill_id")
	private Bill bill;
	private Date CreatedIn;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	@JoinColumn(name = "activity_id")
	private Activity activity;










	public Card() {}










	public int getVisitId() {
		return visitId;
	}










	public void setVisitId(int visitId) {
		this.visitId = visitId;
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
