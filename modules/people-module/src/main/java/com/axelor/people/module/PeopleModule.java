package com.axelor.people.module;

import com.axelor.app.AxelorModule;
import com.axelor.people.service.PeopleService;
import com.axelor.people.service.PeopleServiceImpl;

public class PeopleModule extends AxelorModule {
	
	@Override
	protected void configure() {
		bind(PeopleService.class).to(PeopleServiceImpl.class);
	}

}
