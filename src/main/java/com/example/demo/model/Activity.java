package com.example.demo.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Activity {
	
	@Id
	@GeneratedValue
	private int activityid;
	private String activityTitle;
	private String activitysubtitle;
	private int sla;
	
	@OneToMany(mappedBy = "activity") //bidirectinal relation
    private List<Card> cards;
	
	
	
	
	public Activity() {}
	
	public int getActivityid() {
		return activityid;
	}
	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}
	public String getActivityTitle() {
		return activityTitle;
	}
	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}
	public String getActivitysubtitle() {
		return activitysubtitle;
	}
	public void setActivitysubtitle(String activitysubtitle) {
		this.activitysubtitle = activitysubtitle;
	}
	public int getSla() {
		return sla;
	}
	public void setSla(int sla) {
		this.sla = sla;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
	
}
