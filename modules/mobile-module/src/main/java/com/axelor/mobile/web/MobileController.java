package com.axelor.mobile.web;

import com.axelor.mobile.db.Mobile;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Context;

public class MobileController {
	public void greetName(ActionRequest req , ActionResponse res) {
		Context context = req.getContext();
		Mobile mobile = context.asType(Mobile.class);
		res.setNotify("Hello , Wolcome: " + mobile.getName());
	}
}
