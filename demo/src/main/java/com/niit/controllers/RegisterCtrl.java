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


@RestController
public class RegisterCtrl {
	@Autowired 
	private Dao registerDao;
	@RequestMapping(value = {"/"})
	public String showHomePage() {
		return "index";
	}
	
	@RequestMapping(value = "/regact", method = RequestMethod.POST)
	public ResponseEntity<Register> register(@RequestBody Register register){
		System.out.println();
		boolean status = registerDao.save(register);
		if(status) {
		return new ResponseEntity<Register>(register,HttpStatus.OK);
	}
		else {
			return new ResponseEntity<Register>(register,HttpStatus.NOT_FOUND);
	}
	}

}
