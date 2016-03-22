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
		assertEquals(elementsCollections.getMyTitleView().getText(),"我的收藏");
		assertTrue(elementsCollections.getMyLeftView().isShown());
		
		solo.takeScreenshot("我的收藏页");
		if(elementsCollections.getCollectionCount(solo)==0)//直播间数量是0
		{
			assertTrue(solo.searchText("你还没有收藏任何直播间"));
			solo.takeScreenshot("无直播间时");
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
	 * 下拉刷新，判断是否有刷新提示位文本箭头图片
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
	 * 有收藏的直播间，点击进入取消收藏后返回
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
		solo.takeScreenshot("取消收藏前");
		
		solo.clickInList(0);//进入直播间
		solo.clickOnText("已收藏");
		solo.waitForText("当前直播间已从直播列表删除");
		solo.goBackToActivity("RoomListActivity");
		solo.sleep(1000);
		solo.takeScreenshot("取消收藏第"+"直播间后");
	} 
	
	
	
	
	/*
	 * 判断我页面显示的收藏数量是否与实际一致
	 */
	public void testCollectionCount(){
		uiHelper.getElementsWonderfulShow().clickOnMe();
		ElementsProfile profile=uiHelper.getElementsProfile();
		int count=profile.getCollectionCountText(uiHelper.getSolo());//我页面显示的收藏数量
		profile.clickOnCollection();
		ElementsProfileCollections elementsProfileCollections=uiHelper.getCollections();
		int realCount=elementsProfileCollections.getCollectionCount(uiHelper.getSolo());//收藏页实际的收藏房间数量
		assertEquals(count, realCount);//判断是否一致
	}
	
	public void test1AddCollection(){
		enterCollectionPage();
		ElementsProfileCollections  profileCollections=uiHelper.getCollections();
		int count=profileCollections.getCollectionCount(uiHelper.getSolo());//收藏页面的实际收藏数量
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
//			solo.clickOnText("精彩表演");//返回我页面，点击精彩表演，去添加5+r个收藏
//			newCount=elementsCollections.addCollection(solo);
//		}
//		else 
//			fail("返回键竟然是空= =");
//		//assertEquals(oldCount, newCount);
//		//assertEquals(uiHelper.getElementsProfile().getCollectionCountText(solo), oldCount+newCount);
//		enterCollectionPage();
//		System.out.println("======"+elementsCollections.getCollectionCount(solo)+"~~~~~~~~~~"+oldCount+newCount);
//		assertEquals(elementsCollections.getCollectionCount(solo), oldCount+newCount);
	}
	
}
