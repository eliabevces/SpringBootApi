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
	private int totalamount;
	
	public Bill(int billid, String billtype, int totalamount) {
		this.billid = billid;
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



	public int getTotalamount() {
		return totalamount;
	}



	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}

	
	
}
