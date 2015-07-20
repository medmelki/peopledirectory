package org.kapit.peopledirectory.dao;

import org.kapit.peopledirectory.model.User;

import java.util.Set;

public interface UserDAO {


	public void addUser(User user)  throws Exception;

	public void removeUser(User user)  throws Exception;

	public void updateUser(User user)  throws Exception;

	public User findUser(String id) throws Exception;

	public Set<User> findAllUsers() throws Exception;

	public User findUserByUsername(String username) throws Exception;
	
}