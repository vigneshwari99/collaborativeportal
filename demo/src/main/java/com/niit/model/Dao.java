package com.niit.model;
/*
 * DAO for CRUD.
 * */

import java.util.List;

public interface Dao {

	/*
	 * Methods for Create.
	 * */
	public boolean save(Object object);
	public boolean saveOrUpdate(Object object);
	public boolean saveAndGetGenVal(Object object);
	
	/*
	 * Methods for Retrive.
	 * */
	public Object getByName(String name);
	public Object getById(int id);
	public List<?> getList();
	
	/*
	 * Methods for Update.
	 * */
	public boolean update(Object object);
	
	/*
	 * Methods for Delete.
	 * */
	public boolean remove(Object object);
	public boolean disable(Object object);
	
}
