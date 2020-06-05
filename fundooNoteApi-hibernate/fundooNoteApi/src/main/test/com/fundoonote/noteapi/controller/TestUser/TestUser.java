//package com.fundoonote.noteapi.controller.TestUser;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.Test;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import com.fundoonote.noteapi.controller.UserController;
//import com.fundoonote.noteapi.dao.UserDao;
//import com.fundoonote.noteapi.model.Note;
//import com.fundoonote.noteapi.model.UserRegistration;
//import com.fundoonote.noteapi.model.Users;
//import com.fundoonote.noteapi.service.UserService;
//import com.fundoonote.noteapi.service.UserServiceImple;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TestUser {
//	
//	@Autowired
//	private UserServiceImple userservice;
//	
//	@MockBean
//	private UserDao dao;
//	
//	
//	private Set<Note> notes;
//	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void testGetAllUser()
//	{
//		when(dao.findAllRegisters()).thenReturn(Stream.of(new UserRegistration(1,"hemanth","kumar","1234","hemanth@gmail.com",notes)).collect(Collectors.toList()));
//		assertEquals(1,userservice.findAllRegisters().size());
//	}
//	
//	
//	
//	  
//
//		
//		
//		
//}
//
//	
//	
//
