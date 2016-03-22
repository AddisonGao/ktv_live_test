package com.changba.live.testcases.live;

import android.text.style.ClickableSpan;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.changba.live.R;
import com.changba.live.R.id;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.UIHelper;
import com.changba.live.test.elements.ElementsLive;
import com.changba.live.test.elements.ElementsSettingFeedBack;
import com.changba.widget.ClearEditText;
import com.robotium.solo.Solo;

public class LiveSystem extends BasicTestCase {

	public void enterLivePage(){
		uiHelper.getElementsWonderfulShow().clickOnLivePage();
	}
	
	
	//系统消息：房间公告，用户进入房间系统信息等测试用例
	public void testLiveSystemText(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		solo.sleep(1000);
		
		String s0=(String) ((TextView)solo.getView(R.id.live_room_pubic_chat_item_system_txt,0)).getText();
		assertTrue(s0.contains("房间公告"));//房间公告
		
		String s1=(String) ((TextView)solo.getView(R.id.live_room_pubic_chat_item_system_txt,1)).getText();
		assertTrue(s1.contains("加入了直播间"));
		
		String s2=(String) ((TextView)solo.getView(R.id.live_room_pubic_chat_item_system_txt,2)).getText();
		assertTrue(s2.contains("唱吧直播间开播，有任何问题欢迎大家反馈客服"));
		
		String s3=(String) ((TextView)solo.getView(R.id.live_room_pubic_chat_item_system_txt,3)).getText();
		assertTrue(s3.contains("欢迎大家来到唱吧直播间"));

	}

	
	
	//退出直播间测试用例
	public void testLiveBack(){
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(1000);
		solo.clickOnView(solo.getView(R.id.live_room_liveinfo));
		solo.clickOnView(live.getLiveRoomExit());
		
		solo.clickOnText("取消");
		solo.sleep(1000);
		solo.assertCurrentActivity("exit",com.changba.live.room.activity.VideoRoomActivity.class);
		
		solo.clickOnView(live.getLiveRoomLiveInfo());
		solo.clickOnView(live.getLiveRoomExit());
		solo.clickOnView(live.getConfirmButton());//确定退出直播间
		solo.sleep(1000);
		solo.assertCurrentActivity("not exit",com.changba.live.activity.HomeFragmentTabs.class);
		
		
	}
	
	//房间信息 举报 等 更多信息测试用例
	public void testMore(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(1000);
	
		solo.clickOnView(live.getLiveRoomLiveInfo());
		solo.clickOnView(live.getLiveRoomMore());
		
		//取消操作
		solo.clickOnText("取消");
		solo.assertCurrentActivity("取消操作失败",com.changba.live.room.activity.VideoRoomActivity.class);
		
		
		//房间信息
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("房间信息");
		solo.sleep(1000);
		solo.assertCurrentActivity("进入房间详细信息有误",com.changba.live.room.activity.RoomInfoActivity.class);
		solo.goBack();
		
		
		//举报房间
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("举报");
		solo.clickOnText("取消");
		//solo.waitForText("感谢你的举报，管理员将对举报进行核实，根据实际情况做相应处理.");	
		
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("举报");
		solo.clickOnText("直播间包含色情、政治等违规内容");
		solo.waitForText("感谢你的举报，管理员将对举报进行核实，根据实际情况做相应处理.");	
		
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("举报");
		solo.clickOnText("人身攻击、辱骂");
		solo.waitForText("感谢你的举报，管理员将对举报进行核实，根据实际情况做相应处理.");
		
		
	
		
		
		
		solo.clickOnView(live.getLiveRoomLiveInfo());
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("举报");
		solo.clickOnText("其他");
		
		ClearEditText c=(ClearEditText)((RelativeLayout)solo.getView(R.id.dialog_content)).getChildAt(1);
		assertEquals(c.getHint().toString(),"请输入举报内容");
		
		solo.enterText((EditText)c, "test 举报测试内容");
		solo.clickOnText("确定");
		solo.waitForText("感谢你的举报，管理员将对举报进行核实，根据实际情况做相应处理.");
		solo.assertCurrentActivity("操作失败",com.changba.live.room.activity.VideoRoomActivity.class);
		
		
		
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("举报");
		solo.clickOnText("其他");
		
		c=(ClearEditText)((RelativeLayout)solo.getView(R.id.dialog_content)).getChildAt(1);
		solo.enterText((EditText)c, "test 举报测试内容");
		solo.clickOnText("取消");
		solo.waitForDialogToClose();
		solo.assertCurrentActivity("取消操作失败",com.changba.live.room.activity.VideoRoomActivity.class);
			
		
		
	}
	

	
	
}
