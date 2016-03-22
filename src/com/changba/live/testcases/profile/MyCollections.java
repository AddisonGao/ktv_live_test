package com.changba.live.testcases.profile;

import java.util.Random;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.changba.live.R;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsProfile;
import com.changba.live.test.elements.ElementsProfileCollections;
import com.changba.widget.pulltorefresh.PullToRefreshListView;
import com.robotium.solo.Solo;

public class MyCollections extends BasicTestCase {

	public void enterCollectionPage(){
		uiHelper.getElementsWonderfulShow().clickOnMe();
		uiHelper.getElementsProfile().clickOnCollection();
	}
	
	public void testCollectionShow(){
		enterCollectionPage();
		Solo solo=uiHelper.getSolo();
		solo.sleep(1000);
		ElementsProfileCollections elementsCollections=uiHelper.getCollections();
		assertEquals(elementsCollections.getMyTitleView().getText(),"�ҵ��ղ�");
		assertTrue(elementsCollections.getMyLeftView().isShown());
		
		solo.takeScreenshot("�ҵ��ղ�ҳ");
		if(elementsCollections.getCollectionCount(solo)==0)//ֱ����������0
		{
			assertTrue(solo.searchText("�㻹û���ղ��κ�ֱ����"));
			solo.takeScreenshot("��ֱ����ʱ");
		}else{
			assertNotNull(elementsCollections.getLiveRoomListItemImg());
			assertNotNull(elementsCollections.getLiveRoomListItemToptView());
			assertNotNull(elementsCollections.getRoomCount());
			assertNotNull(elementsCollections.getRoomListItemLevelTxt());
			assertNotNull(elementsCollections.getRoomListItemRoomIdTxt());
			assertNotNull(elementsCollections.getRoomStatus());
		}
	}
	
	/*
	 * 
	 * ����ˢ�£��ж��Ƿ���ˢ����ʾλ�ı���ͷͼƬ
	 */
	public void testPullToRefresh(){
		enterCollectionPage();
		ElementsProfileCollections elementsCollections=uiHelper.getCollections();
		Solo solo=uiHelper.getSolo();
		solo.scrollDown();
		solo.waitForView(elementsCollections.getPullToRefreshImage());
		solo.waitForView(elementsCollections.getPullToRefreshProgress());
		solo.waitForView(elementsCollections.getPullToRefreshSubText());
		solo.waitForView(elementsCollections.getPullToRefreshText());
	}
	
	/**
	 * ���ղص�ֱ���䣬�������ȡ���ղغ󷵻�
	 * @param solo
	 * @return
	 */
	public void testCancelCollection(){
		enterCollectionPage();
		ElementsProfileCollections elementsCollections=uiHelper.getCollections();
		Solo solo=uiHelper.getSolo();
		solo.sleep(300);
		int count=elementsCollections.getCollectionCount(solo);
		if(count==0|count<5){
			count=elementsCollections.addCollection(solo);
			enterCollectionPage();
		}
		solo.takeScreenshot("ȡ���ղ�ǰ");
		
		solo.clickInList(0);//����ֱ����
		solo.clickOnText("���ղ�");
		solo.waitForText("��ǰֱ�����Ѵ�ֱ���б�ɾ��");
		solo.goBackToActivity("RoomListActivity");
		solo.sleep(1000);
		solo.takeScreenshot("ȡ���ղص�"+"ֱ�����");
	} 
	
	
	
	
	/*
	 * �ж���ҳ����ʾ���ղ������Ƿ���ʵ��һ��
	 */
	public void testCollectionCount(){
		uiHelper.getElementsWonderfulShow().clickOnMe();
		ElementsProfile profile=uiHelper.getElementsProfile();
		int count=profile.getCollectionCountText(uiHelper.getSolo());//��ҳ����ʾ���ղ�����
		profile.clickOnCollection();
		ElementsProfileCollections elementsProfileCollections=uiHelper.getCollections();
		int realCount=elementsProfileCollections.getCollectionCount(uiHelper.getSolo());//�ղ�ҳʵ�ʵ��ղط�������
		assertEquals(count, realCount);//�ж��Ƿ�һ��
	}
	
	public void test1AddCollection(){
		enterCollectionPage();
		ElementsProfileCollections  profileCollections=uiHelper.getCollections();
		int count=profileCollections.getCollectionCount(uiHelper.getSolo());//�ղ�ҳ���ʵ���ղ�����
		profileCollections.goToWonderfulShow();
		
//		enterCollectionPage();
//		Solo solo=uiHelper.getSolo();
//		ElementsProfileCollections elementsCollections=uiHelper.getCollections();
//		int oldCount=elementsCollections.getCollectionCount(solo);
//		int newCount=0;
//		solo.sleep(1000);
//		if(solo.waitForView(R.id.my_lefttview))
//		{
//			solo.clickOnView(solo.getView(R.id.my_lefttview));
//			solo.clickOnText("���ʱ���");//������ҳ�棬������ʱ��ݣ�ȥ���5+r���ղ�
//			newCount=elementsCollections.addCollection(solo);
//		}
//		else 
//			fail("���ؼ���Ȼ�ǿ�= =");
//		//assertEquals(oldCount, newCount);
//		//assertEquals(uiHelper.getElementsProfile().getCollectionCountText(solo), oldCount+newCount);
//		enterCollectionPage();
//		System.out.println("======"+elementsCollections.getCollectionCount(solo)+"~~~~~~~~~~"+oldCount+newCount);
//		assertEquals(elementsCollections.getCollectionCount(solo), oldCount+newCount);
	}
	
}
