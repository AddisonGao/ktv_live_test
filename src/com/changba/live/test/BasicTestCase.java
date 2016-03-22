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
 * �����࣬�������̳У����һЩ�ֻ��������ѵȲ���
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
	 * ��дsetUp()�������쳣
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
	 * ��дtearDown,�����쳣���񣬽�ͼ����
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
		// �����豸
		if (wakeScreenObject == null) {
			wakeScreenObject = com.changba.live.test.utils.Util.wakeScreen(this);
		}
		// ����
		com.changba.live.test.utils.Util.unlock(getInstrumentation());
		// ��������
		NetworkUtil.setAirplaneModeOffAndNetworkOn(getInstrumentation().getTargetContext());
	}
	
	/**
	 * ��setUp��runTest��tearDown�׳����Զ����쳣������ͳһ���в���Ȼ��ȷ��tearDown������ִ�У������ͷ���Դ
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
	 * ��дrunTest,�����쳣���н�ͼ����
	 * 
	 * @throws Throwable
	 */
	@Override
	protected void runTest() throws Throwable {
		// TODO Auto-generated method stub
		try {
			super.runTest();
		} catch (Throwable th) {
			solo.takeScreenshot("runtest�쳣"+this.getClass().getSimpleName());
			throw new RunTestException(th);
		}
	}
}

/**
 * �����Զ�����쳣�࣬��ӦsetUpʱ�������쳣��runTest�������쳣��tearDown�������쳣
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
