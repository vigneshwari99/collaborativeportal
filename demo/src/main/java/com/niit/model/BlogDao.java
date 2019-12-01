package com.niit.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.pojo.Blog;

@Transactional
@Repository("blogDao")
public class BlogDao implements Dao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean save(Object object) {
		Blog blog = (Blog) object;
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(blog);
			transaction.commit();
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

	public Blog getById(int id) {
		
		Session session = sessionFactory.openSession();
		Blog blog = session.get(Blog.class, id);
		session.close();
		
		return blog;
	}

	public List<Blog> getList() {
		List<Blog> blogs = null;
		try {
			
			Session session = sessionFactory.openSession();
			blogs = session.createQuery("FROM Blog",Blog.class).getResultList();
			session.close();
			return blogs;
			
		} catch (Exception e) {
			return new ArrayList<Blog>();
		}
	}

	public boolean update(Object object) {
		Blog blog = (Blog) object;
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(blog);
			transaction.commit();
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
