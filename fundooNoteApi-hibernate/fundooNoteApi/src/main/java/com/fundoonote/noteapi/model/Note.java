package com.fundoonote.noteapi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "note")
public class Note implements Serializable {

	private static final long serialVersionUID = 7156526077883281623L;

	@JsonView(View.Summary.class)
	@Id
	@GeneratedValue
	private int id;

	@JsonView(View.Summary.class)
	@Column
	private String title;

	@JsonView(View.Summary.class)
	@Column
	private String content;

	@JsonView(View.Summary.class)
	@Column
	private String createdAt;

	@JsonView(View.Summary.class)
	@Column
	private String updatedAt;

	@JsonView(View.Summary.class)
	@Column
	private boolean pinNotes;

	@JsonView(View.Summary.class)
	@Column
	private boolean isarchievednote;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL) // cascade = CascadeType.ALL
	@JoinColumn
	@JsonView(View.Summary.class)
	private UserRegistration userreg;

	@JsonManagedReference
	@JsonView(View.Summary.class)
	@OneToMany(mappedBy = "note", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Label> labels;

	public Note(int id, String title, String content, String createdAt, String updatedAt, boolean pinNotes,
			boolean isarchievednote, UserRegistration userreg) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.pinNotes = pinNotes;
		this.isarchievednote = isarchievednote;
		this.userreg = userreg;

	}

	public Note() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean getPinNotes() {
		return pinNotes;
	}

	public void setPinNotes(boolean pinNotes) {
		this.pinNotes = pinNotes;
	}

	public boolean isIsarchievednote() {
		return isarchievednote;
	}

	public void setIsarchievednote(boolean isarchievednote) {
		this.isarchievednote = isarchievednote;
	}

	public UserRegistration getUserreg() {
		return userreg;
	}

	public void setUserreg(UserRegistration userreg) {
		this.userreg = userreg;
	}

	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "id=" + this.id + "title=" + this.title + "content=" + this.content + "createdAt=" + this.createdAt
				+ "updatedAt=" + this.updatedAt + "pinNotes=" + this.pinNotes + "archieved notes="
				+ this.isarchievednote;
	}

}