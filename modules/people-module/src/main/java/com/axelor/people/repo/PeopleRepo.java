package com.axelor.people.repo;

import java.util.List;
import java.util.Map;

import com.axelor.people.db.Cloths;
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
			List<Cloths> cloths = people.getClothsList();
			Integer sum =0;
			for(Cloths c : cloths) {
				sum += c.getCprice();
			}
			
//			json.put("clothsList", people.getClothsList().get(0));
			json.put("clothsList",sum.toString());//it will display price sum in clothList section 
			json.put("cloth",sum.toString());
			json.put("hasImage",people.getImage() != null);
//			System.err.println(json.get("clothsList"));
			return json;
		}
	}
}
