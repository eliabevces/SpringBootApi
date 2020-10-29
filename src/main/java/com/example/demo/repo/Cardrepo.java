package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Card;

@RepositoryRestResource(collectionResourceRel = "Cards", path = "cards")
public interface Cardrepo extends JpaRepository<Card, Integer>
{

}
