package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bill {

	@Id
	@GeneratedValue
	private int billid;
	
	private String billtype;
	
	private Float totalamount;
	
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

	
	
}
