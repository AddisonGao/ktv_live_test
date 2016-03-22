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
		
	//���� �Դ��˵��������
	public void testPublicAllChat(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(1000);
		solo.clickOnText("��������");
		assertEquals(live.getPostComment().getHint(),"�Դ��˵");//�жϹ��������Ԥ���İ�
			
		solo.enterText(live.getPostComment(), "test ��������");//���뵥�����ֲ���
		solo.clickOnText("����");
		
		if(((TextView)solo.getView(R.id.live_room_pubic_chat_item_username)).getText().toString().equals("��")){
			assertEquals("ʧ��", "test ��������", ((TextView)solo.getView(R.id.live_room_pubic_chat_item_down_txt)).getText().toString());
		}
	}

	
	
	//ͨ�������ǩ��һ�û�����
	public void testPublicIconChat(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(1000);
		
		//ȡ��һ���û���Ϊ����
		String name0=((TextView)solo.getView(id.live_room_pubic_chat_item_username,0)).getText().toString();
		solo.clickOnView(solo.getView(id.live_room_pubic_chat_item_sender_head_img,0));
		solo.clickOnText("������TA˵");
		//���ԶԻ������Ԥ���İ��� �����Ƿ���ѡ�е��û�����һ��
		solo.searchText("��"+name0+"˵");
		
		solo.enterText(live.getPostComment(), "test2");
		solo.clickOnText("����");
		String nameshort;
		if (name0.length()>=7){
			 nameshort=name0.substring(0, 7)+"...";
		}
		else
			 nameshort=name0;
		
		
		for(int i=0;i>=0;i++)
		{
			if(((TextView)solo.getView(R.id.live_room_pubic_chat_item_username,i)).getText().toString().contains("�� �� "+nameshort+"˵��")){
				assertEquals("ʧ��", "test2", ((TextView)solo.getView(R.id.live_room_pubic_chat_item_down_txt,i)).getText().toString());
			}
			break;
		}
		
		
		
		
	}


	//ͨ�����ĳһ�й������� �Ը��û�����
	public void testPublicTextChat(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(1000);
		
		//ȡ��һ���û���Ϊ���� ������һ����Ϣ���лظ�
		String name0=((TextView)solo.getView(id.live_room_pubic_chat_item_username,0)).getText().toString();
		solo.clickOnView(solo.getView(id.live_room_pubic_chat_item_down_txt,0));
		
		//���ԶԻ������Ԥ���İ��� �����Ƿ���ѡ�е��û�����һ��
		solo.searchText("��"+name0+"˵");
		
		solo.enterText(live.getPostComment(), "test3");
		solo.clickOnText("����");
		
		String nameshort;
		if (name0.length()>=7){
			 nameshort=name0.substring(0, 7)+"...";
		}
		else
			 nameshort=name0;
		
		
		for(int i=0;i>=0;i++)
		{
			if(((TextView)solo.getView(R.id.live_room_pubic_chat_item_username,i)).getText().toString().contains("�� �� "+nameshort+"˵��")){
				assertEquals("ʧ��", "test3", ((TextView)solo.getView(R.id.live_room_pubic_chat_item_down_txt,i)).getText().toString());
			}
			break;
		}
		
		
		
		
	}
	
}





