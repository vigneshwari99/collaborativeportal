package com.niit.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.pojo.Register;
@Transactional
@Repository("registerDao")

public class RegisterDao implements Dao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean save(Object object) {
		Register register = (Register) object;
		try {
			Session session = sessionFactory.openSession();
			session.save(register);
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean saveOrUpdate(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveAndGetGenVal(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<?> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean disable(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

}
