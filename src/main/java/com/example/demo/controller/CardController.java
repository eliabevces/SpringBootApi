package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.Cardrepo;

@RestController
@RequestMapping(path = "/cards")
public class CardController {
	
	@Autowired
	Cardrepo CardRepository;
	
	@GetMapping(produces = "application/json")
	public String getCards() 
	{
	    return CardRepository.findAll().toString();
	}
	
	
}
