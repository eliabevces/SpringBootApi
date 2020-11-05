package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bill;
import com.example.demo.repo.Billrepo;

@RestController
@RequestMapping(path = "/bills")
public class BillController {
	
	@Autowired
	Billrepo BillRepository;
	
	//get all bills endpoint
	@GetMapping(produces = "application/json")
	public List<Bill> getBills() 
	{
	    return BillRepository.findAll();
	}
}
