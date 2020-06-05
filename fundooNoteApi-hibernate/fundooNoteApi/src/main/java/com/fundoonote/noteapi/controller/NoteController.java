package com.fundoonote.noteapi.controller;

/**
 * @author:Hemanth Kumar
 * @date: 2020/04/13
 * @version:1.3
 * Purpose:> FundooNotes Api Backend-create,delete,update,findAll,FindById,deletebyId,sorting acc to names of notes. 
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.fundoonote.noteapi.model.MailMail;
import com.fundoonote.noteapi.model.Note;
import com.fundoonote.noteapi.model.UserRegistration;
import com.fundoonote.noteapi.model.View;
import com.fundoonote.noteapi.service.NoteService;
import com.fundoonote.noteapi.service.Producer;
import com.fundoonote.noteapi.utility.SendEmail;

@RestController
public class NoteController {

	@Autowired
	private NoteService noteservice;

	@Autowired
	Producer producer;

	@Autowired
	SendEmail sendmail;

	@Value(value = "spring.mail.username")
	private String mailid;

	
	
	
	
	
	/***
	 * Define function getNotelist(),to get the details of all notes,which has been
	 * created.
	 * 
	 * @param Note ---->Object
	 * 
	 * @return list<Note>
	 * 
	 */

	@JsonView(View.Summary.class)
	@GetMapping("getNoteList")
	public List<Note> getNoteList() {
		List<Note> list = noteservice.getNoteList();
		StringBuilder ascendingformat = new StringBuilder();
		list.forEach(ascendingformat::append);
		System.out.println("-------------------NoteDetails-------------");
		for (Note note : list) {
			System.out.println("=======================");
			System.out.println("Title:" + note.getTitle());
			System.out.println("content :" + note.getContent());
			System.out.println("CreatedAt:" + note.getCreatedAt());
			System.out.println("updatedAt:" + note.getUpdatedAt());
			System.out.println("==========================");
		}
		return list;
		
	}

	/***
	 * Define function createNote(),to create a new note by adding details to
	 * notes,And Saved to the database.
	 * 
	 * @param Note ---->Object
	 * 
	 * @return ResponseEntity<String>
	 * 
	 */

	@PostMapping("addNote/{id}")
	public ResponseEntity<String> createNote(@RequestBody Note note, UriComponentsBuilder ucBuilder,
			@PathVariable String id) {
		int newId=Integer.parseInt(id);
		System.out.println(id);
        System.out.println(note.getContent());
		noteservice.createNote(note, newId);
		return new ResponseEntity<String>("Created new note", HttpStatus.CREATED);
	}

	/***
	 * Define function getNoteById(),to find a particular note by using id ,from the
	 * database.
	 * 
	 * @param Note ---->Object
	 * 
	 * @return ResponseEntity<Note>
	 * 
	 */
	@GetMapping("getNoteList/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable("id") int id) {
		System.out.println("Fetching note with id " + id);
		Note note = noteservice.findNoteById(id);
		if (note == null) {
			return new ResponseEntity<Note>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Note>(note, HttpStatus.OK);
	}

	/***
	 * Define function updateNote(),to update the note.
	 * 
	 * @param Note ---->Object
	 * 
	 * @return ResponseEntity<String>
	 * 
	 */
	@PutMapping("getNoteList/update")
	public ResponseEntity<String> updateNote(@RequestBody Note currentUser) {
		Note user = noteservice.findNoteById(currentUser.getId());
		if (user == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		noteservice.updateNote(currentUser, currentUser.getId());
		return new ResponseEntity<String>("successfully updated", HttpStatus.OK);
	}

	/***
	 * Define function deleteNote(),to delete a particular note using id ,from the
	 * database.
	 * 
	 * @param Note ---->Object
	 * 
	 * @return ResponseEntity<String>
	 * 
	 */
	@DeleteMapping("getNoteList/delete/{id}")
	public ResponseEntity<String> deleteNote(@PathVariable("id") int id) {
		Note note = noteservice.findNoteById(id);
		if (note == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		noteservice.deleteNote(id);
		return new ResponseEntity<String>("deleted!!!", HttpStatus.ACCEPTED);
	}

	/***
	 * Define function getNoteAcendingOrder(),to get the notes list that has been
	 * arranged in ascending order.
	 * 
	 * @param Note ---->Object
	 * 
	 * @return ResponseEntity<String>
	 * 
	 */
	@GetMapping("getNoteList/Ascending")
	public ResponseEntity<ArrayList<String>> getNoteAcendingOrder() {
		List<Note> notelist = noteservice.getNoteList();
		ArrayList<String> al = new ArrayList<>();
		ArrayList<String> al2 = new ArrayList<>();

		System.out.println(notelist);
		for (Note note : notelist) {
			al.add("Title=" + note.getTitle() + "Content=" + note.getContent() + "createdAt=" + note.getCreatedAt()
					+ "updatedAt=" + note.getUpdatedAt());
		}
		String[] strArray = al.toArray(new String[al.size()]);
		System.out.println(Arrays.toString(strArray));
		System.out.println("--sorting according to Title/Name");
		System.out.println("==========details========");
		Arrays.parallelSort(strArray);
		Arrays.stream(strArray).forEach(n -> System.out.println("n is" + al2.add(n)));
		System.out.println(al2);
		return new ResponseEntity<ArrayList<String>>(al2, HttpStatus.ACCEPTED);

	}

	@JsonView(View.Summary.class)
	@GetMapping("getpinnedNoteList")
	public java.util.List<Note> getPinnedNoteList() {
		return noteservice.getpinnedNoteList();
	}

	@JsonView(View.Summary.class)
	@GetMapping("getArchieveNoteList")
	public java.util.List<Note> getArchieveNoteList() {
		return noteservice.getArchieveNoteList();
	}

}
