package com.changba.live.test.otherprofile;

import android.R.integer;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.changba.live.R.id;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsLive;
import com.changba.live.test.elements.ElementsOtherProfile;
import com.changba.widget.pulltorefresh.PullToRefreshListView;
import com.robotium.solo.Solo;

public class OtherProfile extends BasicTestCase  {
	
	
	public void clickOnOtherProfile(){
		uiHelper.getElementsOtherProfile().clickOnOtherPersonProfile();
	}
	
	//������һҳ����� �ҵĹ�ע
	public void testBackPage(){
		
		Solo solo=uiHelper.getSolo();
		ElementsOtherProfile otherProfile=uiHelper.getElementsOtherProfile();
		clickOnOtherProfile();
		solo.sleep(1000);
		
		solo.clickOnView(solo.getView(id.btn_back));
		solo.sleep(1000);
		solo.assertCurrentActivity("�����˷��ص���עҳ��ʧ��",com.changba.live.activity.UserListActivity.class);		
	}
	
	
	/*���컽�𳪰�
	public void testChat(){
		
		Solo solo=uiHelper.getSolo();
		ElementsOtherProfile otherProfile=uiHelper.getElementsOtherProfile();
		clickOnOtherProfile();
		solo.sleep(500);
		String name0=otherProfile.getUserName().getText().toString();
		
		solo.clickOnView(otherProfile.getBtnChat());
		solo.sleep(2000);
		
		
	}
	*/
	//��ע��������
	public void testFollow(){
		
		Solo solo=uiHelper.getSolo();
		ElementsOtherProfile otherProfile=uiHelper.getElementsOtherProfile();
		clickOnOtherProfile();
		solo.sleep(500);
		
		String followWord=((TextView)solo.getView(id.btn_follow)).getText().toString();
		assertEquals("ȡ����ע",followWord);
		
		solo.clickOnText("ȡ����ע");
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.go_on_btn));
		solo.waitForDialogToClose();
		
		String followWord1=((TextView)solo.getView(id.btn_follow)).getText().toString();
		assertEquals("ȡ����ע",followWord1);
		
		solo.clickOnText("ȡ����ע");
		solo.waitForDialogToOpen();
		solo.clickOnView(solo.getView(id.confirm_btn));
		solo.waitForDialogToClose();
		solo.waitForText("ȡ����ע�ɹ���");
		solo.sleep(2500);
		
		
		String followWord2=((TextView)solo.getView(id.btn_follow)).getText().toString();
		assertEquals("��ע",followWord2);
		
		
		solo.clickOnText("��ע");
		solo.waitForText("��ע�ɹ���");
		
		String followWord3=((TextView)solo.getView(id.btn_follow)).getText().toString();
		assertEquals("ȡ����ע",followWord3);
		
		
		
		
	}
	
	
	public void testLevel(){
		
		Solo solo=uiHelper.getSolo();
		ElementsOtherProfile otherProfile=uiHelper.getElementsOtherProfile();
		clickOnOtherProfile();
		solo.sleep(2000);
		
		String name0=((TextView)solo.getView(id.username)).getText().toString();
		
		solo.clickOnText("�ȼ�");
		solo.sleep(500);
		solo.assertCurrentActivity("����ȼ�ҳ��ʧ��", com.changba.live.activity.LevelRankActivity.class);
		String title0=((TextView)solo.getView(id.level_title)).getText().toString();
		assertEquals(name0+"�ĵȼ�", title0);
		solo.clickOnView(solo.getView(id.my_lefttview));
		solo.sleep(500);
		solo.assertCurrentActivity("����ʧ��", com.changba.live.activity.CommonFragmentActivity.class);
		
		solo.clickOnText("�Ƹ��ȼ�");
		solo.sleep(500);
		solo.assertCurrentActivity("����Ƹ��ȼ�ҳ��ʧ��", com.changba.live.activity.LevelRankActivity.class);
		String title1=((TextView)solo.getView(id.level_title)).getText().toString();
		assertEquals(name0+"�ĲƸ��ȼ�", title1);
		solo.clickOnView(solo.getView(id.my_lefttview));
		solo.sleep(500);
		solo.assertCurrentActivity("����ʧ��", com.changba.live.activity.CommonFragmentActivity.class);
		
		
		
		
	}
	
	
	
	
	
	
	/*��˿ ��ע��Ŀ ����
	
	public void testNum(){
		
		Solo solo=uiHelper.getSolo();
		ElementsOtherProfile otherProfile=uiHelper.getElementsOtherProfile();
		clickOnOtherProfile();
		solo.sleep(2000);
		
		String name0=((TextView)solo.getView(id.username)).getText().toString();
		
		String num0=((TextView)solo.getView(id.txt_left_right,7)).getText().toString();
		System.out.println(num0+"==========================="+((TextView)solo.getView(id.txt_left,3)).getText().toString());
		String number0=num0.substring(1, num0.length()-1);
		int numberint0=Integer.parseInt(number0);//��˿��
		
		String num1=((TextView)solo.getView(id.txt_left_right,8)).getText().toString();
		String number1=num1.substring(1, num1.length()-1);
		int numberint1=Integer.parseInt(number1);//��ע��
		
		solo.clickOnText("��˿");
		solo.assertCurrentActivity("�����˿�б�ʧ��",com.changba.live.activity.UserListActivity.class);
		solo.sleep(1000);
		String title0=((TextView)solo.getView(id.my_titleview)).getText().toString();
		
		int count0=((ListView)(((FrameLayout)(((PullToRefreshListView)solo.getView(id.listview)).getChildAt(1))).getChildAt(0))).getChildCount();
		assertEquals(numberint0, count0);
		
		solo.clickOnView(solo.getView(id.my_lefttview));
		solo.sleep(1000);
		
		solo.clickOnText("��ע");
		solo.assertCurrentActivity("�����ע�б�ʧ��",com.changba.live.activity.UserListActivity.class);
		solo.sleep(1000);
		
		int count1=((ListView)(((FrameLayout)(((PullToRefreshListView)solo.getView(id.listview)).getChildAt(1))).getChildAt(0))).getChildCount();
		assertEquals(numberint1, count1);
		
		
		
		
		
	}
	*/
	
	
	
	

}
