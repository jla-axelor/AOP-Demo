package com.axelor.people.service;

import com.axelor.people.db.People;

public class PeopleServiceImpl implements PeopleService {

	@Override
	public void validate(People people) {
		System.err.println("people service Impl" + people);
		
	}
	

}
