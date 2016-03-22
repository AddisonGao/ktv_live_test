package com.changba.live.testcases.live;

import android.widget.TextView;

import com.changba.live.R.id;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsLive;
import com.robotium.solo.Solo;

public class KickoffUser extends BasicTestCase {

	
	public void enterLivePage(){
		uiHelper.getElementsWonderfulShow().clickOnLivePage();
	}
	

	//在某房间不是管理员去踢人，踢人没有权限的测试用例
	public void testKickoff(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(5000);
		
		//取第一个用户作为测试
		solo.clickOnView(solo.getView(id.live_room_pubic_chat_item_sender_head_img,0));
		solo.clickOnText("踢出房间");
		solo.clickOnText("取消");
		solo.waitForDialogToClose();
		solo.assertCurrentActivity("取消操作失败",com.changba.live.room.activity.VideoRoomActivity.class);
		
		
		solo.clickOnView(solo.getView(id.live_room_pubic_chat_item_sender_head_img,0));
		solo.clickOnText("踢出房间");
		solo.clickOnView(live.getConfirmButton());//确定踢人
		solo.waitForText("你没有踢人的权限");
		
	}
	
}
