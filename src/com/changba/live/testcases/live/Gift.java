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
	
	
	
	//礼物栏默认值判断测试
	public void testGiftList(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(5000);
		
		String name0=((TextView)solo.getView(R.id.live_room_nickname)).getText().toString();//得到主播名字
		
		solo.clickOnText("送礼物");
		
		//第一栏礼物名称匹配测试
		String s0=((TextView)solo.getView(id.gifttype,0)).getText().toString();
		String s1=((TextView)solo.getView(id.gifttype,1)).getText().toString();
		String s2=((TextView)solo.getView(id.gifttype,2)).getText().toString();
		String s3=((TextView)solo.getView(id.gifttype,3)).getText().toString();
		String s4=((TextView)solo.getView(id.gifttype,4)).getText().toString();
		String s5=((TextView)solo.getView(id.gifttype,5)).getText().toString();
		String s6=((TextView)solo.getView(id.gifttype,6)).getText().toString();
		String s7=((TextView)solo.getView(id.gifttype,7)).getText().toString();
		
		assertEquals(s0, "鲜花");
		assertEquals(s1, "掌声");
		assertEquals(s2, "糖果");
		assertEquals(s3, "香槟");
		assertEquals(s4, "暖暖");
		assertEquals(s5, "巧克力");
		assertEquals(s6, "咖啡");
		assertEquals(s7, "蛋糕");
		
		//第一栏礼物价格匹配
		String n0=((TextView)solo.getView(id.count,0)).getText().toString();
		String n1=((TextView)solo.getView(id.count,1)).getText().toString();
		String n2=((TextView)solo.getView(id.count,2)).getText().toString();
		String n3=((TextView)solo.getView(id.count,3)).getText().toString();
		String n4=((TextView)solo.getView(id.count,4)).getText().toString();
		String n5=((TextView)solo.getView(id.count,5)).getText().toString();
		String n6=((TextView)solo.getView(id.count,6)).getText().toString();
		String n7=((TextView)solo.getView(id.count,7)).getText().toString();
		
		assertEquals(n0, "20播币");
		assertEquals(n1, "30播币");
		assertEquals(n2, "50播币");
		assertEquals(n3, "100播币");
		assertEquals(n4, "150播币");
		assertEquals(n5, "200播币");
		assertEquals(n6, "250播币");
		assertEquals(n7, "300播币");
		
		
		//主播名字默认在礼物栏
		String giftname0=((TextView)solo.getView(id.target_name)).getText().toString();
		assertTrue(name0.contains(giftname0));
		
		//默认赠送数目是1个
		String giftnumber0=((TextView)solo.getView(id.cnt_value)).getText().toString();
		int giftnum0=Integer.parseInt(giftnumber0);
		assertEquals(1, giftnum0);
		
		
		
		
		
		
		solo.sleep(1000);
		solo.scrollToSide(solo.RIGHT);
		
		//第2栏礼物名称匹配测试
		String s10=((TextView)solo.getView(id.gifttype,8)).getText().toString();
		String s11=((TextView)solo.getView(id.gifttype,9)).getText().toString();
		String s12=((TextView)solo.getView(id.gifttype,10)).getText().toString();
		String s13=((TextView)solo.getView(id.gifttype,11)).getText().toString();
		String s14=((TextView)solo.getView(id.gifttype,12)).getText().toString();
		String s15=((TextView)solo.getView(id.gifttype,13)).getText().toString();
		String s16=((TextView)solo.getView(id.gifttype,14)).getText().toString();
		String s17=((TextView)solo.getView(id.gifttype,15)).getText().toString();
				
		assertEquals(s10, "金话筒");
		assertEquals(s11, "香水");
		assertEquals(s12, "香奈儿");
		assertEquals(s13, "钻戒");
		assertEquals(s14, "项链");
		assertEquals(s15, "法拉利");
		assertEquals(s16, "CB709");
		assertEquals(s17, "湾流");
				
		//第2栏礼物价格匹配
		String n10=((TextView)solo.getView(id.count,8)).getText().toString();
		String n11=((TextView)solo.getView(id.count,9)).getText().toString();
		String n12=((TextView)solo.getView(id.count,10)).getText().toString();
		String n13=((TextView)solo.getView(id.count,11)).getText().toString();
		String n14=((TextView)solo.getView(id.count,12)).getText().toString();
		String n15=((TextView)solo.getView(id.count,13)).getText().toString();
		String n16=((TextView)solo.getView(id.count,14)).getText().toString();
		String n17=((TextView)solo.getView(id.count,15)).getText().toString();
				
		assertEquals(n10, "500播币");
		assertEquals(n11, "1000播币");
		assertEquals(n12, "2000播币");
		assertEquals(n13, "3000播币");
		assertEquals(n14, "5000播币");
		assertEquals(n15, "10000播币");
		assertEquals(n16, "20000播币");
		assertEquals(n17, "50000播币");
		
		
		
		
		
	}

	//充值点击跳转测试 播币余额测试
	public void testCoinsPage(){
			
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();			
		solo.sleep(5000);
			
		solo.clickOnText("送礼物");
		solo.sleep(1000);
		String coins=((TextView)solo.getView(R.id.live_room_balance)).getText().toString();
		
		solo.clickOnText("充值");
		solo.assertCurrentActivity("跳转充值页面失败", com.changba.live.activity.MyCoinsActivity.class);
		solo.sleep(1000);
		String coinnum=((TextView)solo.getView(R.id.coin_num)).getText().toString();
		assertEquals(coins, coinnum);
			
			
		solo.sleep(1000);
		solo.clickOnView(solo.getView(id.my_lefttview));
		solo.assertCurrentActivity("从充值页面返回直播页面失败", com.changba.live.room.activity.VideoRoomActivity.class);
			
			
			
			
	}

	
	
	
	
	
	
	
	/*礼物数量选择 送礼物对象选择 测试
	public void testGiftNumName(){
		
		enterLivePage();
		Solo solo=uiHelper.getSolo();
		ElementsLive live=uiHelper.getElementsLive();
		solo.sleep(5000);
		
		solo.clickOnText("送礼物");
		solo.clickOnView(live.getCntValue());
		
		
	}*/
	
	
	
	
	
}


