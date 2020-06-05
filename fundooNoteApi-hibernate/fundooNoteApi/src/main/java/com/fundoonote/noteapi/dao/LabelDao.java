package com.fundoonote.noteapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fundoonote.noteapi.model.Label;
import com.fundoonote.noteapi.model.Note;
import com.fundoonote.noteapi.model.UserRegistration;

@Component
@Transactional
public class LabelDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private NoteDao dao;

	@SuppressWarnings("unchecked")
	public java.util.List<Label> getlabelList() {
		return sessionFactory.getCurrentSession().createCriteria(Label.class).list();
	}

	public Label findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Label label = (Label) session.get(Label.class, id);
		return label;
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Label label = findById(id);
		session.delete(label);
	}

	public void createLabel(Label label, int id) {
		Session session = sessionFactory.getCurrentSession();
		Note note = dao.findById(id);
		label.setNote(note);
		session.save(label);
	}

}
