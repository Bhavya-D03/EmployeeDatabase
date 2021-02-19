package com.spring;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employees {
	@Id
	private int eid;
	private String ename;
	private int eage;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}
	
	@Override
	public String toString() {
		return "Employees [eid=" + eid + ", ename=" + ename + ", eage=" + eage + "]";
	}

}
