package org.kapit.peopledirectory.dao;

import org.kapit.peopledirectory.exceptions.DAOException;
import org.kapit.peopledirectory.model.User;

import java.util.Set;

public interface UserDAO {


	public void addUser(User user)  throws DAOException;

	public void removeUser(User user)  throws DAOException;

	public void updateUser(User user)  throws DAOException;

	public User findUser(String id) throws DAOException;

	public Set<User> findAllUsers() throws DAOException;

	public User findUserByUsername(String username) throws DAOException;
	
}