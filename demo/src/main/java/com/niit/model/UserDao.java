package com.niit.model;

import java.util.List;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.pojo.Register;
import com.niit.pojo.User;

@Transactional
@Repository("userDao")
public class UserDao implements Dao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean save(Object object) {
		User user = (User) object;
		
		
		try {
			Session session = sessionFactory.openSession();
			session.save(user);
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean saveOrUpdate(Object object) {
		User user = (User) object;
		try {
			Session session = sessionFactory.openSession();
			session.saveOrUpdate(user);
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean saveAndGetGenVal(Object object) {
		User user = (User) object;

		try {
			Session session = sessionFactory.openSession();
			session.save(user);
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Object getByName(String email) {

		try {
			Session session = sessionFactory.openSession();

			Register register = session.createQuery("FROM Register WHERE email = '" + email + "'", Register.class)
					.getSingleResult();

			return register;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

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
		User user = (User) object;
		try {
			Session session = sessionFactory.openSession();
			session.update(user);
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

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
