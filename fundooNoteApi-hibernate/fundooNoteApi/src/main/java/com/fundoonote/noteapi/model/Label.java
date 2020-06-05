package com.fundoonote.noteapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "label")
public class Label implements Serializable {

	private static final long serialVersionUID = 7156526077883281623L;

	@JsonView(View.Summary.class)
	@Id
	@GeneratedValue
	private int id;

	@JsonView(View.Summary.class)
	@Column
	private String labelName;

	@JsonView(View.Summary.class)
	@Column
	private String labelColor;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	@JsonView(View.Summary.class)
	private Note note;

	public Label(int id, String labelName, String labelColor, Note note) {
		super();
		this.id = id;
		this.labelName = labelName;
		this.labelColor = labelColor;
		this.note = note;
	}

	public Label() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelColor() {
		return labelColor;
	}

	public void setLabelColor(String labelColor) {
		this.labelColor = labelColor;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
