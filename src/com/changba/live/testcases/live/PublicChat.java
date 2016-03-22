package com.changba.live.testcases.live;

import android.widget.TextView;

import com.changba.live.R;
import com.changba.live.R.id;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsLive;
import com.robotium.solo.Solo;

public class PublicChat extends BasicTestCase {

	public void enterLivePage(){
		uiHelper.getElementsWonderfulShow().clickOnLivePage();
	}
		
	//公聊 对大家说测试用例
	public void testPublicAllChat(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(1000);
		solo.clickOnText("公开聊天");
		assertEquals(live.getPostComment().getHint(),"对大家说");//判断公聊输入框预置文案
			
		solo.enterText(live.getPostComment(), "test 测试文字");//输入单纯文字测试
		solo.clickOnText("发送");
		
		if(((TextView)solo.getView(R.id.live_room_pubic_chat_item_username)).getText().toString().equals("我")){
			assertEquals("失败", "test 测试文字", ((TextView)solo.getView(R.id.live_room_pubic_chat_item_down_txt)).getText().toString());
		}
	}

	
	
	//通过人物标签对一用户公聊
	public void testPublicIconChat(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(1000);
		
		//取第一个用户作为测试
		String name0=((TextView)solo.getView(id.live_room_pubic_chat_item_username,0)).getText().toString();
		solo.clickOnView(solo.getView(id.live_room_pubic_chat_item_sender_head_img,0));
		solo.clickOnText("公开对TA说");
		//测试对话输入框预置文案的 名称是否与选中的用户名称一致
		solo.searchText("对"+name0+"说");
		
		solo.enterText(live.getPostComment(), "test2");
		solo.clickOnText("发送");
		String nameshort;
		if (name0.length()>=7){
			 nameshort=name0.substring(0, 7)+"...";
		}
		else
			 nameshort=name0;
		
		
		for(int i=0;i>=0;i++)
		{
			if(((TextView)solo.getView(R.id.live_room_pubic_chat_item_username,i)).getText().toString().contains("我 对 "+nameshort+"说：")){
				assertEquals("失败", "test2", ((TextView)solo.getView(R.id.live_room_pubic_chat_item_down_txt,i)).getText().toString());
			}
			break;
		}
		
		
		
		
	}


	//通过点击某一行公聊文字 对该用户公聊
	public void testPublicTextChat(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(1000);
		
		//取第一个用户作为测试 单击第一条信息进行回复
		String name0=((TextView)solo.getView(id.live_room_pubic_chat_item_username,0)).getText().toString();
		solo.clickOnView(solo.getView(id.live_room_pubic_chat_item_down_txt,0));
		
		//测试对话输入框预置文案的 名称是否与选中的用户名称一致
		solo.searchText("对"+name0+"说");
		
		solo.enterText(live.getPostComment(), "test3");
		solo.clickOnText("发送");
		
		String nameshort;
		if (name0.length()>=7){
			 nameshort=name0.substring(0, 7)+"...";
		}
		else
			 nameshort=name0;
		
		
		for(int i=0;i>=0;i++)
		{
			if(((TextView)solo.getView(R.id.live_room_pubic_chat_item_username,i)).getText().toString().contains("我 对 "+nameshort+"说：")){
				assertEquals("失败", "test3", ((TextView)solo.getView(R.id.live_room_pubic_chat_item_down_txt,i)).getText().toString());
			}
			break;
		}
		
		
		
		
	}
	
}





