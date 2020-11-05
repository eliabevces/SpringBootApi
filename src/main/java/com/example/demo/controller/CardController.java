package com.example.demo.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Activity;
import com.example.demo.model.Bill;
import com.example.demo.model.Card;
import com.example.demo.model.CardData;
import com.example.demo.model.Patient;
import com.example.demo.repo.Activityrepo;
import com.example.demo.repo.Billrepo;
import com.example.demo.repo.Cardrepo;
import com.example.demo.repo.HealthInsurancerepo;
import com.example.demo.repo.Patientrepo;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping(path = "/cards")
public class CardController {
	
	@Autowired
	Cardrepo CardRepository;
	@Autowired
	Activityrepo activityRepository;
	@Autowired
	Billrepo billRepository;
	@Autowired
	HealthInsurancerepo healthInsuranceRepository;
	@Autowired
	Patientrepo patientRepository;
	
	//create card endpoint
	@PostMapping(path="/createcard({patientId},{healthinsuranceid},{billtype},{billtotalamount},{activityid})")
	public void CreateCard(@PathVariable int patientId,@PathVariable int healthinsuranceid,@PathVariable String billtype,
			@PathVariable double billtotalamount,@PathVariable int activityid) 
	{	
		//Creating cards by getting the entities by their Ids and creating empty lists
		
		Bill bill = new Bill(billtype, billtotalamount); // bill has a one to one relation, so it can't get a existent bill
		billRepository.save(bill);
		
		HashMap<String,Boolean> checklist = new HashMap<String,Boolean>();
		HashMap<String,Boolean> documents = new HashMap<String,Boolean>();
		HashMap<String,Boolean> pendencies = new HashMap<String,Boolean>();
		
		Card card = new Card(patientRepository.getOne(patientId), healthInsuranceRepository.getOne(healthinsuranceid),
				bill, activityRepository.getOne(activityid), checklist, documents, pendencies);
				CardRepository.save(card);
		
		
	} 
	
	//auxiliary method to add new checkitems to a card's checklist
	@PostMapping(path="/addcheckitem({cardid},{description},{done})")
	public void AddCheckItem(@PathVariable int cardid,@PathVariable String description, @PathVariable Boolean done) {
		Card card = CardRepository.getOne(cardid);
		HashMap<String,Boolean> checklist = card.getChecklist();
		checklist.put(description, done);
		CardRepository.save(card);
	}
	
	//auxiliary method to add new documents to a card's documents list
	@PostMapping(path="/adddocument({cardid},{description},{received})")
	public void AddDocument(@PathVariable int cardid,@PathVariable String description, @PathVariable Boolean received) {
		Card card = CardRepository.getOne(cardid);
		HashMap<String,Boolean> document = card.getDocuments();
		document.put(description, received);
		CardRepository.save(card);
	}
	
	//auxiliary method to add new pendencies to a card's pendencies list
	@PostMapping(path="/addpendency({cardid},{description},{done})")
	public void addPendency(@PathVariable int cardid,@PathVariable String description, @PathVariable Boolean done) {
		Card card = CardRepository.getOne(cardid);
		HashMap<String,Boolean> pendency = card.getPendencies();
		pendency.put(description, done);
		CardRepository.save(card);
	}
	
	// get especific cards endpoint
	@GetMapping(path = "/searchcards({activityid},{q},{qvalue},{filter},{page},{perpage})",produces = "application/json")
	public  ResponseEntity<Object> getCards(@PathVariable int activityid,@PathVariable String q,@PathVariable String qvalue,
			@PathVariable String filter,@PathVariable int page,@PathVariable int perpage) 
	{
		List<JSONObject> entities = new ArrayList<JSONObject>();
		List<Card> list;
		JSONObject entity = new JSONObject();
		JSONObject cardsOk = new JSONObject();
		JSONObject cardsWarning = new JSONObject();
		JSONObject cardsDelayed = new JSONObject();
		JSONObject pageinfo = new JSONObject();
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
	            pageinfo.put("Page", page);
	            pageinfo.put("Cards per page", perpage);
	            entities.add(pageinfo);
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
	            pageinfo.put("Page", page);
	            pageinfo.put("Cards per page", perpage);
	            entities.add(pageinfo);
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
	            pageinfo.put("Page", page);
	            pageinfo.put("Cards per page", perpage);
	            entities.add(pageinfo);
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
	            pageinfo.put("Page", page);
	            pageinfo.put("Cards per page", perpage);
	            entities.add(pageinfo);
	            return new ResponseEntity<Object>(entities, HttpStatus.OK);
		}	
	}
	
	//auxiliary method to search cards by patient name
	private List<Card> searchByPatientName(String patientName, String filter, int page, int perpage){
		List<Card> allcards = CardRepository.findAll();
		List<Card> returncards = new ArrayList<Card>();
		int bottomEligiblecards = (page-1)*perpage; // which index this page has to begin
		int topEligibleCards = page*perpage; // which index this page has to end
		int index = 1;
		switch(filter) {
			case "TO_RECEIVE":
				for(Card card : allcards){
					Patient patient = card.getPatient();
					HashMap<String,Boolean> documents = card.getDocuments();
					if(patient.getName().toUpperCase().equals(patientName.toUpperCase()) && documents.containsValue(false)) {
					//it checks if theres any unreceived document
						if(index>bottomEligiblecards && index<=topEligibleCards) {
							returncards.add(card);
						}
						index++;
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
						if(index>bottomEligiblecards && index<=topEligibleCards) {
							returncards.add(card);
						}
						index++;
					}
				}
				return returncards;
			default:
				for(Card card : allcards){
					Patient patient = card.getPatient();
					if(patient.getName().toUpperCase().equals(patientName.toUpperCase())) {
						if(index>bottomEligiblecards && index<=topEligibleCards) {
							returncards.add(card);
						}
						index++;
					}
				}
				return returncards;
				
		}
	}
	
	//auxiliary method to search cards by visit id
	private List<Card> searchByVisitid(int visitid, String filter,int page, int perpage){
		Card card = CardRepository.getOne(visitid);
		List<Card> returncards = new ArrayList<Card>();
		HashMap<String,Boolean> documents = card.getDocuments();
		int bottomEligiblecards = (page-1)*perpage; // which index this page has to begin
		int topEligibleCards = page*perpage; // which index this page has to end
		int index = 1;
		
		switch(filter) {
		case "TO_RECEIVE":
				if(card.getVisitId() == visitid && documents.containsValue(false)) {
				//it checks if theres any unreceived document
					if(index>bottomEligiblecards && index<=topEligibleCards) {
						returncards.add(card);
					}
					index++;
				}
			return returncards;
			
			
		case "TO_SEND":
				HashMap<String,Boolean> checklist = card.getChecklist();
				HashMap<String,Boolean> pendencies = card.getPendencies();
				
				if(card.getVisitId() == visitid && !(documents.containsValue(false)) && !(checklist.containsValue(false)) && !(pendencies.containsValue(false)) ) {
				// it checks if all documents, checkitens and pendencies are done
					if(index>bottomEligiblecards && index<=topEligibleCards) {
						returncards.add(card);
					}
					index++;
				}
			return returncards;
			
		default:
			if(card.getVisitId() == visitid) {
				if(index>bottomEligiblecards && index<=topEligibleCards) {
					returncards.add(card);
				}
				index++;
			}
			return returncards;
			
		}
	}
	
	//auxiliary method to search cards by bill id
	private List<Card> searchBybillid(int billid, String filter,int page, int perpage){
		List<Card> allcards = CardRepository.findAll();
		List<Card> returncards = new ArrayList<Card>();
		int bottomEligiblecards = (page-1)*perpage; // which index this page has to begin
		int topEligibleCards = page*perpage; // which index this page has to end
		int index = 1;
		switch(filter) {
			case "TO_RECEIVE":
				for(Card card : allcards){
					Bill bill = card.getBill();
					HashMap<String,Boolean> documents = card.getDocuments();
					if(bill.getBillid() == billid && documents.containsValue(false)) {
					//it checks if there's any unreceived document
						if(index>bottomEligiblecards && index<=topEligibleCards) {
							returncards.add(card);
						}
						index++;
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
						if(index>bottomEligiblecards && index<=topEligibleCards) {
							returncards.add(card);
						}
						index++;
					}
				}
				return returncards;
			default:
				
				for(Card card : allcards){
					Bill bill = card.getBill();
					if(bill.getBillid() == billid) {
						if(index>bottomEligiblecards && index<=topEligibleCards) {
							returncards.add(card);
						}
						index++;
					}
				}
				return returncards;
				
		}
	}
	
	//auxiliary method to search cards by activity id
	private List<Card> searchByactivityid(int activityid, String filter,int page, int perpage){
		List<Card> allcards = CardRepository.findAll();
		List<Card> returncards = new ArrayList<Card>();
		int bottomEligiblecards = (page-1)*perpage; // which index this page has to begin
		int topEligibleCards = page*perpage; // which index this page has to end
		int index = 1;
		switch(filter) {
			case "TO_RECEIVE":
				for(Card card : allcards){
					Activity activitity = card.getActivity();
					HashMap<String,Boolean> documents = card.getDocuments();
					System.out.println(card.getDocuments());
					if(activitity.getActivityid() == activityid && documents.containsValue(false)) {
					//it checks if theres any unreceived document
						
						if(index>bottomEligiblecards && index<=topEligibleCards) {
							returncards.add(card);
						}
						index++;
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
						if(index>bottomEligiblecards && index<=topEligibleCards) {
							returncards.add(card);
						}
						index++;
					}
				}
				return returncards;
			default:
				System.out.println("default activityid");
				for(Card card : allcards){
					Activity activitity = card.getActivity();
					if(activitity.getActivityid() == activityid) {
						if(index>bottomEligiblecards && index<=topEligibleCards) {
							returncards.add(card);
						}
						index++;
					}
				}
				return returncards;
				
		}
	}	
	

}
