package com.fundoonote.noteapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fundoonote.noteapi.model.Collaborator;

@Component
@Transactional
public class CollaborateDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void adddnewCollaborator(Collaborator collaborator) {
		Session session = sessionFactory.getCurrentSession();
		session.save(collaborator);

	}

}
