package com.fundoonote.noteapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundoonote.noteapi.dao.LabelDao;
import com.fundoonote.noteapi.model.Label;

@Service
public class LabelServiceImple implements LabelService
{
	@Autowired
	private   LabelDao labelDAO;

	@Override
	public List<Label> getAllLabelList() {
		return labelDAO.getlabelList();
	}

	@Override
	public Label findlabelById(int id) {
		return labelDAO.findById(id);
		
	}

	

	@Override
	public void deleteLabel(int id) {
		labelDAO.delete(id);
		
	}

	@Override
	public void createNewLabel(Label label, int id) {
		labelDAO.createLabel(label,id);
		
	}
		
		
	}
	
