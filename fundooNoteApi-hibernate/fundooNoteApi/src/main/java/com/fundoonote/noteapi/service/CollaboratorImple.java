package com.fundoonote.noteapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundoonote.noteapi.dao.CollaborateDao;
import com.fundoonote.noteapi.model.Collaborator;


@Service
public class CollaboratorImple  implements CollaborateService
{
	
	@Autowired
	private CollaborateDao dao;




	@Override
	public void addCollaborator(Collaborator collaborator) {
		  dao.adddnewCollaborator(collaborator);
		
	}

}
