package com.javabykiran.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "state_master")
public class StateAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private int sid;

	@Column(name = "state")
	private String state;
	
/*	@OneToMany(mappedBy="stateAdmin", cascade = CascadeType.ALL)
	Set<Admin> stateAdminSet = new HashSet<Admin>();*/
	

	public StateAdmin() {

	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

/*	public Set<Admin> getAdmin() {
		return stateAdminSet;
	}

	public void setAdmin(Set<Admin> stateAdminSet) {
		this.stateAdminSet = stateAdminSet;
	}*/

	@Override
	public String toString() {
		return "StateAdmin [sid=" + sid + ", state=" + state + "]";
	}
	
	
	

}
