package com.changba.live.test.otherprofile;

import android.R.integer;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.changba.live.R.id;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsLive;
import com.changba.live.test.elements.ElementsOtherProfile;
import com.changba.widget.pulltorefresh.PullToRefreshListView;
import com.robotium.solo.Solo;

public class OtherProfile extends BasicTestCase  {
	
	
	public void clickOnOtherProfile(){
		uiHelper.getElementsOtherProfile().clickOnOtherPersonProfile();
	}
	
	//返回上一页面测试 我的关注
	public void testBackPage(){
		
		Solo solo=uiHelper.getSolo();
		ElementsOtherProfile otherProfile=uiHelper.getElementsOtherProfile();
		clickOnOtherProfile();
		solo.sleep(1000);
		
		solo.clickOnView(solo.getView(id.btn_back));
		solo.sleep(1000);
		solo.assertCurrentActivity("从他人返回到关注页面失败",com.changba.live.activity.UserListActivity.class);		
	}
	
	
	/*聊天唤起唱吧
	public void testChat(){
		
		Solo solo=uiHelper.getSolo();
		ElementsOtherProfile otherProfile=uiHelper.getElementsOtherProfile();
		clickOnOtherProfile();
		solo.sleep(500);
		String name0=otherProfile.getUserName().getText().toString();
		
		solo.clickOnView(otherProfile.getBtnChat());
		solo.sleep(2000);
		
		
	}
	*/
	//关注测试用例
	public void testFollow(){
		
		Solo solo=uiHelper.getSolo();
		ElementsOtherProfile otherProfile=uiHelper.getElementsOtherProfile();
		clickOnOtherProfile();
		solo.sleep(500);
		
		String followWord=((TextView)solo.getView(id.btn_follow)).getText().toString();
		assertEquals("取消关注",followWord);
		
		solo.clickOnText("取消关注");
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.go_on_btn));
		solo.waitForDialogToClose();
		
		String followWord1=((TextView)solo.getView(id.btn_follow)).getText().toString();
		assertEquals("取消关注",followWord1);
		
		solo.clickOnText("取消关注");
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.confirm_btn));
		solo.waitForDialogToClose();
		solo.waitForText("取消关注成功！");
		solo.sleep(2500);
		
		
		String followWord2=((TextView)solo.getView(id.btn_follow)).getText().toString();
		assertEquals("关注",followWord2);
		
		
		solo.clickOnText("关注");
		solo.waitForText("关注成功！");
		
		String followWord3=((TextView)solo.getView(id.btn_follow)).getText().toString();
		assertEquals("取消关注",followWord3);
		
		
		
		
	}
	
	
	public void testLevel(){
		
		Solo solo=uiHelper.getSolo();
		ElementsOtherProfile otherProfile=uiHelper.getElementsOtherProfile();
		clickOnOtherProfile();
		solo.sleep(2000);
		
		String name0=((TextView)solo.getView(id.username)).getText().toString();
		
		solo.clickOnText("等级");
		solo.sleep(500);
		solo.assertCurrentActivity("进入等级页面失败", com.changba.live.activity.LevelRankActivity.class);
		String title0=((TextView)solo.getView(id.level_title)).getText().toString();
		assertEquals(name0+"的等级", title0);
		solo.clickOnView(solo.getView(id.my_lefttview));
		solo.sleep(500);
		solo.assertCurrentActivity("返回失败", com.changba.live.activity.CommonFragmentActivity.class);
		
		solo.clickOnText("财富等级");
		solo.sleep(500);
		solo.assertCurrentActivity("进入财富等级页面失败", com.changba.live.activity.LevelRankActivity.class);
		String title1=((TextView)solo.getView(id.level_title)).getText().toString();
		assertEquals(name0+"的财富等级", title1);
		solo.clickOnView(solo.getView(id.my_lefttview));
		solo.sleep(500);
		solo.assertCurrentActivity("返回失败", com.changba.live.activity.CommonFragmentActivity.class);
		
		
		
		
	}
	
	
	
	
	
	
	/*粉丝 关注数目 测试
	
	public void testNum(){
		
		Solo solo=uiHelper.getSolo();
		ElementsOtherProfile otherProfile=uiHelper.getElementsOtherProfile();
		clickOnOtherProfile();
		solo.sleep(2000);
		
		String name0=((TextView)solo.getView(id.username)).getText().toString();
		
		String num0=((TextView)solo.getView(id.txt_left_right,7)).getText().toString();
		System.out.println(num0+"==========================="+((TextView)solo.getView(id.txt_left,3)).getText().toString());
		String number0=num0.substring(1, num0.length()-1);
		int numberint0=Integer.parseInt(number0);//粉丝数
		
		String num1=((TextView)solo.getView(id.txt_left_right,8)).getText().toString();
		String number1=num1.substring(1, num1.length()-1);
		int numberint1=Integer.parseInt(number1);//关注数
		
		solo.clickOnText("粉丝");
		solo.assertCurrentActivity("进入粉丝列表失败",com.changba.live.activity.UserListActivity.class);
		solo.sleep(1000);
		String title0=((TextView)solo.getView(id.my_titleview)).getText().toString();
		
		int count0=((ListView)(((FrameLayout)(((PullToRefreshListView)solo.getView(id.listview)).getChildAt(1))).getChildAt(0))).getChildCount();
		assertEquals(numberint0, count0);
		
		solo.clickOnView(solo.getView(id.my_lefttview));
		solo.sleep(1000);
		
		solo.clickOnText("关注");
		solo.assertCurrentActivity("进入关注列表失败",com.changba.live.activity.UserListActivity.class);
		solo.sleep(1000);
		
		int count1=((ListView)(((FrameLayout)(((PullToRefreshListView)solo.getView(id.listview)).getChildAt(1))).getChildAt(0))).getChildCount();
		assertEquals(numberint1, count1);
		
		
		
		
		
	}
	*/
	
	
	
	

}
