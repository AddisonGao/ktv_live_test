package com.changba.live.testcases.setting;

import java.util.ArrayList;
import java.util.Random;

import com.changba.live.R;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsSettingInfoPush;
import com.changba.widget.UISwitchButton;
import com.robotium.solo.Solo;

public class InfoPush extends BasicTestCase {

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	/**
	 * 进入推送提醒页
	 */
	public void enterInfoPush(){
		uiHelper.getElementsWonderfulShow().clickOnMe();
		uiHelper.getElementsProfile().clickOnSetting();
		uiHelper.getElementsSetting().clickOnInfoPush();
	}
	/**
	 * 判断推送提醒页的显示
	 */
	public void testInfoPushShow(){//无论接受推送提醒开关是否开关都能判断
		enterInfoPush();
		Solo solo=uiHelper.getSolo();
		ElementsSettingInfoPush settingInfoPush=uiHelper.getElementsSettingInfoPush();
		solo.takeScreenshot("推送提醒页");
		assertTrue(settingInfoPush.judgeTheTitle());//判断标题是否为推送提醒页
		assertTrue(settingInfoPush.getMyLeftView().isShown());//返回图标
		assertFalse(settingInfoPush.getMyRightView()==null);
		assertTrue(settingInfoPush.judgeTheItem()&&settingInfoPush.getText());//判断每一栏的标题是否正确,以及提醒方式和免打扰时间
	}
	
	/**
	 * 开关使用,随意点击三个开关之一返回设置页再次进入设置页 前后是否一致。
	 */
	public void testChangeSwitchState(){
		enterInfoPush();
		Solo solo=uiHelper.getSolo();
		ElementsSettingInfoPush settingInfoPush=uiHelper.getElementsSettingInfoPush();
		if(!settingInfoPush.getText())//接受提醒开关为关
		{	settingInfoPush.clickOnAgreePush();
		    boolean a[]=getSwitchState(solo);
			settingInfoPush.clickOnRandomSwitch();
			solo.takeScreenshot("改变开关状态");
			settingInfoPush.clickOnLeftBack();//点击左上角返回判断是否返回设置页
			assertTrue("com.changba.live.activity.settingactivity is not found!", solo.waitForActivity(com.changba.live.activity.SettingActivity.class));
			solo.waitForText("设置成功");
//			uiHelper.getElementsSetting().clickOnInfoPush();
			solo.clickOnView(solo.getView(R.id.txt_left, 1));//点推送提醒
			assertTrue(judgeSwitchState(solo, a));;
			solo.takeScreenshot("改变后退出再次进入");
		}
		else//接受开关为开
		{
			settingInfoPush.clickOnRandomSwitch();
			boolean a[]=getSwitchState(solo);
			solo.takeScreenshot("改变开关状态");
			settingInfoPush.clickOnLeftBack();//点击左上角返回判断是否返回设置页
			assertTrue("com.changba.live.activity.settingactivity is not found!", solo.waitForActivity(com.changba.live.activity.SettingActivity.class));
			solo.waitForText("设置成功");
			solo.clickOnView(solo.getView(R.id.txt_left, 1));//点推送提醒
			assertTrue(judgeSwitchState(solo, a));
			solo.takeScreenshot("改变后退出再次进入");
		}
	}
	public boolean[] getSwitchState(Solo solo){
		boolean a[]=new boolean[3];
		for(int i=0;i<3;i++)
		{
			a[i]=((UISwitchButton)solo.getView(R.id.switch_right,i)).isChecked();
		}
		return a;
	}
	public boolean judgeSwitchState(Solo solo,boolean a[]){
		boolean flag=true;
		for(int i=0;i<a.length;i++)
		{
			if((UISwitchButton)solo.getView(R.id.switch_right,i)!=null){
				if(((UISwitchButton)solo.getView(R.id.switch_right,i)).isChecked()!=a[i])
					flag=false;
			}
		}
		return flag;
	}
}
