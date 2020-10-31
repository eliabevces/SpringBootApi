package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Card {
	
	@Id
	@GeneratedValue
	private int visitId; //Card identifier
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	private Patient patient;	// Patient that the card belongs to
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	@JoinColumn(name = "healthInsurance_id")
	private HealthInsurance healthinsurance; // Card's Health insurance

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	@JoinColumn(name = "bill_id")
	private Bill bill;	// Card bill
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
	private Date CreatedIn;	// date that the card was created
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	@JoinColumn(name = "activity_id")
	private Activity activity;	//Which activity the card belongs








	public Card(Patient patient, HealthInsurance healthinsurance, Bill bill, Activity activity) {
		this.patient = patient;
		this.healthinsurance = healthinsurance;
		this.bill = bill;
		this.activity = activity;
	}










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
