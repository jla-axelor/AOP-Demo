package com.axelor.mobile.repo;

import java.util.Map;

import com.axelor.mobile.db.Mobile;
import com.axelor.mobile.db.repo.MobileRepository;

public class MobileRepo extends MobileRepository {

	@Override
	public Map<String, Object> populate(Map<String, Object> json, Map<String, Object> context) {
		if(!context.containsKey("json-enhance")) {
			return json;
		}
		else {
			Long id =(Long) json.get("id");
			Mobile mobile = find(id);
			json.put("coverset", mobile.getCoverset().iterator().next());
			return json;
		}
	}
}
