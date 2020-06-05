package com.fundoonote.noteapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoonote.noteapi.model.Label;


@Service
public interface LabelService {

	public List<Label> getAllLabelList();

	public Label findlabelById(int id);
	
	public void deleteLabel(int id);

	public void createNewLabel(Label label, int id);

	
}
