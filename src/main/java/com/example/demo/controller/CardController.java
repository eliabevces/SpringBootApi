package com.example.demo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Activity;
import com.example.demo.model.Bill;
import com.example.demo.model.Card;
import com.example.demo.model.Patient;
import com.example.demo.repo.Cardrepo;

@RestController
@RequestMapping(path = "/cards")
public class CardController {
	
	@Autowired
	Cardrepo CardRepository;
	
	@GetMapping(path = "/searchcards({activityid},{q},{qvalue},{filter},{page},{perpage})",produces = "application/json")
	public List<Card> getCards(@PathVariable int activityid,@PathVariable String q,@PathVariable String qvalue,@PathVariable String filter,
			@PathVariable int page,@PathVariable int perpage) 
	{
		switch(q) {
			case "patientName":
				return searchByPatientName(qvalue, filter, page, perpage);
			case "visitId ":
				int visitid = Integer.parseInt(qvalue); 
				return searchByVisitid(visitid, filter, page, perpage);
			case "billId":
				int billid = Integer.parseInt(qvalue); 
				return searchBybillid(billid, filter, page, perpage);
			default:
				return searchByactivityid(activityid, filter, page, perpage);
		}	
	}
	
	private List<Card> searchByPatientName(String patientName, String filter, int page, int perpage){
		List<Card> allcards = CardRepository.findAll();
		List<Card> returncards = new ArrayList<Card>();
		switch(filter) {
			case "TO_RECEIVE":
				for(Card card : allcards){
					Patient patient = card.getPatient();
					HashMap<String,Boolean> documents = card.getDocuments();
					if(patient.getName() == patientName && documents.containsValue(false)) {
					//it checks if theres any unreceived document
						returncards.add(card);
					}
				}
				return returncards;
				
			case "TO_SEND":
				for(Card card : allcards){
					Patient patient = card.getPatient();
					HashMap<String,Boolean> documents = card.getDocuments();
					HashMap<String,Boolean> checklist = card.getChecklist();
					HashMap<String,Boolean> pendencies = card.getPendencies();
					
					if(patient.getName() == patientName && !(documents.containsValue(false)) && !(checklist.containsValue(false)) && !(pendencies.containsValue(false)) ) {
					// it checks if all documents, checkitens and pendencies are done
						returncards.add(card);
					}
				}
				return returncards;
			default:
				
				for(Card card : allcards){
					Patient patient = card.getPatient();
					if(patient.getName() == patientName) {
						returncards.add(card);
					}
				}
				return returncards;
				
		}
	}
	
	
	private List<Card> searchByVisitid(int visitid, String filter,int page, int perpage){
		Card card = CardRepository.getOne(visitid);
		List<Card> returncards = new ArrayList<Card>();
		HashMap<String,Boolean> documents = card.getDocuments();

		switch(filter) {
		case "TO_RECEIVE":
				if(card.getVisitId() == visitid && documents.containsValue(false)) {
				//it checks if theres any unreceived document
					returncards.add(card);
				}
			return returncards;
			
			
		case "TO_SEND":
				HashMap<String,Boolean> checklist = card.getChecklist();
				HashMap<String,Boolean> pendencies = card.getPendencies();
				
				if(card.getVisitId() == visitid && !(documents.containsValue(false)) && !(checklist.containsValue(false)) && !(pendencies.containsValue(false)) ) {
				// it checks if all documents, checkitens and pendencies are done
					returncards.add(card);
				}
			return returncards;
			
		default:
			if(card.getVisitId() == visitid) {
				returncards.add(card);
			}
			return returncards;
			
		}
	}
	
	private List<Card> searchBybillid(int billid, String filter,int page, int perpage){
		List<Card> allcards = CardRepository.findAll();
		List<Card> returncards = new ArrayList<Card>();
		switch(filter) {
			case "TO_RECEIVE":
				for(Card card : allcards){
					Bill bill = card.getBill();
					HashMap<String,Boolean> documents = card.getDocuments();
					if(bill.getBillid() == billid && documents.containsValue(false)) {
					//it checks if theres any unreceived document
						returncards.add(card);
					}
				}
				return returncards;
				
			case "TO_SEND":
				for(Card card : allcards){
					Bill bill = card.getBill();
					HashMap<String,Boolean> documents = card.getDocuments();
					HashMap<String,Boolean> checklist = card.getChecklist();
					HashMap<String,Boolean> pendencies = card.getPendencies();
					
					if(bill.getBillid() == billid && !(documents.containsValue(false)) && !(checklist.containsValue(false)) && !(pendencies.containsValue(false)) ) {
					// it checks if all documents, checkitens and pendencies are done
						returncards.add(card);
					}
				}
				return returncards;
			default:
				
				for(Card card : allcards){
					Bill bill = card.getBill();
					if(bill.getBillid() == billid) {
						returncards.add(card);
					}
				}
				return returncards;
				
		}
	}
	private List<Card> searchByactivityid(int activityid, String filter,int page, int perpage){
		List<Card> allcards = CardRepository.findAll();
		List<Card> returncards = new ArrayList<Card>();
		switch(filter) {
			case "TO_RECEIVE":
				for(Card card : allcards){
					Activity activitity = card.getActivity();
					HashMap<String,Boolean> documents = card.getDocuments();
					System.out.println(card.getDocuments());
					if(activitity.getActivityid() == activityid && documents.containsValue(false)) {
					//it checks if theres any unreceived document
						
						returncards.add(card);
					}
				}
				return returncards;
				
			case "TO_SEND":
				for(Card card : allcards){
					Activity activitity = card.getActivity();
					HashMap<String,Boolean> documents = card.getDocuments();
					HashMap<String,Boolean> checklist = card.getChecklist();
					HashMap<String,Boolean> pendencies = card.getPendencies();
					
					if(activitity.getActivityid() == activityid && !(documents.containsValue(false)) && !(checklist.containsValue(false)) && !(pendencies.containsValue(false)) ) {
					// it checks if all documents, checkitens and pendencies are done
						returncards.add(card);
					}
				}
				return returncards;
			default:
				System.out.println("default activityid");
				for(Card card : allcards){
					Activity activitity = card.getActivity();
					if(activitity.getActivityid() == activityid) {
						returncards.add(card);
					}
				}
				return returncards;
				
		}
	}	
	

}
