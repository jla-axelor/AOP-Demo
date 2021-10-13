package com.axelor.people.module;

import com.axelor.app.AxelorModule;
import com.axelor.people.db.repo.PeopleRepository;
import com.axelor.people.repo.PeopleRepo;
import com.axelor.people.service.PeopleService;
import com.axelor.people.service.PeopleServiceImpl;

public class PeopleModule extends AxelorModule {
	
	@Override
	protected void configure() {
		bind(PeopleService.class).to(PeopleServiceImpl.class);
		bind(PeopleRepository.class).to(PeopleRepo.class);
	}

}
