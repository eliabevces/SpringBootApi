package com.example.demo.model;

import java.time.LocalDate;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Card {
	
	@Id
	@GeneratedValue
	private int visitId; //Card identifier
	
	@ManyToOne
	@JsonIgnore
	private Patient patient;	// Patient that the card belongs to
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "healthInsurance_id")
	private HealthInsurance healthinsurance; // Card's Health insurance

	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "bill_id")
	private Bill bill;	// Card bill
	

	private LocalDate CreatedIn;	// date that the card was created
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "activity_id")
	private Activity activity;	//Which activity the card belongs

	
	private HashMap<String,Boolean> checklist; // Boolean indicates if its done and String is the description of the check item
	
	
	private HashMap<String,Boolean> documents; // boolean indicates if the document was received and string is the description of the document 
	
	private HashMap<String,Boolean> pendencies;	// Boolean indicates if the pendency is done and String is the description of the pendency
	
	
	//default constructor
	public Card() {}

	//constructor
	public Card(Patient patient, HealthInsurance healthinsurance, Bill bill, Activity activity,
			HashMap<String,Boolean> checklist, HashMap<String,Boolean> documents,HashMap<String,Boolean> pendencies) {

		this.patient = patient;
		this.healthinsurance = healthinsurance;
		this.bill = bill;
		this.activity = activity;
		this.checklist = checklist;
		this.documents = documents;
		this.pendencies = pendencies;
		this.CreatedIn = LocalDate.now();
	}



	//getters and setters
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


	public LocalDate getCreatedIn() {
		return CreatedIn;
	}



	public void setCreatedIn(LocalDate createdIn) {
		CreatedIn = createdIn;
	}


	public Activity getActivity() {
		return activity;
	}


	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public HashMap<String, Boolean> getChecklist() {
		return checklist;
	}

	public void setChecklist(HashMap<String, Boolean> checklist) {
		this.checklist = checklist;
	}

	public HashMap<String, Boolean> getDocuments() {
		return documents;
	}

	public void setDocuments(HashMap<String, Boolean> documents) {
		this.documents = documents;
	}

	public HashMap<String, Boolean> getPendencies() {
		return pendencies;
	}

	public void setPendencies(HashMap<String, Boolean> pendencies) {
		this.pendencies = pendencies;
	}




}
