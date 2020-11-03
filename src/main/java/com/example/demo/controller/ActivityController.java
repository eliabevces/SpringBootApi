package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Activity;
import com.example.demo.repo.Activityrepo;

@RestController
@RequestMapping(path = "/activities")
public class ActivityController {
	
	@Autowired
	Activityrepo ActivityRepository;
	
	@GetMapping(produces = "application/json")
	public List<Activity> getActivities() 
	{
	    return ActivityRepository.findAll();
	}
	 
	
	@PostMapping(path="/createactivity")
	public Activity CreateActivity(String activityTitle, String activitySubtitle, int sla) {
		Activity act = new Activity(activityTitle, activitySubtitle, sla);
		ActivityRepository.save(act);
		return act;
	}
	
	
}
