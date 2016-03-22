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
	
	
	//ϵͳ��Ϣ�����乫�棬�û����뷿��ϵͳ��Ϣ�Ȳ�������
	public void testLiveSystemText(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		solo.sleep(1000);
		
		String s0=(String) ((TextView)solo.getView(R.id.live_room_pubic_chat_item_system_txt,0)).getText();
		assertTrue(s0.contains("���乫��"));//���乫��
		
		String s1=(String) ((TextView)solo.getView(R.id.live_room_pubic_chat_item_system_txt,1)).getText();
		assertTrue(s1.contains("������ֱ����"));
		
		String s2=(String) ((TextView)solo.getView(R.id.live_room_pubic_chat_item_system_txt,2)).getText();
		assertTrue(s2.contains("����ֱ���俪�������κ����⻶ӭ��ҷ����ͷ�"));
		
		String s3=(String) ((TextView)solo.getView(R.id.live_room_pubic_chat_item_system_txt,3)).getText();
		assertTrue(s3.contains("��ӭ�����������ֱ����"));

	}

	
	
	//�˳�ֱ�����������
	public void testLiveBack(){
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(1000);
		solo.clickOnView(solo.getView(R.id.live_room_liveinfo));
		solo.clickOnView(live.getLiveRoomExit());
		
		solo.clickOnText("ȡ��");
		solo.sleep(1000);
		solo.assertCurrentActivity("exit",com.changba.live.room.activity.VideoRoomActivity.class);
		
		solo.clickOnView(live.getLiveRoomLiveInfo());
		solo.clickOnView(live.getLiveRoomExit());
		solo.clickOnView(live.getConfirmButton());//ȷ���˳�ֱ����
		solo.sleep(1000);
		solo.assertCurrentActivity("not exit",com.changba.live.activity.HomeFragmentTabs.class);
		
		
	}
	
	//������Ϣ �ٱ� �� ������Ϣ��������
	public void testMore(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(1000);
	
		solo.clickOnView(live.getLiveRoomLiveInfo());
		solo.clickOnView(live.getLiveRoomMore());
		
		//ȡ������
		solo.clickOnText("ȡ��");
		solo.assertCurrentActivity("ȡ������ʧ��",com.changba.live.room.activity.VideoRoomActivity.class);
		
		
		//������Ϣ
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("������Ϣ");
		solo.sleep(1000);
		solo.assertCurrentActivity("���뷿����ϸ��Ϣ����",com.changba.live.room.activity.RoomInfoActivity.class);
		solo.goBack();
		
		
		//�ٱ�����
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("�ٱ�");
		solo.clickOnText("ȡ��");
		//solo.waitForText("��л��ľٱ�������Ա���Ծٱ����к�ʵ������ʵ���������Ӧ����.");	
		
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("�ٱ�");
		solo.clickOnText("ֱ�������ɫ�顢���ε�Υ������");
		solo.waitForText("��л��ľٱ�������Ա���Ծٱ����к�ʵ������ʵ���������Ӧ����.");	
		
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("�ٱ�");
		solo.clickOnText("������������");
		solo.waitForText("��л��ľٱ�������Ա���Ծٱ����к�ʵ������ʵ���������Ӧ����.");
		
		
	
		
		
		
		solo.clickOnView(live.getLiveRoomLiveInfo());
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("�ٱ�");
		solo.clickOnText("����");
		
		ClearEditText c=(ClearEditText)((RelativeLayout)solo.getView(R.id.dialog_content)).getChildAt(1);
		assertEquals(c.getHint().toString(),"������ٱ�����");
		
		solo.enterText((EditText)c, "test �ٱ���������");
		solo.clickOnText("ȷ��");
		solo.waitForText("��л��ľٱ�������Ա���Ծٱ����к�ʵ������ʵ���������Ӧ����.");
		solo.assertCurrentActivity("����ʧ��",com.changba.live.room.activity.VideoRoomActivity.class);
		
		
		
		solo.clickOnView(live.getLiveRoomMore());
		solo.clickOnText("�ٱ�");
		solo.clickOnText("����");
		
		c=(ClearEditText)((RelativeLayout)solo.getView(R.id.dialog_content)).getChildAt(1);
		solo.enterText((EditText)c, "test �ٱ���������");
		solo.clickOnText("ȡ��");
		solo.waitForDialogToClose();
		solo.assertCurrentActivity("ȡ������ʧ��",com.changba.live.room.activity.VideoRoomActivity.class);
			
		
		
	}
	

	
	
}
