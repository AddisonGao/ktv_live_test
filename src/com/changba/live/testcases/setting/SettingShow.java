package com.changba.live.testcases.setting;

import java.util.ArrayList;
import org.junit.Test;
import android.widget.TextView;
import com.changba.live.R;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsSetting;
import com.changba.live.test.elements.ElementsSettingAbout;
import com.changba.live.test.elements.ElementsSettingAgreement;
import com.changba.live.test.elements.ElementsSettingHelp;
import com.robotium.solo.Solo;

public class SettingShow extends BasicTestCase {

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	public void enterSettingPage(){
		uiHelper.getElementsWonderfulShow().clickOnMe();
		uiHelper.getElementsProfile().clickOnSetting();
	}
	
	public void testSettingPageShow(){
		Solo solo=uiHelper.getSolo();
		enterSettingPage();
		ElementsSetting elementsSetting=uiHelper.getElementsSetting();
		solo.takeScreenshot("设置页");
		assertEquals(((TextView)solo.getView(R.id.my_titleview)).getText(), "设置");//设置标题
		assertTrue(elementsSetting.getMyLeftView().isShown());//返回图标
		assertFalse(elementsSetting.getMyRightView()==null);
		assertTrue(elementsSetting.getLoginBtn().getText().equals("退出登录"));
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("播放房间动画");
		list.add("推送提醒");
		list.add("关于本软件");
		list.add("意见反馈");
		list.add("帮助中心");
		list.add("免责声明和版权声明");
		for(int i=0;i<list.size();i++){
			assertEquals(((TextView)solo.getView(R.id.txt_left,i)).getText(), list.get(i));
		}
	}
	/**
	 * 房间动画开关,点击开关返回前页再次进入是否一致
	 */
	public void testPushAnimation(){
		enterSettingPage();
		Solo solo=uiHelper.getSolo();
		ElementsSetting elementsSetting=uiHelper.getElementsSetting();
		solo.takeScreenshot("动画开关");
		boolean falg=elementsSetting.getSwitchRight().isChecked();
		elementsSetting.clickOninfoPushAnimation();
		solo.takeScreenshot("动画开关-改变");
		elementsSetting.clickOnLeftBack();
		solo.sleep(100);
		enterSettingPage();
		solo.sleep(100);
		assertEquals(!falg, elementsSetting.getSwitchRight().isChecked());
		solo.takeScreenshot("动画开关-改变后再次进入");
	}
	
	/**
	 * 关于本软件
	 */
	public void testAboutShow(){
		enterSettingPage();
		Solo solo=uiHelper.getSolo();
		uiHelper.getElementsSetting().clickOnAbout();
		solo.sleep(300);
		ElementsSettingAbout settingAbout=uiHelper.getElementsSettingaAbout();
		solo.takeScreenshot("关于");
		assertEquals(((TextView)solo.getView(R.id.my_titleview)).getText(), "关于本软件");//页面标题
		assertTrue(settingAbout.getMyLeftView().isShown());//返回图标
		assertFalse(settingAbout.getMyRightView()==null);
		assertTrue(settingAbout.getChangbaLog().isShown()&&settingAbout.getVersion().isShown());
		assertEquals(settingAbout.getTips().getText(), "客服QQ ： 800092105\n新浪微博： @唱吧直播间\n腾讯微博： @唱吧直播间");
		assertTrue(settingAbout.getCopyRight().isShown());
		assertEquals(settingAbout.getCopyRight().getText(), "唱吧战略合作伙伴：阿里云\n©2014 changba.com");
	}
	/**
	 * 帮助中心页
	 */
	public void testHelpShow(){
		enterSettingPage();
		Solo solo=uiHelper.getSolo();
		uiHelper.getElementsSetting().clickOnHelp();//点击帮助
		solo.sleep(500);
		ElementsSettingHelp settingHelp=uiHelper.getElementsSettingHelp();
		solo.takeScreenshot("帮助中心");
		solo.scrollToBottom();
		solo.takeScreenshot("帮助中心下滑");
		assertEquals(((TextView)solo.getView(R.id.my_titleview)).getText(), "唱吧直播间-帮助中心");//页面标题
		assertTrue(settingHelp.getMyLeftView().isShown());//返回图标
		assertFalse(settingHelp.getMyRightView()==null);
		assertTrue(settingHelp.getBtnBack().isShown()&&!settingHelp.getBtnBack().isClickable());
		assertTrue(settingHelp.getBtnForward().isShown()&&!settingHelp.getBtnForward().isClickable());
		assertTrue(settingHelp.getBtnUpload().isShown()&&settingHelp.getBtnUpload().isClickable());
		solo.clickOnView(settingHelp.getBtnUpload());
		solo.sleep(300);
		solo.takeScreenshot("帮助中心刷新后");
	}
	/**
	 * 免责声明页
	 */
	public void testAgreementShow(){
		enterSettingPage();
		Solo solo=uiHelper.getSolo();
		uiHelper.getElementsSetting().clickOnAgreement();//点击声明
		solo.sleep(1000);//不能去掉，太快找不到控件
		ElementsSettingAgreement settingAgreement=uiHelper.getElementsSettingAgreement();
		solo.takeScreenshot("免责声明");
		solo.scrollToBottom();
		solo.takeScreenshot("免责声明下滑");
		assertEquals(((TextView)solo.getView(R.id.my_titleview)).getText(), "唱吧直播间网络服务使用协议以及版权声明");//页面标题
		assertTrue(settingAgreement.getMyLeftView().isShown());//返回图标
		assertFalse(settingAgreement.getMyRightView()==null);
		assertTrue(settingAgreement.getBtnBack().isShown()&&!settingAgreement.getBtnBack().isClickable());
		assertTrue(settingAgreement.getBtnForward().isShown()&&!settingAgreement.getBtnForward().isClickable());
		assertTrue(settingAgreement.getBtnUpload().isShown()&&settingAgreement.getBtnUpload().isClickable());
		solo.clickOnView(settingAgreement.getBtnUpload());
		solo.sleep(1000);
		solo.takeScreenshot("免责声明刷新后");
	}
}
