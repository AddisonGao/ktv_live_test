package com.changba.live.testcases.profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.widget.TextView;

import com.changba.live.R;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsProfile;
import com.changba.live.test.elements.ElementsWonderfulShow;
import com.robotium.solo.Solo;

public class MyProfileShow extends BasicTestCase {
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	public void testEnterMyProfile(){
		Solo solo=uiHelper.getSolo();
		//��ͼ����·���ɱ��棿
		//solo.getConfig().screenshotSavePath="�ҵ���ҳ";
		solo.takeScreenshot("����ҳ");
		uiHelper.getElementsWonderfulShow().clickOnMe();
		assertTrue(solo.waitForActivity(com.changba.live.activity.HomeFragmentTabs.class));
		ElementsProfile profile=uiHelper.getElementsProfile();
		solo.takeScreenshot("��");
		solo.scrollToBottom();
		solo.takeScreenshot("��ҳ���»�");
		judgeShow(profile,solo);
	}
	public void judgeShow(ElementsProfile profile,Solo solo){
		assertTrue(profile.getBtnEdit().isShown());//�༭����
		assertFalse(profile.getBtnChat().isShown());//����
		assertTrue(profile.getMoreInfoLayout().isShown());//��������
		assertFalse(profile.getBtnFollow().isShown());//��ע
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("�ȼ�");
		list.add("�Ƹ��ȼ�");
		list.add("��Ϣ");
		list.add("����");
		list.add("����");
		list.add("�ҵ�ֱ����");
		list.add("�ղ�");
		list.add("��˿");
		list.add("��ע");
		for(int i=0;i<list.size();i++){
			assertEquals(((TextView)solo.getView(R.id.txt_left,i)).getText(), list.get(i));
		}
		//�ж��ҵ�ֱ����״̬�Ƿ��������֮һ
		String[] strArray = {"����Ϣ�У�","������ֱ����","����Ϊ������ֱͨ���䣩"};  
		List<String> fauCodeList = new ArrayList<String>();
		fauCodeList=Arrays.asList(strArray);
		assertTrue(fauCodeList.contains(((TextView)solo.getView(R.id.txt_left_right,5)).getText())==true);
	}
	
}
