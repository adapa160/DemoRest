package com.example.demo;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
//Auto table creation when generating project
@Entity
public class Customers {

	@Id
	private String cname;
	private String cemail;
	private int cid;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Customers [cname=" + cname + ", cemail=" + cemail + ", cid=" + cid + "]";
	}

	

}
