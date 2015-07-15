package org.kapit.peopledirectory.dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Connection {

    private DB dataBase;
    private MongoClient mongoClient;

    public Connection() {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            this.dataBase = mongo.getDB("peopledirectory");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public DB getDataBase() {
        return dataBase;
    }

    public void setDataBase(DB dataBase) {
        this.dataBase = dataBase;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }
}
