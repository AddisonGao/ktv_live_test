package com.changba.live.testcases.setting;

import java.util.Random;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsSettingFeedBack;
import com.robotium.solo.Solo;

public class FeedBack extends BasicTestCase {

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	/**
	 * ���뷴��ҳ
	 */
	public void enterFeedBack(){
		uiHelper.getElementsWonderfulShow().clickOnMe();
		uiHelper.getElementsProfile().clickOnSetting();
		uiHelper.getElementsSetting().clickOnFeedBack();
	}
	 public void testFeedBackShow(){
		 enterFeedBack();
		 Solo solo=uiHelper.getSolo();
		 solo.takeScreenshot("�������ҳ");
		 ElementsSettingFeedBack settingFeedBack=uiHelper.getElementsSettingFeedBack();
		 assertEquals("�������",(settingFeedBack.getMyTitleView()).getText());//ҳ�����
		 assertEquals("ȡ��",(settingFeedBack.getMyLeftView()).getText());
		 assertEquals("����",(settingFeedBack.getMyRightView()).getText());
		 assertEquals("���ÿ���������Ƕ�����ϸ�Ķ����������޷���֤ÿһ�����ܼ�ʱ�ظ���������н���������Ҫ��ѯ��"
					+ "��ֱ�ӵ��ٷ�΢����ͷ�QQ����ϵ���ǣ���л������",(settingFeedBack.getPublishText()).getHint());
		 assertEquals(140,Integer.parseInt((String) (settingFeedBack.getWordsTips()).getText()));//������ʾ�ı�
	 }
	 /**
	  * �����ݷ���
	  */
	 public void testSendNothing(){
		 enterFeedBack();
		 Solo solo=uiHelper.getSolo();
		 ElementsSettingFeedBack settingFeedBack=uiHelper.getElementsSettingFeedBack();
		 settingFeedBack.clickOnSend();
		 solo.waitForText("���ܷ��Ϳ�����");
	 }
	 public void testCancel(){
		 enterFeedBack();
		 ElementsSettingFeedBack settingFeedBack=uiHelper.getElementsSettingFeedBack();
		 settingFeedBack.clickOnCancel(); 
	 }
	 
	 /**
	  * ��������140��
	  */
	 public void testSendLessThan140(){
		 enterFeedBack();
		 Solo solo=uiHelper.getSolo();
		 solo.sleep(300);
		 ElementsSettingFeedBack settingFeedBack=uiHelper.getElementsSettingFeedBack();
		 int random=new Random().nextInt(140);
		 settingFeedBack.typeWords(random);
	    //���½ǵ���ʾ�����Ƿ����140-���������
		 //System.out.println(Integer.parseInt((String) (settingFeedBack.getWordsTips()).getText())+"=======================size");
		 assertEquals(140-random,Integer.parseInt((String) (settingFeedBack.getWordsTips()).getText()));
		 solo.takeScreenshot("�������140���ڵ�����ַ�");
		 settingFeedBack.clickOnSend();
		 solo.waitForText("���ͳɹ�����л�㱦������",1, 1000);
		 solo.takeScreenshot("���ͳɹ���");
	}
	 
	 /**
	 *��������140��ʱ���������뷢��50���ڵ��ַ������ж������Ƿ���Ϊ0��edittext����ʾ�ַ�����Ϊ140
	 */
	 public void testSendMoreThan140()
	 {
		 enterFeedBack();
		 Solo solo=uiHelper.getSolo();
		 solo.sleep(300);
		 ElementsSettingFeedBack settingFeedBack=uiHelper.getElementsSettingFeedBack();
		 settingFeedBack.typeWords(140+new Random().nextInt(50));
		 assertEquals(0,Integer.parseInt((String) (settingFeedBack.getWordsTips()).getText()));
		 assertEquals(140,settingFeedBack.getPublishText().length());
	}
}
