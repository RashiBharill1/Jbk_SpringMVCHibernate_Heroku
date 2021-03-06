package com.javabykiran.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobileNumber;

	@Column(name = "gender")
	private String gender;

	/*@Column(name = "state")
	private String state;*/

	@Column(name = "course")
	private String course;

	@Column(name = "password")
	private String password;

	@Column(name = "isDefault")
	private String isDefault;
	 

/*	@ManyToOne
	@JoinColumn(name="sid")
	private StateAdmin stateAdmin;*/
	

	@Column(name = "sid")
	private int sid;

	private String state;


	public Admin() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	/*@ManyToOne
	public StateAdmin getStateAdmin() {
		return stateAdmin;
	}

	public void setStateAdmin(StateAdmin stateAdmin) {
	 this.stateAdmin = stateAdmin;
	}*/

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", gender=" + gender + ", course=" + course + ", password=" + password + ", isDefault=" + isDefault
				+ ", sid=" + sid + ", state=" + state + "]";
	}


}
