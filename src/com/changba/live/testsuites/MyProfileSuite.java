package com.changba.live.testsuites;

import junit.framework.TestSuite;

import com.changba.live.test.nologin.NotLoginLive;
import com.changba.live.test.nologin.NotLoginProfile;
import com.changba.live.test.otherprofile.OtherProfile;
import com.changba.live.testcases.live.AudienceList;
import com.changba.live.testcases.live.Gift;
import com.changba.live.testcases.live.KickoffUser;
import com.changba.live.testcases.live.PrivateChat;
import com.changba.live.testcases.live.LiveSystem;
import com.changba.live.testcases.live.PublicChat;
import com.changba.live.testcases.live.RoomInfo;
import com.changba.live.testcases.profile.MyCollections;
import com.changba.live.testcases.profile.MyProfileShow;
import com.changba.live.testcases.setting.FeedBack;
import com.changba.live.testcases.setting.InfoPush;
import com.changba.live.testcases.setting.SettingShow;

public class MyProfileSuite {
	public static TestSuite getTestSuite(){
		TestSuite testSuite=new TestSuite();
		//testSuite.addTestSuite(MyProfileShow.class);
		testSuite.addTestSuite((NotLoginLive.class));
		//testSuite.addTest(TestSuite.createTest(AudienceList.class, "testList"));
		return testSuite;
	}
}