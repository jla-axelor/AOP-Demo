package com.axelor.people.repo;

import java.util.Map;

import com.axelor.people.db.People;
import com.axelor.people.db.repo.PeopleRepository;
public class PeopleRepo extends PeopleRepository  {
	@Override
	public Map<String, Object> populate(Map<String, Object> json, Map<String, Object> context) {
		if (!context.containsKey("json-enhance")) {
			return json;
		}
		else {
			Long id = (Long) json.get("id");
			People people = find(id);
//			System.err.println(people);
//			System.err.println("-----------------------------");
			json.put("clothsList", people.getClothsList().get(0));
			json.put("hasImage",people.getImage() != null);
//			System.err.println(json.get("clothsList"));
			return json;
		}
	}
}
