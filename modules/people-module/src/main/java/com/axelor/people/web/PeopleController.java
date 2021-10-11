package com.axelor.people.web;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.axelor.inject.Beans;
import com.axelor.meta.schema.actions.ActionView;
import com.axelor.meta.schema.actions.ActionView.ActionViewBuilder;
import com.axelor.people.db.Cloths;
import com.axelor.people.db.People;
import com.axelor.people.db.repo.PeopleRepository;
import com.axelor.people.service.PeopleService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class PeopleController {
	public void cheking(ActionRequest req , ActionResponse res) {
		Context context = req.getContext();
		System.err.println(context);
//		Context parantcontext = context.getParent();
		People people = context.asType(People.class);
		System.err.println(people);
		if(people.getId()!= null) {
			people = Beans.get(PeopleRepository.class).find(people.getId());
		}
		System.err.println(people);
		
//		With the help of Beans we can call service method 
		Beans.get(PeopleService.class).validate(people);
		
//		It is used in validations
//		res.setAlert("Hello AOP");
//		res.setError("Hello AOP");
//		res.setNotify("Hello AOP");
//		res.setFlash("Hello AOP");
		
//		It used in Action Attrs
		res.setAttr("timeOfEntry", "value",LocalTime.now());
		res.setAttr("bankBalance", "readonly", people);
		res.setAttr("dateTimeDemo", "value", LocalDateTime.now());
		
//		Is used to open different view
//		ActionViewBuilder actionViewBuilder = ActionView.define("Cloths").model(Cloths.class.getName()).add("grid","cloths_grid");
//		res.setView(actionViewBuilder.map());
		
//		Other way to use view 
		res.setView("Mobile","com.axelor.people.db.Mobile","grid","self.mobileQuality = '2' ");
//		Here last one is domain filter
	}
	
}
