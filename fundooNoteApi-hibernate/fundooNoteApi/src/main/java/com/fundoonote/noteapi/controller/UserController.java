package com.fundoonote.noteapi.controller;

/**
 * @author:Hemanth Kumar
 * @date: 2020/04/13
 * @version:1.3
 * Purpose:> FundooNotes Api Backend-Login,registration,forgot password,reset password api with implementing with jwt for login and Jms for registration and forgot password
 **/

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import com.fasterxml.jackson.annotation.JsonView;
import com.fundoonote.noteapi.Iconstants;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.fundoonote.noteapi.model.Label;
import com.fundoonote.noteapi.model.Login;
import com.fundoonote.noteapi.model.Token;
import com.fundoonote.noteapi.model.UserLogin;
import com.fundoonote.noteapi.model.UserRegistration;
import com.fundoonote.noteapi.model.View;
import com.fundoonote.noteapi.model.YAMLConfig;
import com.fundoonote.noteapi.service.Producer;
import com.fundoonote.noteapi.service.UserService;
import com.fundoonote.noteapi.utility.SendEmail;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.fundoonote.noteapi.JmsClient;


@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	private UserService userservice;

	@Autowired
	JmsClient jsmClient;

	@Autowired
	Producer producer;

    
    @Autowired
	private JavaMailSender emailSender;
    
	
//	@Value(value = "spring.mail.username")
//	private String mailid;

	@Autowired
	private YAMLConfig myConfig;

	public static HashMap<Integer, Token> users;

	
	

	/***
	 * Define function userLogin(),to get the jwt token ,and to access the other web
	 * services by authenticating in login module.
	 * 
	 * @param User login ---->Object
	 * @return ResponseEntity<String>
	 * @throws ServletException
	 */
	@PostMapping("login")
	public ResponseEntity<UserLogin> userLogin(@RequestBody UserLogin login) {
		String respjwt = "";
		if (!(login.getUsername().equals("Test") && login.getPassword().equals("1234"))) {
			return new ResponseEntity<UserLogin>(HttpStatus.BAD_REQUEST);
		} else {
			userservice.userLogin(login);
			Map<String, Object> claims = new HashMap<String, Object>();
			claims.put("usr", login.getUsername());
			claims.put("sub", "Authentication token");
			claims.put("iss", Iconstants.ISSUER);
			claims.put("rol", "Administrator, Developer");
			claims.put("iat", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			respjwt = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, Iconstants.SECRET_KEY)
					.compact();
			System.out.println("Returning the following token to the user= " + respjwt);
			login.setJwttoken(respjwt);
		}
		return new ResponseEntity<UserLogin>(login, HttpStatus.OK);
	}

	/***
	 * Define function userRegistration(),to register the new User .
	 * 
	 * @param UserRegistration ---->Object
	 * 
	 * @return ResponseEntity<String>
	 * @throws InterruptedException
	 * 
	 */
	//@CachePut(value = "registerUsers")
	@PostMapping("RegisterUser")
	public ResponseEntity<UserRegistration> userRegistration(@RequestBody UserRegistration reg) throws InterruptedException {
		    UserRegistration res = userservice.userRegistration(reg);
			producer.sendMessageToQueue(res);
			return new ResponseEntity<UserRegistration>(res, HttpStatus.OK);
		}

	

		@PostMapping("LoginUser")
		public ResponseEntity<Login> loginUser(@RequestBody Login log) throws InterruptedException {
			List<UserRegistration> sess = userservice.findAllRegisters();
			for (UserRegistration userreg : sess) {
				System.out.println(log.getEmail());
				if (userreg.getEmail().equals(log.getEmail()) && userreg.getPassword().equals(log.getPassword())) {
					System.out.println("user exists");
					userservice.login(log);
					return new ResponseEntity<Login>(log, HttpStatus.OK);
				} else {
					System.out.println("user does not exists");
				}
			}
			return new ResponseEntity<Login>(HttpStatus.BAD_REQUEST);
		}
	
	
	
	
	/***
	 * Define function getAllUser(),to get the details of all users,who have been
	 * registered.
	 * 
	 * @param UserRegistration ---->Object
	 * 
	 * @return ResponseEntity<UserRegistration>
	 * @throws InterruptedException
	 * 
	 */

	//@Cacheable(value = "registers")
	@JsonView(View.Summary.class)
	@GetMapping("getUserList")
	public List<UserRegistration> getAllUser() {
		List<UserRegistration> list = userservice.findAllRegisters();
		StringBuilder ascendingformat = new StringBuilder();
		list.forEach(ascendingformat::append);
		System.out.println("-------------------UserDetails-------------");
		for (UserRegistration userreg : list) {
			System.out.println("=======================");
			System.out.println("FirstName:" + userreg.getFirstname());
			System.out.println("Lastname :" + userreg.getLastname());
			System.out.println("Email:" + userreg.getEmail());
			System.out.println("Password:" + userreg.getPassword());
			System.out.println("==========================");
		}
		return list;
	}
	
	/***
	 * Define function getUserById(),to get the details of user using particular id.
	 * 
	 * @param UserRegistration ---->Object
	 * 
	 * @return ResponseEntity<UserRegistration>
	 * @throws InterruptedException
	 * 
	 */
	@Cacheable(value = "users", key = "#id")
	@GetMapping("Register/{id}")
	public UserRegistration getUserById(@PathVariable("id") int id) throws InterruptedException {
		System.out.println("Fetching User with id " + id);
		UserRegistration user = userservice.findById(id);
		producer.sendMessageToQueue(user);
		return user;
	}


   
    
    
    
    
    
    
    
    

	/***
	 * Define function getPassword(),Inorder to change the password, we will create
	 * a token that is used to update the password etc. .
	 * 
	 * @param UserRegistration ---->Object
	 * 
	 * @return ResponseEntity<Token>
	 * @throws MessagingException 
	 * 
	 */
	@PostMapping("/forgotpassword")
	public ResponseEntity<Token> getPassword(@RequestBody UserRegistration reg) throws MessagingException {
		System.out.println("comming");
		Token returnvalue = new Token();
		// int userId = reg.getId();
		System.out.println("-->" + reg.getEmail());
		List<UserRegistration> sess = userservice.findAllRegisters();
		for (UserRegistration userreg : sess) {
			System.out.println("---->inside");
			if (userreg.getEmail().equals(reg.getEmail())) {
				int userId = userreg.getId();
				returnvalue.setToken(userreg.getId());
				returnvalue.setFirstname(userreg.getFirstname());
				returnvalue.setLastname(userreg.getLastname());
				returnvalue.setEmail(reg.getEmail());
				returnvalue.setPassword(userreg.getPassword());
				System.out.println("user exists");
				users = new HashMap<>();
				users.put(userId, returnvalue);
				// Create the email
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(reg.getEmail());
				mailMessage.setSubject("Complete Password Reset!");
				mailMessage.setFrom("hemanthkumarpower@gmail.com");
				mailMessage.setText("To complete the password reset process, please click here: "
						+ "http://localhost:4200/app-resetpassword/" + returnvalue.getToken());
				// Send the email
				emailSender.send(mailMessage);
				System.out.println("email successfuly sent!!");// Note:for mail to work always deactivate avast//
																// antivirus.
				return new ResponseEntity<Token>(returnvalue, HttpStatus.OK);
			} else {
				System.out.println("user doesnt exist!!");
			}
		}
		return new ResponseEntity<Token>(HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	/**
	 *
	 * Define function updatePassword(),Inorder to update the password, and to pass
	 * the token to find the particular id of user, and update the password etc.
	 * 
	 * @param studmail ---->Object
	 * 
	 * @return ResponseEntity<String>
	 * 
	 */
//	@PutMapping("updatepassword/{userId}")
//	public ResponseEntity<String> updatePassword(@PathVariable("userId") int userId, @RequestBody UserRegistration reg) {
//		Token storedDetails = users.get(userId);
//		System.out.println("-->"+userId);
//		System.out.println(storedDetails);
//		UserRegistration user=userservice.findById(userId);
//	    storedDetails.setFirstname(user.getFirstname());
//		storedDetails.setLastname(user.getLastname());
//		storedDetails.setEmail(user.getEmail());
//		storedDetails.setPassword(reg.getPassword());
//		userservice.update(userId, storedDetails);
//		producer.sendMessageToQueue(
//				"Hello User,You are successfully updated the password to this account!!" + "Thank you Have a Good day");
//		return new ResponseEntity<String>("updated", HttpStatus.OK);
//	}

	@PostMapping("updatepassword")
	public ResponseEntity<Token> updatePassword(@RequestBody UserRegistration reg) {
		System.out.println(reg.getEmail());
		System.out.println(reg.getPassword());
		String pwd = reg.getPassword();
		Token storedDetails = new Token();
		List<UserRegistration> sess = userservice.findAllRegisters();
		for (UserRegistration userreg : sess) {
			System.out.println("---->inside");
			if (userreg.getEmail().equals(reg.getEmail())) {
				storedDetails.setFirstname(userreg.getFirstname());
				storedDetails.setLastname(userreg.getLastname());
				storedDetails.setEmail(userreg.getEmail());
				storedDetails.setPassword(reg.getPassword());
				userservice.update(userreg.getId(), storedDetails);
				return new ResponseEntity<Token>(HttpStatus.OK);
			} else {
				System.out.println("user does not exists");
			}
		}
		producer.sendMessageToQueue(
				"Hello User,You are successfully updated the password to this account!!" + "Thank you Have a Good day");
		return new ResponseEntity<Token>(HttpStatus.BAD_REQUEST);
	}
	
	
	

	
	
	@GetMapping(value = "getCurrentProfile")
	public ResponseEntity<YAMLConfig> getCurrentprofiles() {
		System.out.println("Current Profile You are using!!");
		System.out.println("-------------------------");
		System.out.println("Name:" + myConfig.getName());
		System.out.println("Evironment:" + myConfig.getEnvironment());
		System.out.println("Servers:" + myConfig.getServers());
		System.out.println("url:" + myConfig.getUrl());
		System.out.println("username:" + myConfig.getNewusername());
		System.out.println("password:" + myConfig.getPassword());
		System.out.println("driverClassname:" + myConfig.getDriverclassname());
		System.out.println("Message:" + myConfig.getMessage());
		System.out.println("----------------------");
		YAMLConfig myconfig = new YAMLConfig(myConfig.getName(), myConfig.getEnvironment(), myConfig.getServers(),
				myConfig.getUrl(), myConfig.getNewusername(), myConfig.getPassword(), myConfig.getDriverclassname(),
				myConfig.getMessage());
		return new ResponseEntity<YAMLConfig>(myconfig, HttpStatus.OK);
    }

	
	
	@CacheEvict(value = "deletedUsers", allEntries = true, key = "#id")
	@DeleteMapping("Delete/{id}")
	public List<UserRegistration> deleteUserById(@PathVariable("id") int id) throws InterruptedException {
		System.out.println("Deleting User with id " + id);
		userservice.deleteById(id);
		return userservice.findAllRegisters();
	}

}

