package com.changba.live.test.nologin;

import com.changba.live.R.id;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsOtherProfile;
import com.robotium.solo.Solo;

public class NotLoginProfile extends BasicTestCase {
	

	//Œ““≥√Ê¥•∑¢µ«¬Ω≤‚ ‘

	public void testNotLoginProfile(){
		
		Solo solo=uiHelper.getSolo();
		
		solo.clickOnText("Œ“");
		solo.sleep(1000);
		solo.assertCurrentActivity(" ß∞‹",com.changba.live.activity.LoginActivity.class);	
		
		
	}
	
	
	

}
