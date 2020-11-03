package com.example.demo.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bill {

	@Id
	@GeneratedValue
	private int billid; //bill identifier
	
	private String billtype;	//bill type
	
	private Double totalamount;	//bill "price"
	
	@OneToOne(mappedBy = "bill") //bidirectinal relation
    private Card card;
	
	
	

	
	
	public Bill() {}

	public Bill(String billtype, Double totalamount) {
		this.billtype = billtype;
		this.totalamount = totalamount;
	}
	
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



	public Double getTotalamount() {
		return totalamount;
	}



	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}



	public Card getCard() {
		return card;
	}



	public void setCard(Card card) {
		this.card = card;
	}



	
	
}
