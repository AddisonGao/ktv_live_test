package com.changba.live.test.nologin;

import com.changba.live.R.id;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsLive;
import com.robotium.solo.Solo;

public class NotLoginLive extends BasicTestCase {

	
	public void enterLivePage(){
		uiHelper.getElementsWonderfulShow().clickOnLivePage();
	}
		
	
	public void testPublicAllChat(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(1000);
		solo.clickOnText("公开聊天");
		solo.waitForDialogToOpen();
		solo.clickOnText("取消");
		solo.waitForDialogToClose();
		solo.clickOnText("公开聊天");
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.confirm_btn));
		solo.sleep(1000);
		solo.assertCurrentActivity("失败",com.changba.live.activity.LoginActivity.class);	
		solo.goBack();
		
		
		solo.clickOnText("送礼物");
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.confirm_btn));
		solo.sleep(1000);
		solo.assertCurrentActivity("失败",com.changba.live.activity.LoginActivity.class);	
		solo.goBack();
		
		solo.clickOnView(solo.getView(id.live_room_liveinfo));
		solo.clickOnView(solo.getView(id.live_room_anchor_collect));
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.confirm_btn));
		solo.sleep(1000);
		solo.assertCurrentActivity("失败",com.changba.live.activity.LoginActivity.class);	
		solo.goBack();
		
		solo.clickOnView(solo.getView(id.live_room_liveinfo));
		solo.clickOnView(solo.getView(id.live_room_more));
		solo.clickOnText("房间信息");
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.confirm_btn));
		solo.sleep(1000);
		solo.assertCurrentActivity("失败",com.changba.live.activity.LoginActivity.class);	
		solo.goBack();
		
		solo.clickOnView(solo.getView(id.live_room_liveinfo));
		solo.clickOnView(solo.getView(id.live_room_more));
		solo.clickOnText("举报");
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.confirm_btn));
		solo.sleep(1000);
		solo.assertCurrentActivity("失败",com.changba.live.activity.LoginActivity.class);	
		solo.goBack();
		
			
		solo.clickOnView(solo.getView(id.live_room_headphoto));
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.confirm_btn));
		solo.sleep(1000);
		solo.assertCurrentActivity("失败",com.changba.live.activity.LoginActivity.class);	
		solo.goBack();
		
		solo.clickOnView(solo.getView(id.live_room_pubic_chat_item_sender_head_img,0));
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.confirm_btn));
		solo.sleep(1000);
		solo.assertCurrentActivity("失败",com.changba.live.activity.LoginActivity.class);	
		solo.goBack();
		
		
		
		solo.clickOnText("观众");
		solo.clickOnView(solo.getView(id.user_name,0));
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.confirm_btn));
		solo.sleep(1000);
		solo.assertCurrentActivity("失败",com.changba.live.activity.LoginActivity.class);	
		solo.goBack();
		
		
		
	}
	
	
	
}
