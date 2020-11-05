package com.example.demo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Activity;
import com.example.demo.model.Bill;
import com.example.demo.model.Card;
import com.example.demo.model.CardData;
import com.example.demo.model.Patient;
import com.example.demo.repo.Cardrepo;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping(path = "/cards")
public class CardController {
	
	@Autowired
	Cardrepo CardRepository;
	
	@GetMapping(path = "/searchcards({activityid},{q},{qvalue},{filter},{page},{perpage})",produces = "application/json")
	public  ResponseEntity<Object> getCards(@PathVariable int activityid,@PathVariable String q,@PathVariable String qvalue,@PathVariable String filter,
			@PathVariable int page,@PathVariable int perpage) 
	{
		List<JSONObject> entities = new ArrayList<JSONObject>();
		List<Card> list;
		JSONObject entity = new JSONObject();
		JSONObject cardsOk = new JSONObject();
		JSONObject cardsWarning = new JSONObject();
		JSONObject cardsDelayed = new JSONObject();
		int totalCardsOk = 0;
		int totalCardsWarning = 0;
		int totalCardsDelayed = 0;
		
		switch(q) {
			case "patientName":
				list = searchByPatientName(qvalue, filter, page, perpage);
				for(Card card : list) {
					CardData cardData = new CardData(card);
					entity.put("card "+card.getVisitId(), cardData);
					if(cardData.getSlaStatus()=="OK") totalCardsOk++;
					if(cardData.getSlaStatus()=="WARNING") totalCardsWarning++;
					if(cardData.getSlaStatus()=="DELAYED") totalCardsDelayed++;
				}
				cardsOk.put("totalCardsOk", totalCardsOk);
				cardsWarning.put("totalCardsWarning", totalCardsWarning);
				cardsDelayed.put("totalCardsDelayed", totalCardsDelayed);
	            entities.add(entity);
	            entities.add(cardsOk);
	            entities.add(cardsWarning);
	            entities.add(cardsDelayed);
	            return new ResponseEntity<Object>(entities, HttpStatus.OK);
	            
	            
			case "visitId ":
				int visitid = Integer.parseInt(qvalue); 
				list = searchByVisitid(visitid, filter, page, perpage);
				for(Card card : list) {
					CardData cardData = new CardData(card);
					entity.put("card "+card.getVisitId(), cardData);
					if(cardData.getSlaStatus()=="OK") totalCardsOk++;
					if(cardData.getSlaStatus()=="WARNING") totalCardsWarning++;
					if(cardData.getSlaStatus()=="DELAYED") totalCardsDelayed++;
				}
				cardsOk.put("totalCardsOk", totalCardsOk);
				cardsWarning.put("totalCardsWarning", totalCardsWarning);
				cardsDelayed.put("totalCardsDelayed", totalCardsDelayed);
	            entities.add(entity);
	            entities.add(cardsOk);
	            entities.add(cardsWarning);
	            entities.add(cardsDelayed);
	            return new ResponseEntity<Object>(entities, HttpStatus.OK);
	            
	           
			case "billId":
				int billid = Integer.parseInt(qvalue); 
				list = searchBybillid(billid, filter, page, perpage);
				for(Card card : list) {
					CardData cardData = new CardData(card);
					entity.put("card "+card.getVisitId(), cardData);
					if(cardData.getSlaStatus()=="OK") totalCardsOk++;
					if(cardData.getSlaStatus()=="WARNING") totalCardsWarning++;
					if(cardData.getSlaStatus()=="DELAYED") totalCardsDelayed++;
				}
				cardsOk.put("totalCardsOk", totalCardsOk);
				cardsWarning.put("totalCardsWarning", totalCardsWarning);
				cardsDelayed.put("totalCardsDelayed", totalCardsDelayed);
	            entities.add(entity);
	            entities.add(cardsOk);
	            entities.add(cardsWarning);
	            entities.add(cardsDelayed);
	            return new ResponseEntity<Object>(entities, HttpStatus.OK);
	            
	            
			default:
				list = searchByactivityid(activityid, filter, page, perpage);
				for(Card card : list) {
					CardData cardData = new CardData(card);
					entity.put("card "+card.getVisitId(), cardData);
					if(cardData.getSlaStatus()=="OK") totalCardsOk++;
					if(cardData.getSlaStatus()=="WARNING") totalCardsWarning++;
					if(cardData.getSlaStatus()=="DELAYED") totalCardsDelayed++;
				}
				cardsOk.put("totalCardsOk", totalCardsOk);
				cardsWarning.put("totalCardsWarning", totalCardsWarning);
				cardsDelayed.put("totalCardsDelayed", totalCardsDelayed);
	            entities.add(entity);
	            entities.add(cardsOk);
	            entities.add(cardsWarning);
	            entities.add(cardsDelayed);
	            return new ResponseEntity<Object>(entities, HttpStatus.OK);
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
					if(patient.getName().toUpperCase().equals(patientName.toUpperCase()) && documents.containsValue(false)) {
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
					
					if(patient.getName().toUpperCase().equals(patientName.toUpperCase()) && !(documents.containsValue(false)) && !(checklist.containsValue(false)) && !(pendencies.containsValue(false)) ) {
					// it checks if all documents, checkitens and pendencies are done
						returncards.add(card);
					}
				}
				return returncards;
			default:
				for(Card card : allcards){
					Patient patient = card.getPatient();
					if(patient.getName().toUpperCase().equals(patientName.toUpperCase())) {
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
