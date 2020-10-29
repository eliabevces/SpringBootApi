package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Patient;

@RepositoryRestResource(collectionResourceRel = "Patients", path = "patients")
public interface Patientrepo extends JpaRepository<Patient, Integer>
{

}
