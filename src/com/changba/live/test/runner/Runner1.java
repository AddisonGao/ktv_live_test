package com.changba.live.test.runner;

import com.changba.live.testsuites.MyProfileSuite;
import junit.framework.TestSuite;
import android.test.InstrumentationTestRunner;

public class Runner1 extends CommonRunner {

	@Override
	public TestSuite getAllTests() {
		// TODO Auto-generated method stub
		TestSuite suite=new TestSuite();
		suite.addTest(MyProfileSuite.getTestSuite());
		return suite;
	}
}
