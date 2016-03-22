package com.changba.live.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.changba.live.activity.Welcome;
import com.robotium.solo.Solo;
import com.sina.weibo.sdk.utils.Util;

import android.os.PowerManager.WakeLock;
import android.test.ActivityInstrumentationTestCase2;

import com.changba.utils.ChangbaConstants;
import com.changba.live.test.utils.*;
/**
 * 抽象父类，供用例继承，完成一些手机解锁唤醒等操作
 * @author tv
 *
 */
public class BasicTestCase extends ActivityInstrumentationTestCase2<Welcome> {

	private Solo solo;
	private WakeLock wakeScreenObject=null;
	protected UIHelper uiHelper=null;
	public BasicTestCase() {
		super(Welcome.class);
	}

	/**
	 * 复写setUp()，捕获异常
	 * @throws Exception
	 */
	@Before
	protected void setUp() throws Exception {
		try{
			super.setUp();
			init();
		}catch(Throwable tr) {
			solo.takeScreenshot(this.getClass().getSimpleName());
			throw new SetUpException(tr);
		}
	}

	/**
	 * 复写tearDown,进行异常捕获，截图处理
	 * 
	 * @throws Exception
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		try {
			if (wakeScreenObject != null) {
				wakeScreenObject.release();
				wakeScreenObject = null;
			}
			solo.finishOpenedActivities();
			uiHelper = null;
			super.tearDown();
		} catch (Throwable th) {
			solo.takeScreenshot(this.getClass().getSimpleName());
			throw new TearDownException(th);
		}
	}
	
	public void init()
	{
		solo=new Solo(getInstrumentation(), getActivity());
		uiHelper=new UIHelper(solo);
		// 唤醒设备
		if (wakeScreenObject == null) {
			wakeScreenObject = com.changba.live.test.utils.Util.wakeScreen(this);
		}
		// 解锁
		com.changba.live.test.utils.Util.unlock(getInstrumentation());
		// 连接网络
		NetworkUtil.setAirplaneModeOffAndNetworkOn(getInstrumentation().getTargetContext());
	}
	
	/**
	 * 在setUp、runTest、tearDown抛出了自定义异常，这里统一进行捕获然后，确保tearDown方法被执行，用来释放资源
	 * 
	 * @throws Throwable
	 */
	@Override
	public void runBare() throws Throwable {
		try {
			super.runBare();
		} catch (SetUpException smte) {
			this.tearDown();
			throw smte;
		} catch (RunTestException rte) {
			this.tearDown();
			throw rte;
		} catch (TearDownException tde) {
			this.tearDown();
			throw tde;
		}
	}
	
	/**
	 * 复写runTest,捕获异常进行截图处理
	 * 
	 * @throws Throwable
	 */
	@Override
	protected void runTest() throws Throwable {
		// TODO Auto-generated method stub
		try {
			super.runTest();
		} catch (Throwable th) {
			solo.takeScreenshot("runtest异常"+this.getClass().getSimpleName());
			throw new RunTestException(th);
		}
	}
}

/**
 * 三个自定义的异常类，对应setUp时发生的异常，runTest发生的异常，tearDown发生的异常
 *
 */
class SetUpException extends Exception {
	private static final long serialVersionUID = 1L;

	SetUpException(Throwable e) {
		super("Error in BasicTestCase.setUp()!", e);
	}
}

class RunTestException extends Exception {
	private static final long serialVersionUID = 2L;

	RunTestException(Throwable e) {
		super("Error in BasicTestCase.runTest()", e);
	}
}

class TearDownException extends Exception {
	private static final long serialVersionUID = 3L;

	TearDownException(Throwable e) {
		super("Error in MultiTestCase.tearDown()", e);
	}
}
