package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HealthInsurance {
	
	@Id
	@GeneratedValue
	private int healthInsuranceId;
	private String name;
	
	
	public HealthInsurance() {}
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
	
	
}
