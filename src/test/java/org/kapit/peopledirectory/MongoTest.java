package org.kapit.peopledirectory;

import java.net.UnknownHostException;

import org.junit.Test;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoTest {

	@Test
	public void testMongo() {
		try {
			MongoClient mango = new MongoClient("localhost", 27017);
			
			DB db = mango.getDB("peopledirectory");
			
			@SuppressWarnings("unused")
			DBCollection testTable = db.getCollection("test");
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
	}
	
	
}