package com.changba.live.testcases.profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.widget.TextView;

import com.changba.live.R;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsProfile;
import com.changba.live.test.elements.ElementsWonderfulShow;
import com.robotium.solo.Solo;

public class MyProfileShow extends BasicTestCase {
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	public void testEnterMyProfile(){
		Solo solo=uiHelper.getSolo();
		//截图保存路径可保存？
		//solo.getConfig().screenshotSavePath="我的主页";
		solo.takeScreenshot("启动页");
		uiHelper.getElementsWonderfulShow().clickOnMe();
		assertTrue(solo.waitForActivity(com.changba.live.activity.HomeFragmentTabs.class));
		ElementsProfile profile=uiHelper.getElementsProfile();
		solo.takeScreenshot("我");
		solo.scrollToBottom();
		solo.takeScreenshot("我页面下滑");
		judgeShow(profile,solo);
	}
	public void judgeShow(ElementsProfile profile,Solo solo){
		assertTrue(profile.getBtnEdit().isShown());//编辑资料
		assertFalse(profile.getBtnChat().isShown());//聊天
		assertTrue(profile.getMoreInfoLayout().isShown());//更多资料
		assertFalse(profile.getBtnFollow().isShown());//关注
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("等级");
		list.add("财富等级");
		list.add("消息");
		list.add("播币");
		list.add("播豆");
		list.add("我的直播间");
		list.add("收藏");
		list.add("粉丝");
		list.add("关注");
		for(int i=0;i<list.size();i++){
			assertEquals(((TextView)solo.getView(R.id.txt_left,i)).getText(), list.get(i));
		}
		//判断我的直播间状态是否符合三者之一
		String[] strArray = {"（休息中）","（正在直播）","（成为主播开通直播间）"};  
		List<String> fauCodeList = new ArrayList<String>();
		fauCodeList=Arrays.asList(strArray);
		assertTrue(fauCodeList.contains(((TextView)solo.getView(R.id.txt_left_right,5)).getText())==true);
	}
	
}
