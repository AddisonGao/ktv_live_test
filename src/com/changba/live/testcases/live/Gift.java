package com.changba.live.testcases.live;

import android.widget.TextView;

import com.changba.live.R;
import com.changba.live.R.id;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsLive;
import com.robotium.solo.Solo;

public class Gift extends BasicTestCase {
	
	
	public void enterLivePage(){
		uiHelper.getElementsWonderfulShow().clickOnLivePage();
	}
	
	
	
	//������Ĭ��ֵ�жϲ���
	public void testGiftList(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(5000);
		
		String name0=((TextView)solo.getView(R.id.live_room_nickname)).getText().toString();//�õ���������
		
		solo.clickOnText("������");
		
		//��һ����������ƥ�����
		String s0=((TextView)solo.getView(id.gifttype,0)).getText().toString();
		String s1=((TextView)solo.getView(id.gifttype,1)).getText().toString();
		String s2=((TextView)solo.getView(id.gifttype,2)).getText().toString();
		String s3=((TextView)solo.getView(id.gifttype,3)).getText().toString();
		String s4=((TextView)solo.getView(id.gifttype,4)).getText().toString();
		String s5=((TextView)solo.getView(id.gifttype,5)).getText().toString();
		String s6=((TextView)solo.getView(id.gifttype,6)).getText().toString();
		String s7=((TextView)solo.getView(id.gifttype,7)).getText().toString();
		
		assertEquals(s0, "�ʻ�");
		assertEquals(s1, "����");
		assertEquals(s2, "�ǹ�");
		assertEquals(s3, "����");
		assertEquals(s4, "ůů");
		assertEquals(s5, "�ɿ���");
		assertEquals(s6, "����");
		assertEquals(s7, "����");
		
		//��һ������۸�ƥ��
		String n0=((TextView)solo.getView(id.count,0)).getText().toString();
		String n1=((TextView)solo.getView(id.count,1)).getText().toString();
		String n2=((TextView)solo.getView(id.count,2)).getText().toString();
		String n3=((TextView)solo.getView(id.count,3)).getText().toString();
		String n4=((TextView)solo.getView(id.count,4)).getText().toString();
		String n5=((TextView)solo.getView(id.count,5)).getText().toString();
		String n6=((TextView)solo.getView(id.count,6)).getText().toString();
		String n7=((TextView)solo.getView(id.count,7)).getText().toString();
		
		assertEquals(n0, "20����");
		assertEquals(n1, "30����");
		assertEquals(n2, "50����");
		assertEquals(n3, "100����");
		assertEquals(n4, "150����");
		assertEquals(n5, "200����");
		assertEquals(n6, "250����");
		assertEquals(n7, "300����");
		
		
		//��������Ĭ����������
		String giftname0=((TextView)solo.getView(id.target_name)).getText().toString();
		assertTrue(name0.contains(giftname0));
		
		//Ĭ��������Ŀ��1��
		String giftnumber0=((TextView)solo.getView(id.cnt_value)).getText().toString();
		int giftnum0=Integer.parseInt(giftnumber0);
		assertEquals(1, giftnum0);
		
		
		
		
		
		
		solo.sleep(1000);
		solo.scrollToSide(solo.RIGHT);
		
		//��2����������ƥ�����
		String s10=((TextView)solo.getView(id.gifttype,8)).getText().toString();
		String s11=((TextView)solo.getView(id.gifttype,9)).getText().toString();
		String s12=((TextView)solo.getView(id.gifttype,10)).getText().toString();
		String s13=((TextView)solo.getView(id.gifttype,11)).getText().toString();
		String s14=((TextView)solo.getView(id.gifttype,12)).getText().toString();
		String s15=((TextView)solo.getView(id.gifttype,13)).getText().toString();
		String s16=((TextView)solo.getView(id.gifttype,14)).getText().toString();
		String s17=((TextView)solo.getView(id.gifttype,15)).getText().toString();
				
		assertEquals(s10, "��Ͳ");
		assertEquals(s11, "��ˮ");
		assertEquals(s12, "���ζ�");
		assertEquals(s13, "���");
		assertEquals(s14, "����");
		assertEquals(s15, "������");
		assertEquals(s16, "CB709");
		assertEquals(s17, "����");
				
		//��2������۸�ƥ��
		String n10=((TextView)solo.getView(id.count,8)).getText().toString();
		String n11=((TextView)solo.getView(id.count,9)).getText().toString();
		String n12=((TextView)solo.getView(id.count,10)).getText().toString();
		String n13=((TextView)solo.getView(id.count,11)).getText().toString();
		String n14=((TextView)solo.getView(id.count,12)).getText().toString();
		String n15=((TextView)solo.getView(id.count,13)).getText().toString();
		String n16=((TextView)solo.getView(id.count,14)).getText().toString();
		String n17=((TextView)solo.getView(id.count,15)).getText().toString();
				
		assertEquals(n10, "500����");
		assertEquals(n11, "1000����");
		assertEquals(n12, "2000����");
		assertEquals(n13, "3000����");
		assertEquals(n14, "5000����");
		assertEquals(n15, "10000����");
		assertEquals(n16, "20000����");
		assertEquals(n17, "50000����");
		
		
		
		
		
	}

	//��ֵ�����ת���� ����������
	public void testCoinsPage(){
			
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();			
		solo.sleep(5000);
			
		solo.clickOnText("������");
		solo.sleep(1000);
		String coins=((TextView)solo.getView(R.id.live_room_balance)).getText().toString();
		
		solo.clickOnText("��ֵ");
		solo.assertCurrentActivity("��ת��ֵҳ��ʧ��", com.changba.live.activity.MyCoinsActivity.class);
		solo.sleep(1000);
		String coinnum=((TextView)solo.getView(R.id.coin_num)).getText().toString();
		assertEquals(coins, coinnum);
			
			
		solo.sleep(1000);
		solo.clickOnView(solo.getView(id.my_lefttview));
		solo.assertCurrentActivity("�ӳ�ֵҳ�淵��ֱ��ҳ��ʧ��", com.changba.live.room.activity.VideoRoomActivity.class);
			
			
			
			
	}

	
	
	
	
	
	
	
	/*��������ѡ�� ���������ѡ�� ����
	public void testGiftNumName(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(5000);
		
		solo.clickOnText("������");
		solo.clickOnView(live.getCntValue());
		
		
	}*/
	
	
	
	
	
}


