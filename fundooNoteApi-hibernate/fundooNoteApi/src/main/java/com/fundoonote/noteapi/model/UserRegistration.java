package com.fundoonote.noteapi.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "userregistration")
public class UserRegistration implements Serializable {
	private static final long serialVersionUID = 7156526077883281623L;

	private String sid;

	@JsonView(View.Summary.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@JsonView(View.Summary.class)
	@Column
	private String firstname;

	@JsonView(View.Summary.class)
	@Column
	private String lastname;

	@JsonView(View.Summary.class)
	@Column
	private String email;

	@JsonView(View.Summary.class)
	@Column
	private String password;

	@JsonManagedReference
	@JsonIgnore
	@JsonView(View.Summary.class)
	@OneToMany(mappedBy = "userreg", fetch = FetchType.EAGER, cascade = CascadeType.ALL) // cascade = CascadeType.ALL=to
	private Set<Note> notes; // store the data to
	// database,fetch =
	// FetchType.EAGER=its is
	// used to fetch child class
	// entities from the
	// database

	public UserRegistration() {

	}

	public UserRegistration(int id, String firstname, String lastname, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;

	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "firstname=" + this.firstname + "lastname=" + this.lastname + "email=" + this.email + "password="
				+ this.password;
	}

}