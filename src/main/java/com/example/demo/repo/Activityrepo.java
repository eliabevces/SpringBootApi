package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Activity;

@RepositoryRestResource(collectionResourceRel = "Activities", path = "activities")
public interface Activityrepo extends JpaRepository<Activity, Integer>{

}
