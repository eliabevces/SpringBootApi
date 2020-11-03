package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HealthInsurance;
import com.example.demo.repo.HealthInsurancerepo;



@RestController
@RequestMapping(path = "/healthinsurances")
public class HealthInsuranceController {
	
	@Autowired
	HealthInsurancerepo HealthInsuranceRepository;
	
	@GetMapping(produces = "application/json")
	public List<HealthInsurance> getHealthInsurances() 
	{
	    return HealthInsuranceRepository.findAll();
	}
	
}
