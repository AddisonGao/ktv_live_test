package com.changba.live.test.nologin;

import com.changba.live.R.id;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsOtherProfile;
import com.robotium.solo.Solo;

public class NotLoginProfile extends BasicTestCase {
	

	//��ҳ�津����½����

	public void testNotLoginProfile(){
		
		Solo solo=uiHelper.getSolo();
		
		solo.clickOnText("��");
		solo.sleep(1000);
		solo.assertCurrentActivity("ʧ��",com.changba.live.activity.LoginActivity.class);	
		
		
	}
	
	
	

}
