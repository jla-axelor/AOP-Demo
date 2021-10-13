package com.axelor.people.web;

import com.axelor.people.db.Mobile;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class MobileController {
	public void greet(ActionRequest req , ActionResponse res) {
		Context context = req.getContext();
		Mobile mobile = context.asType(Mobile.class);
		String message;
		if(mobile.getPrice() < 10000) {
			message = "This price is not valid you should buy Mobile least 10K";
			res.setError(message);
		}
		else {
			
			message = String.format("Hello '%s' !",mobile.getName());
			res.setFlash(message);
		}
	}
	
}
