package com.example.demo.database;

import java.util.Arrays;
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
			 
			 Card card1 = new Card(patient1,hi1,bill1,act2);
			 
			 Card card2 = new Card(patient2,hi3,bill2,act2);

			 
			 Card card3 = new Card(patient1,hi1,bill3,act1);

			 
			 
			 List<Card> cards = Arrays.asList(card1,card2, card3);
			 
			 cardrepository.saveAll(cards);
			 
			 
			 
			 
			 
		 };
	}
}
