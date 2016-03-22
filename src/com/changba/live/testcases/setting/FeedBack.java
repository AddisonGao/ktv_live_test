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
	 * 进入反馈页
	 */
	public void enterFeedBack(){
		uiHelper.getElementsWonderfulShow().clickOnMe();
		uiHelper.getElementsProfile().clickOnSetting();
		uiHelper.getElementsSetting().clickOnFeedBack();
	}
	 public void testFeedBackShow(){
		 enterFeedBack();
		 Solo solo=uiHelper.getSolo();
		 solo.takeScreenshot("意见反馈页");
		 ElementsSettingFeedBack settingFeedBack=uiHelper.getElementsSettingFeedBack();
		 assertEquals("意见反馈",(settingFeedBack.getMyTitleView()).getText());//页面标题
		 assertEquals("取消",(settingFeedBack.getMyLeftView()).getText());
		 assertEquals("发送",(settingFeedBack.getMyRightView()).getText());
		 assertEquals("你的每条反馈我们都会仔细阅读，但我们无法保证每一条都能及时回复，如果你有紧急问题需要咨询，"
					+ "请直接到官方微博或客服QQ上联系我们，感谢你的理解",(settingFeedBack.getPublishText()).getHint());
		 assertEquals(140,Integer.parseInt((String) (settingFeedBack.getWordsTips()).getText()));//字数提示文本
	 }
	 /**
	  * 空内容发送
	  */
	 public void testSendNothing(){
		 enterFeedBack();
		 Solo solo=uiHelper.getSolo();
		 ElementsSettingFeedBack settingFeedBack=uiHelper.getElementsSettingFeedBack();
		 settingFeedBack.clickOnSend();
		 solo.waitForText("不能发送空内容");
	 }
	 public void testCancel(){
		 enterFeedBack();
		 ElementsSettingFeedBack settingFeedBack=uiHelper.getElementsSettingFeedBack();
		 settingFeedBack.clickOnCancel(); 
	 }
	 
	 /**
	  * 发送少于140字
	  */
	 public void testSendLessThan140(){
		 enterFeedBack();
		 Solo solo=uiHelper.getSolo();
		 solo.sleep(300);
		 ElementsSettingFeedBack settingFeedBack=uiHelper.getElementsSettingFeedBack();
		 int random=new Random().nextInt(140);
		 settingFeedBack.typeWords(random);
	    //右下角的提示数字是否等于140-输入的字数
		 //System.out.println(Integer.parseInt((String) (settingFeedBack.getWordsTips()).getText())+"=======================size");
		 assertEquals(140-random,Integer.parseInt((String) (settingFeedBack.getWordsTips()).getText()));
		 solo.takeScreenshot("随机输入140以内的随机字符");
		 settingFeedBack.clickOnSend();
		 solo.waitForText("发送成功，感谢你宝贵的意见",1, 1000);
		 solo.takeScreenshot("发送成功后");
	}
	 
	 /**
	 *当已输入140字时，继续输入发送50以内的字符串，判断左下是否仍为0，edittext的显示字符串仍为140
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
