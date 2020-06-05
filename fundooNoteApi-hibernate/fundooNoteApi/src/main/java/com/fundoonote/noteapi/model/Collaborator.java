package com.fundoonote.noteapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "collaborate")
public class Collaborator implements Serializable {
	private static final long serialVersionUID = 7156526077883281623L;

	@JsonView(View.Summary.class)
	@Id
	@GeneratedValue
	private int id;

	@JsonView(View.Summary.class)
	@Column
	private String email;

	@JsonView(View.Summary.class)
	@Column
	private String password;

	public Collaborator(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public Collaborator() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
