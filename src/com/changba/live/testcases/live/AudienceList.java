package com.changba.live.testcases.live;

import android.text.InputFilter.LengthFilter;
import android.widget.Button;
import android.widget.TextView;

import com.changba.live.R;
import com.changba.live.R.id;
import com.changba.live.R.string;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsLive;
import com.changba.widget.LoadMoreListView;
import com.robotium.solo.Solo;

public class AudienceList extends BasicTestCase {
	
	public void enterLivePage(){
		uiHelper.getElementsWonderfulShow().clickOnLivePage();
	}
	
	
	
	//观众列表测试用例
	public void testList(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		solo.sleep(5000);
		
		//观众列表第一个人是主播 需要信息匹配
		solo.clickOnText("观众");
		String user0=((TextView)solo.getView(R.id.user_name,0)).getText().toString();
		String name0=((TextView)solo.getView(R.id.live_room_nickname)).getText().toString();
		
		String nameshort0;
		if (name0.length()>=7){
			 nameshort0=name0.substring(0, 7)+"...";
		}
		else nameshort0=name0;
		
		System.out.println(nameshort0+"-------------------------");
		System.out.println(user0+"-------------------------");
		
		assertTrue(user0.contains(nameshort0));
		
		String nameLevel=((TextView)solo.getView(id.live_room_star_level)).getText().toString();
		String userLevel=(String) ((TextView)solo.getView(R.id.user_title_level,0)).getText().toString();
		assertEquals(nameLevel, userLevel);
		
		
		
		//观众数目应该大于等于列表元素数目
		String numname0=((String) ((TextView)(Button)solo.getView(R.id.tab_audience)).getText());
		numname0=numname0.substring(3, numname0.length()-1);
		
		
		
		int num1=Integer.parseInt(numname0);
		
		//System.out.println(num1+"-------------------------");
		int num2=((LoadMoreListView)solo.getView(id.live_room_listview)).getChildCount();
		
		assertTrue(num1>=num2);
		
	}

	//一般观众测试用例
	public void testNormalPerson(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(5000);
		
		//观众列表第2个人是一般观众
		solo.clickOnText("观众");
		String user1=((TextView)solo.getView(R.id.user_name,1)).getText().toString();
		solo.clickOnView(solo.getView(id.headphoto,1));
		String username1=((TextView)solo.getView(id.username)).getText().toString();
		//判断人物标签的用户名和观众里面所点击的用户名是不是相同的
		assertEquals(user1,username1);
		
		
		
		//悄悄说测试用例
		solo.clickOnText("悄悄对TA说");
		//测试对话输入框预置文案的 名称是否与选中的用户名称一致
		solo.searchText("对"+user1+"悄悄说");
		solo.enterText(live.getPostComment(), "test1");
		solo.clickOnText("发送");		
		String s2=((TextView)solo.getView(id.live_room_pubic_chat_item_down_txt,1)).getText().toString();
		assertEquals("发送私聊消息失败", "test1", s2);		
		String s3=((TextView)solo.getView(id.live_room_pubic_chat_item_username,1)).getText().toString();		
	if (user1.length()>=7){
			String nameshort=user1.substring(0, 7);
			assertTrue(s3.contains("我 悄悄对 "+nameshort));
		}	
	else assertTrue(s3.contains("我 悄悄对 "+user1));
	

	
	//公开说测试用例
	solo.clickOnText("观众");
	solo.clickOnView(solo.getView(id.headphoto,1));
	solo.clickOnText("公开对TA说");
	//测试对话输入框预置文案的 名称是否与选中的用户名称一致
	solo.searchText("对"+user1+"说");
	
	solo.enterText(live.getPostComment(), "test2");
	solo.clickOnText("发送");
	String nameshort;
	if (user1.length()>=7){
		 nameshort=user1.substring(0, 7)+"...";
	}
	else
		 nameshort=user1;
	
	
	for(int i=0;i>=0;i++)
	{
		if(((TextView)solo.getView(R.id.live_room_pubic_chat_item_username,i)).getText().toString().contains("我 对 "+nameshort+"说：")){
			assertEquals("失败", "test2", ((TextView)solo.getView(R.id.live_room_pubic_chat_item_down_txt,i)).getText().toString());
		}
		break;
	}
	
	
	//踢出房间测试用例
	solo.clickOnText("观众");
	solo.clickOnView(solo.getView(id.headphoto,1));
	solo.clickOnText("踢出房间");
	solo.clickOnText("取消");
	solo.waitForDialogToClose();
	solo.assertCurrentActivity("取消操作失败",com.changba.live.room.activity.VideoRoomActivity.class);
	
	
	solo.clickOnView(solo.getView(id.headphoto,1));
	solo.clickOnText("踢出房间");
	solo.clickOnView(live.getConfirmButton());//确定踢人
	solo.waitForText("你没有踢人的权限");
	
	}

	
	
	
	
	
	
}
