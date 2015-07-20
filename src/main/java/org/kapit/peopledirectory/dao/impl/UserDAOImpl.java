package org.kapit.peopledirectory.dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.kapit.peopledirectory.dao.Connection;
import org.kapit.peopledirectory.dao.UserDAO;
import org.kapit.peopledirectory.exceptions.DAOException;
import org.kapit.peopledirectory.model.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UserDAOImpl implements UserDAO {

    private Connection connection = new Connection();
    private DBCollection collection = connection.getDataBase().getCollection("user");


    @Override
    public void addUser(User user) throws DAOException {

        DBObject userDB = new BasicDBObject("_id", user.getId());
        userDB.put("username", user.getUsername());
        userDB.put("password", user.getPassword());

        collection.save(userDB);
    }

    @Override
    public void removeUser(User user) throws DAOException {

        DBObject query = new BasicDBObject("_id", user.getId());
        collection.remove(query);
    }

    @Override
    public void updateUser(User user) throws DAOException {

        DBObject userDB = new BasicDBObject("_id", user.getId());
        userDB.put("username", user.getUsername());
        userDB.put("password", user.getPassword());
        DBObject query = new BasicDBObject("_id", user.getId());

        collection.update(query, userDB);
    }

    @Override
    public User findUser(String id) throws DAOException {

        DBObject query = new BasicDBObject("_id", id);
        DBObject userDB = collection.findOne(query);

        User user = new User();

        String id_user = userDB.get("_id").toString();
        user.setId(id_user);

        String nom_user = userDB.get("username").toString();
        user.setUsername(nom_user);

        String password_user = userDB.get("password").toString();
        user.setPassword(password_user);

        return user;

    }

    @Override
    public Set<User> findAllUsers() throws DAOException {

        Iterator<DBObject> iterator = collection.find().iterator();
        Set<User> users = new HashSet<>();
        while (iterator.hasNext()) {
            BasicDBObject userDB = (BasicDBObject) iterator.next();
            User user = new User();
            user.setId(userDB.get("_id").toString());
            user.setUsername(userDB.get("username").toString());
            user.setPassword(userDB.get("password").toString());
            users.add(user);
        }
        return users;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    public DBCollection getCollection() {
        return collection;
    }

    public void setCollection(DBCollection collection) {
        this.collection = collection;
    }

    @Override
    public User findUserByUsername(String username) throws DAOException {

        DBObject query = new BasicDBObject("username", username);
        DBObject userDB = collection.findOne(query);
        if (userDB == null) {

            return null;
        }
        User user = new User();
        String id_user = userDB.get("_id").toString();
        user.setId(id_user);
        String nom_user = userDB.get("username").toString();
        user.setUsername(nom_user);
        String password_user = userDB.get("password").toString();
        user.setPassword(password_user);

        return user;
    }


}