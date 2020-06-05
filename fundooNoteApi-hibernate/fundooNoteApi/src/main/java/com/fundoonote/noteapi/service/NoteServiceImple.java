package com.fundoonote.noteapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundoonote.noteapi.dao.NoteDao;
import com.fundoonote.noteapi.model.Note;
import com.fundoonote.noteapi.model.UserRegistration;

@Service
public class NoteServiceImple implements NoteService {
	@Autowired
	private NoteDao noteDAO;

	@Override
	public List<Note> getNoteList() {
		return noteDAO.getNoteList();

	}

	@Override
	public void createNote(Note note,int id) {
		noteDAO.addNewNote(note,id);

	}

	@Override
	public Note findNoteById(int id) {
		return noteDAO.findById(id);

	}

	@Override
	public Note updateNote(Note note, int id) {
		return noteDAO.update(note, id);

	}

	@Override
	public void deleteNote(int id) {
		noteDAO.delete(id);

	}

	@Override
	public List<Note> getpinnedNoteList() {
		return noteDAO.getpinnedNoteList();

	}

	@Override
	public List<Note> getArchieveNoteList() {
		return noteDAO.getArchieveNoteList();
	}
}

	
