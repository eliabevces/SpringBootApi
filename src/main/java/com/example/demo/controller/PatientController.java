package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.repo.Patientrepo;

@RestController
@RequestMapping(path = "/Patients")
public class PatientController {
	
	@Autowired
	Patientrepo PatientRepository;
	
	//get all patients endpoint
	@GetMapping(produces = "application/json")
	public List<Patient> getPatients() 
	{
	    return PatientRepository.findAll();
	}
	
}
