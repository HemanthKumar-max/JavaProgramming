package com.fundoonote.noteapi.dao;

import java.util.List;

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
public class NoteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserDao dao;

	@SuppressWarnings("unchecked")
	public java.util.List<Note> getNoteList() {
		return sessionFactory.getCurrentSession().createSQLQuery("select * from note;").addEntity(Note.class).list();
	}

	@SuppressWarnings("unchecked")
	public void addNewNote(Note newnote, int id) {
		Session session = sessionFactory.getCurrentSession();
		UserRegistration user = dao.findById(id);
		newnote.setUserreg(user);
		session.save(newnote);

	}

	public Note findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Note note = (Note) session.get(Note.class, id);
		return note;
	}

	public Note update(Note val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Note note = (Note) session.get(Note.class, id);
		note.setId(val.getId());
		note.setTitle(val.getTitle());
		note.setContent(val.getContent());
		note.setCreatedAt(val.getCreatedAt());
		note.setUpdatedAt(val.getUpdatedAt());
		session.update(note);
		return note;
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Note note = (Note) session.get(Note.class, id);
		session.delete(note);
	}

	@SuppressWarnings("unchecked")
	public List<Note> getpinnedNoteList() {
		return sessionFactory.getCurrentSession().createSQLQuery("select * from note where pinNotes=true;")
				.addEntity(Note.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Note> getArchieveNoteList() {
		return sessionFactory.getCurrentSession().createSQLQuery("select * from note where isarchievednote=true;")
				.addEntity(Note.class).list();
	}

//	@SuppressWarnings("unchecked")
//	public void addNewNoteLabel(Note newnote) {
//		Session session = sessionFactory.getCurrentSession();
//		session.save(newnote);
//		Label labelobj=new Label();
//		labelobj.setNote(newnote);
//		session.save(labelobj);
//		System.out.println("saved to database!!");
//		
//
//	}
//	

}