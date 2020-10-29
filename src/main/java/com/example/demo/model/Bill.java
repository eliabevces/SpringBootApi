package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bill {

	@Id
	@GeneratedValue
	private int billid;
	
	private String billtype;
	
	private Float totalamount;
	
	@OneToMany(mappedBy = "bill") //bidirectinal relation
    private List<Card> cards;
	
	public Bill() {}


	
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public String getBilltype() {
		return billtype;
	}
	public void setBilltype(String billtype) {
		this.billtype = billtype;
	}



	public Float getTotalamount() {
		return totalamount;
	}



	public void setTotalamount(Float totalamount) {
		this.totalamount = totalamount;
	}



	public List<Card> getCards() {
		return cards;
	}



	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	
	
}
