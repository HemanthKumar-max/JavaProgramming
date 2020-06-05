package com.fundoonote.noteapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.fundoonote.noteapi.model.Label;
import com.fundoonote.noteapi.model.Note;
import com.fundoonote.noteapi.model.View;
import com.fundoonote.noteapi.service.LabelService;

@RestController
public class LabelController {

	@Autowired
	private LabelService labelservice;

	@PostMapping("createLabel/{id}")
	public ResponseEntity<String> createNewLabel(@RequestBody Label label, UriComponentsBuilder ucBuilder,
			@PathVariable int id) {
		labelservice.createNewLabel(label, id);
		return new ResponseEntity<String>("Created new label", HttpStatus.CREATED);
	}

	@JsonView(View.Summary.class)
	@GetMapping("getLabelList")
	public List<Label> getlabelList() {
		List<Label> list = labelservice.getAllLabelList();
	  return list;
	}

	@GetMapping("getLabelList/{id}")
	public ResponseEntity<Label> getLabelById(@PathVariable("id") int id) {
		System.out.println("Fetching label with id " + id);
		Label label = labelservice.findlabelById(id);
		if (label == null) {
			return new ResponseEntity<Label>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Label>(label, HttpStatus.OK);
	}

	@DeleteMapping("getLabelList/delete/{id}")
	public ResponseEntity<String> deleteNote(@PathVariable("id") int id) {
		Label label = labelservice.findlabelById(id);
		if (label == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		labelservice.deleteLabel(id);
		return new ResponseEntity<String>("deleted!!!", HttpStatus.ACCEPTED);
	}

}
