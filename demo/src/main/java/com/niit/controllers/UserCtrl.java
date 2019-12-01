package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.niit.model.Dao;
import com.niit.pojo.Register;
import com.niit.pojo.User;

/**
 * Servlet implementation class FormController
 */
@RestController
public class UserCtrl {

	@Autowired
	private Dao userDao;

	

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ResponseEntity<Register> test(@RequestBody User user) {
		System.out.println();
		Object object = userDao.getByName(user.getEmail());
		if (!object.equals(false)) {
			Register tempUser = (Register) object;
			if(tempUser.getPassword().equals(user.getPassword())) {
				return new ResponseEntity<Register>(tempUser, HttpStatus.OK);
			}else {
				return new ResponseEntity<Register>(tempUser, HttpStatus.LOCKED);
			}
			
		} else {
			return new ResponseEntity<Register>(new Register(), HttpStatus.NOT_FOUND);
		}
	}

}
