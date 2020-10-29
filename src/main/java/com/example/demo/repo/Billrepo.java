package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Bill;

@RepositoryRestResource(collectionResourceRel = "Bills", path = "bills")
public interface Billrepo extends JpaRepository<Bill, Integer>{

}


