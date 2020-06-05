package com.fundoonote.noteapi.service;




import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fundoonote.noteapi.model.Login;
import com.fundoonote.noteapi.model.Token;
import com.fundoonote.noteapi.model.UserLogin;
import com.fundoonote.noteapi.model.UserRegistration;

@Service
public interface UserService {
public void userLogin(UserLogin login);
public UserRegistration userRegistration(UserRegistration registration);


public  UserRegistration findById(int id);
public List<UserRegistration> findAllRegisters();


public UserRegistration update(int userId, Token storedDetails);
public void deleteById(int id);
public Map<String, Object> findByIdElastic(String id);
public void login(Login log);
public UserRegistration findByemail(String email);







}
