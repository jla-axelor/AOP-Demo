package com.axelor.mobile.webservice;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.axelor.mobile.db.Mobile;
import com.axelor.mobile.db.repo.MobileRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;


@Path("/mobile")
public class MobileService {
	@Inject
	MobileRepository mobileRepo;
	
	JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
	
	//get all mobile data
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})//client only receives json and xml format data 
	public JsonNode getAllMobile() {
		ObjectNode mainNode = jsonFactory.objectNode();
		List<Mobile> mobileList = mobileRepo.all().fetch();
		
		ArrayNode arrayNode = jsonFactory.arrayNode();
		
		for(Mobile m : mobileList) {
			ObjectNode mobileNode = jsonFactory.objectNode();
			mobileNode.put("id", m.getId());
			mobileNode.put("name", m.getName());
			mobileNode.put("price", m.getPrice());
			mobileNode.put("Owner", m.getPeople().getPeopleName());
			
			//mobileNode.putPOJO("myMobile",m); <-- with the help of putPOJO we can get our mobile object with all details
			
			arrayNode.add(mobileNode);
		}
		mainNode.put("status", 0);
		mainNode.set("data", arrayNode);
		return mainNode;
	}
	
	//get mobile data by id
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public JsonNode getMobileById(@PathParam("id") Long id ) {
		ObjectNode mainNode = jsonFactory.objectNode();
		try {
		Mobile mobile = mobileRepo.find(id);
		ArrayNode arryNode = jsonFactory.arrayNode();
		ObjectNode mobileNode = jsonFactory.objectNode();
		mobileNode.put("name", mobile.getName());
		mobileNode.put("price", mobile.getPrice());
		mobileNode.put("people", mobile.getPeople().getPeopleName());
		
		arryNode.add(mobileNode);
		
		mainNode.put("status", id);
		mainNode.set("data", arryNode);
		return mainNode;
		} catch (Exception e) {
			mainNode.put("status", 0);
			return mainNode;
		}
	}
}
