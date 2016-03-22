package com.changba.live.testcases.setting;

import java.util.ArrayList;
import java.util.Random;

import com.changba.live.R;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsSettingInfoPush;
import com.changba.widget.UISwitchButton;
import com.robotium.solo.Solo;

public class InfoPush extends BasicTestCase {

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	/**
	 * ������������ҳ
	 */
	public void enterInfoPush(){
		uiHelper.getElementsWonderfulShow().clickOnMe();
		uiHelper.getElementsProfile().clickOnSetting();
		uiHelper.getElementsSetting().clickOnInfoPush();
	}
	/**
	 * �ж���������ҳ����ʾ
	 */
	public void testInfoPushShow(){//���۽����������ѿ����Ƿ񿪹ض����ж�
		enterInfoPush();
		Solo solo=uiHelper.getSolo();
		ElementsSettingInfoPush settingInfoPush=uiHelper.getElementsSettingInfoPush();
		solo.takeScreenshot("��������ҳ");
		assertTrue(settingInfoPush.judgeTheTitle());//�жϱ����Ƿ�Ϊ��������ҳ
		assertTrue(settingInfoPush.getMyLeftView().isShown());//����ͼ��
		assertFalse(settingInfoPush.getMyRightView()==null);
		assertTrue(settingInfoPush.judgeTheItem()&&settingInfoPush.getText());//�ж�ÿһ���ı����Ƿ���ȷ,�Լ����ѷ�ʽ�������ʱ��
	}
	
	/**
	 * ����ʹ��,��������������֮һ��������ҳ�ٴν�������ҳ ǰ���Ƿ�һ�¡�
	 */
	public void testChangeSwitchState(){
		enterInfoPush();
		Solo solo=uiHelper.getSolo();
		ElementsSettingInfoPush settingInfoPush=uiHelper.getElementsSettingInfoPush();
		if(!settingInfoPush.getText())//�������ѿ���Ϊ��
		{	settingInfoPush.clickOnAgreePush();
		    boolean a[]=getSwitchState(solo);
			settingInfoPush.clickOnRandomSwitch();
			solo.takeScreenshot("�ı俪��״̬");
			settingInfoPush.clickOnLeftBack();//������ϽǷ����ж��Ƿ񷵻�����ҳ
			assertTrue("com.changba.live.activity.settingactivity is not found!", solo.waitForActivity(com.changba.live.activity.SettingActivity.class));
			solo.waitForText("���óɹ�");
//			uiHelper.getElementsSetting().clickOnInfoPush();
			solo.clickOnView(solo.getView(R.id.txt_left, 1));//����������
			assertTrue(judgeSwitchState(solo, a));;
			solo.takeScreenshot("�ı���˳��ٴν���");
		}
		else//���ܿ���Ϊ��
		{
			settingInfoPush.clickOnRandomSwitch();
			boolean a[]=getSwitchState(solo);
			solo.takeScreenshot("�ı俪��״̬");
			settingInfoPush.clickOnLeftBack();//������ϽǷ����ж��Ƿ񷵻�����ҳ
			assertTrue("com.changba.live.activity.settingactivity is not found!", solo.waitForActivity(com.changba.live.activity.SettingActivity.class));
			solo.waitForText("���óɹ�");
			solo.clickOnView(solo.getView(R.id.txt_left, 1));//����������
			assertTrue(judgeSwitchState(solo, a));
			solo.takeScreenshot("�ı���˳��ٴν���");
		}
	}
	public boolean[] getSwitchState(Solo solo){
		boolean a[]=new boolean[3];
		for(int i=0;i<3;i++)
		{
			a[i]=((UISwitchButton)solo.getView(R.id.switch_right,i)).isChecked();
		}
		return a;
	}
	public boolean judgeSwitchState(Solo solo,boolean a[]){
		boolean flag=true;
		for(int i=0;i<a.length;i++)
		{
			if((UISwitchButton)solo.getView(R.id.switch_right,i)!=null){
				if(((UISwitchButton)solo.getView(R.id.switch_right,i)).isChecked()!=a[i])
					flag=false;
			}
		}
		return flag;
	}
}
