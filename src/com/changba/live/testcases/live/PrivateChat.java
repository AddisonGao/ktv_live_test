package com.changba.live.testcases.live;

import android.widget.TextView;

import com.changba.live.R;
import com.changba.live.R.id;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsLive;
import com.changba.widget.EmotionEditText;
import com.robotium.solo.Solo;

public class PrivateChat extends BasicTestCase {

	public void enterLivePage(){
		uiHelper.getElementsWonderfulShow().clickOnLivePage();
	}
	
	
	//私聊测试用例，私聊tab
	public void testPrivateChat(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(5000);
		
		//主播名字
		String name=((TextView)(solo.getView(id.live_room_nickname))).getText().toString();
	
		
		
		solo.clickOnText("私聊");
		String s0=(String) ((TextView)solo.getView(R.id.live_room_pubic_chat_item_username,0)).getText().toString();
		//System.out.println(s0+"===================================");
		assertTrue(s0.contains("(主播) 悄悄对 我 说"));
		solo.clickOnView(solo.getView(id.live_room_pubic_chat_item_down_txt,0));
		String s1=((com.changba.widget.emotion.EmotionEditText)solo.getView(id.postcomment)).getHint().toString();
		solo.searchText("对"+name+"悄悄说");
		
		
		solo.enterText(live.getPostComment(), "test");
		solo.clickOnText("发送");
		String s2=((TextView)solo.getView(id.live_room_pubic_chat_item_down_txt,1)).getText().toString();
		assertEquals("发送私聊消息失败", "test", s2);
		
		String s3=((TextView)solo.getView(id.live_room_pubic_chat_item_username,1)).getText().toString();
		//System.out.println(s3+"===================================");
		
	if (name.length()>=7){
			
			String nameshort=name.substring(0, 7);
			assertTrue(s3.contains("我 悄悄对 "+nameshort));
		}
	
	else
		assertTrue(s3.contains("我 悄悄对 "+name));
		
		
		
		
	
		//Caused by: junit.framework.ComparisonFailure: 发送私聊消息失败 expected:<我 悄悄对 [ ]露-星主播✨...(主播) 说:> but was:<我 悄悄对 [陆]露-星主播✨...(主播) 说:>
	
		//Caused by: junit.framework.ComparisonFailure: 发送私聊消息失败 expected:<我 悄悄对 [ ]陆露-星主播✨...(主播) 说:> but was:<我 悄悄对 []陆露-星主播✨...(主播) 说:>
	
	}

	
	public void testPrivateIconChat(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(5000);
		

		//取第一个用户作为测试
		String name0=((TextView)solo.getView(id.live_room_pubic_chat_item_username,0)).getText().toString();
		solo.clickOnView(solo.getView(id.live_room_pubic_chat_item_sender_head_img,0));
		String username0=((TextView)solo.getView(id.username)).getText().toString();
		//判断人物标签的用户名和公聊里面所点击的用户名是不是相同的
		assertEquals(name0,username0);
		solo.clickOnText("悄悄对TA说");
		
		//测试对话输入框预置文案的 名称是否与选中的用户名称一致
		solo.searchText("对"+name0+"悄悄说");
		solo.enterText(live.getPostComment(), "test1");
		solo.clickOnText("发送");
		
		String s2=((TextView)solo.getView(id.live_room_pubic_chat_item_down_txt,1)).getText().toString();
		assertEquals("发送私聊消息失败", "test1", s2);
		
		String s3=((TextView)solo.getView(id.live_room_pubic_chat_item_username,1)).getText().toString();
		
		
	if (name0.length()>=7){
			String nameshort=name0.substring(0, 7);
			assertTrue(s3.contains("我 悄悄对 "+nameshort));
		}
	
	else
		assertTrue(s3.contains("我 悄悄对 "+name0));
		
		
		
		
		
		
		
		
	    
		
		
		
	}
	
	

	
}
