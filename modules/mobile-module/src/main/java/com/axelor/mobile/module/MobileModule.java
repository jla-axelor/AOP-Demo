package com.axelor.mobile.module;

import com.axelor.app.AxelorModule;
import com.axelor.mobile.db.repo.MobileRepository;
import com.axelor.mobile.repo.MobileRepo;

public class MobileModule extends AxelorModule {
	@Override
	protected void configure() {
		bind(MobileRepository.class).to(MobileRepo.class);
	}
}
