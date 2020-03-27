package com.journaldev.spring.userserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.EmpDao;
import com.journaldev.spring.model.Emp;
import com.journaldev.spring.service.Userservice;

@Service("userservice")
@Transactional(propagation=Propagation.SUPPORTS,rollbackFor=Exception.class)
public class UserServiceImple  implements Userservice
{
	@Autowired
    EmpDao empdao;
	
	
	
	@Override
	public void createuser(Emp user) {
		empdao.save(user);
		
	}

}
