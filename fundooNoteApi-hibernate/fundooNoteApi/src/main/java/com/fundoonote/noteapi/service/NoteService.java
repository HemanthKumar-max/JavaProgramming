package com.fundoonote.noteapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundoonote.noteapi.model.Note;
import com.fundoonote.noteapi.model.UserRegistration;

@Service
public interface NoteService {
	public List<Note> getNoteList();

	public void createNote(Note note,int id);

	public Note findNoteById(int id);

	public Note updateNote(Note note, int id);

	public void deleteNote(int id);

	public List<Note> getpinnedNoteList();

	public List<Note> getArchieveNoteList();

	

	
	
	


}
