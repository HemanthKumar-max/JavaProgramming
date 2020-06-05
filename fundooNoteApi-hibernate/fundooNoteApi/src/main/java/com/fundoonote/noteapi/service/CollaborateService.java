package com.fundoonote.noteapi.service;

import org.springframework.stereotype.Service;

import com.fundoonote.noteapi.model.Collaborator;
@Service
public interface CollaborateService {

	
	public void addCollaborator(Collaborator collaborator);

}
