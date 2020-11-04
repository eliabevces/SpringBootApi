package com.example.demo.database;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Activity;
import com.example.demo.model.Bill;
import com.example.demo.model.Card;
import com.example.demo.model.HealthInsurance;
import com.example.demo.model.Patient;
import com.example.demo.repo.Activityrepo;
import com.example.demo.repo.Billrepo;
import com.example.demo.repo.Cardrepo;
import com.example.demo.repo.HealthInsurancerepo;
import com.example.demo.repo.Patientrepo;

@Configuration
public class LoadDatabase {
	
	@Bean
	CommandLineRunner initDatabase( Activityrepo activityrepository, Billrepo billrepository, Cardrepo cardrepository, HealthInsurancerepo healthInsurancerepository, Patientrepo patientrepository) {
		 return args -> {
			 Patient patient1 = new Patient("Patient 1");
			 Patient patient2 = new Patient("Patient 2");
			 Patient patient3 = new Patient("Patient Three");
			 
			 List<Patient> patients = Arrays.asList(patient1, patient2, patient3);
			 
			 patientrepository.saveAll(patients);
			 
			 HealthInsurance hi1 = new HealthInsurance("Unimed");
			 HealthInsurance hi2 = new HealthInsurance("porto seguro");
			 HealthInsurance hi3 = new HealthInsurance("outro seguro");
			 
			 List<HealthInsurance> healthinsurances = Arrays.asList(hi1, hi2, hi3);
			 
			 healthInsurancerepository.saveAll(healthinsurances);
			 
			 Bill bill1 = new Bill("Hospitalar", 500.00);
			 Bill bill2 = new Bill("Ambulatorial", 2000.00);
			 Bill bill3 = new Bill("Hospitalar", 50000.00);
			 
			 List<Bill> bills = Arrays.asList(bill1, bill2, bill3);
			 
			 billrepository.saveAll(bills);
			 
			 Activity act1 = new Activity("Berçario", "Organizar Prontuario", 10);
			 Activity act2 = new Activity("Auditoria", "Limpar Conta", 20);
			 Activity act3 = new Activity("Centro Cirurgico", "organizar Prontuario", 2);
			 
			 List<Activity> activities = Arrays.asList(act1, act2, act3);
			 
			 activityrepository.saveAll(activities);
			 
			 HashMap<String,Boolean> cheklist1 = new HashMap<String, Boolean>();
			 HashMap<String,Boolean> cheklist2 = new HashMap<String, Boolean>();
			 HashMap<String,Boolean> cheklist3 = new HashMap<String, Boolean>();
			 
			 
			 cheklist1.put("check 1", false);
			 cheklist1.put("check 2", false);
			 cheklist1.put("check 3", false);
			 cheklist1.put("check 4", false);
			 
			 cheklist2.put("check 1", true);
			 cheklist2.put("check 2", true);
			 cheklist2.put("check 3", true);
			 cheklist2.put("check 4", true);
			 
			 cheklist3.put("check 1", true);
			 cheklist3.put("check 2", true);
			 cheklist3.put("check 3", true);
			 cheklist3.put("check 4", false);
			 
			 HashMap<String,Boolean> documents1 = new HashMap<String, Boolean>();
			 HashMap<String,Boolean> documents2 = new HashMap<String, Boolean>();
			 HashMap<String,Boolean> documents3 = new HashMap<String, Boolean>();
			 
			 documents1.put("document 1", false);
			 documents1.put("document 2", false);
			 documents1.put("document 3", false);
			 documents1.put("document 4", false);

			 documents2.put("document 1", true);
			 documents2.put("document 2", true);
			 documents2.put("document 3", true);
			 documents2.put("document 4", true);
			 
			 documents3.put("document 1", true);
			 documents3.put("document 2", false);
			 documents3.put("document 3", true);
			 documents3.put("document 4", false);
			 
			 HashMap<String,Boolean> pendencies1 = new HashMap<String, Boolean>();
			 HashMap<String,Boolean> pendencies2 = new HashMap<String, Boolean>();
			 HashMap<String,Boolean> pendencies3 = new HashMap<String, Boolean>();
			 
			 pendencies1.put("pendency 1", true);
			 pendencies1.put("pendency 2", true);
			 pendencies1.put("pendency 3", true);
			 pendencies1.put("pendency 4", true);

			 pendencies2.put("pendency 1", false);
			 pendencies2.put("pendency 2", true);
			 pendencies2.put("pendency 3", true);
			 pendencies2.put("pendency 4", false);
			 
			 pendencies3.put("pendency 1", false);
			 pendencies3.put("pendency 2", false);
			 pendencies3.put("pendency 3", false);
			 pendencies3.put("pendency 4", false);
			 
			 Card card1 = new Card(patient1,hi1,bill1,act2,cheklist1,documents1,pendencies1);
			 
			 Card card2 = new Card(patient2,hi3,bill2,act2,cheklist2,documents2,pendencies2);

			 
			 Card card3 = new Card(patient1,hi1,bill3,act1,cheklist3,documents3,pendencies3);

			 
			 
			 List<Card> cards = Arrays.asList(card1,card2, card3);
			 
			 cardrepository.saveAll(cards);
			 
			 
			 
			 
			 
		 };
	}
}
