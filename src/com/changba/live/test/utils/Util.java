package com.changba.live.test.utils;

import android.app.Instrumentation;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class Util {

	/**
	 * »½ÐÑÆÁÄ»
	 * @return return wakelock object,it will release after class done
	 */
	public static WakeLock wakeScreen(InstrumentationTestCase itc){
		PowerManager pm=(PowerManager) itc.getInstrumentation().getTargetContext().getSystemService(Context.POWER_SERVICE);
		WakeLock wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK
				| PowerManager.FULL_WAKE_LOCK
				| PowerManager.ACQUIRE_CAUSES_WAKEUP, itc.getClass()
				.getSimpleName());
		wakeLock.acquire();
		return wakeLock;
	}
	/**
	 * ½âËø
	 * @param instr
	 */
	public static void unlock(Instrumentation instr){
		try{
			Context targetContext=instr.getTargetContext();
			KeyguardManager keyGuardManager = (KeyguardManager) targetContext
					.getSystemService(Context.KEYGUARD_SERVICE);
			KeyguardLock mLock = keyGuardManager.newKeyguardLock("");
			mLock.disableKeyguard();
		} catch (Throwable e) {
			Log.e("", "disableKeyguard:", e);
		}
	}
}
