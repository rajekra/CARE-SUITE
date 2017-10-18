package com.icare.dataprocessing.service_examples;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.bson.BSONObject;
import org.bson.BasicBSONEncoder;
import org.bson.Document;

import com.ecams.claim.bo.ClaimHeader;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.icare.dataprocessing.dto.Class;
import com.icare.dataprocessing.dto.Student;
import com.icare.dataprocessing.util.JsonUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class ClassStudent {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		MongoDatabase database = mongoClient.getDatabase("icare");
		MongoCollection<BasicDBObject> collection = database.getCollection("class",BasicDBObject.class);
		BasicDBObject dbc = new BasicDBObject();
		
		Student stu = new Student();
		Class clazz = new Class();
		stu.setGrade("A");
		stu.setName("Kaniskar");
		clazz.setName("Kindergarden");
		clazz.setStidentId(new BigDecimal(12));
		
		List<Student> stus = new ArrayList<Student>();
		stus.add(stu);
		clazz.setStudents(stus);
		
		String headerString = JsonUtil.translateBoToJsonString(clazz);
		System.out.println("My String:" + headerString);
		
		BSONObject bson = (BSONObject)com.mongodb.util.JSON.parse(headerString);
		dbc.putAll(bson);
		collection.insertOne(dbc);
	}

}
