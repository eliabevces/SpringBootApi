package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.HealthInsurance;

//Health Insurance repository
@RepositoryRestResource(collectionResourceRel = "Healthinsurances", path = "healthinsurances")
public interface HealthInsurancerepo extends JpaRepository<HealthInsurance, Integer>{

}
