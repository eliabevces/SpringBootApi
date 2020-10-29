package com.example.demo.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activity {
	
	@Id
	@GeneratedValue
	private  int activityid;
	private String activityTitle;
	private String activitysubtitle;
	private int sla;
	
	
	
	
	public Activity(int activityid, String activityTitle, String activitysubtitle, int sla) {
		super();
		this.activityid = activityid;
		this.activityTitle = activityTitle;
		this.activitysubtitle = activitysubtitle;
		this.sla = sla;
	}
	
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

	
	
}
