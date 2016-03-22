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
	

	//��ĳ���䲻�ǹ���Աȥ���ˣ�����û��Ȩ�޵Ĳ�������
	public void testKickoff(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(5000);
		
		//ȡ��һ���û���Ϊ����
		solo.clickOnView(solo.getView(id.live_room_pubic_chat_item_sender_head_img,0));
		solo.clickOnText("�߳�����");
		solo.clickOnText("ȡ��");
		solo.waitForDialogToClose();
		solo.assertCurrentActivity("ȡ������ʧ��",com.changba.live.room.activity.VideoRoomActivity.class);
		
		
		solo.clickOnView(solo.getView(id.live_room_pubic_chat_item_sender_head_img,0));
		solo.clickOnText("�߳�����");
		solo.clickOnView(live.getConfirmButton());//ȷ������
		solo.waitForText("��û�����˵�Ȩ��");
		
	}
	
}
