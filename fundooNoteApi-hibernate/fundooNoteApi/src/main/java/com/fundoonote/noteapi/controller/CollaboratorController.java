package com.fundoonote.noteapi.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fundoonote.noteapi.model.Collaborator;
import com.fundoonote.noteapi.model.UserRegistration;
import com.fundoonote.noteapi.service.CollaborateService;
import com.fundoonote.noteapi.service.UserService;

@RestController
public class CollaboratorController {
	@Autowired
	private UserService userservice;

	@Autowired
	private CollaborateService colservice;

	@PostMapping("CollaborateUser")
	public ResponseEntity<String> userCollaborate(@RequestBody Collaborator col)
			throws IOException, JSONException, InterruptedException {
		if (col.getEmail().isEmpty())
			return new ResponseEntity<String>("Please fill the email and password", HttpStatus.BAD_REQUEST);
		else {
			String email = col.getEmail();
			System.out.println("email" + email);
			List<UserRegistration> sess = userservice.findAllRegisters();
			for (UserRegistration userreg : sess) {
				System.out.println("---->inside");
				if (userreg.getEmail().equals(email)) {
					Scanner sc = new Scanner(System.in);
					System.out.println("please enter another email id!!");
					String txt = sc.next();
					while (!txt.equals(email)) {
						txt = sc.next();
					}

					colservice.addCollaborator(col);
				}
			}

			return new ResponseEntity<String>("successfully collaborated!!", HttpStatus.CREATED);
		}
	}
}