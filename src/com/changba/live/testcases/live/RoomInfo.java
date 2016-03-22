package com.changba.live.testcases.live;

import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.changba.live.R;
import com.changba.live.R.id;
import com.changba.live.test.BasicTestCase;
import com.changba.live.test.elements.ElementsLive;
import com.changba.widget.LoadMoreListView;
import com.changba.widget.pulltorefresh.PullToRefreshListView;
import com.robotium.solo.Solo;

public class RoomInfo extends BasicTestCase {

	public void enterLivePage(){
		uiHelper.getElementsWonderfulShow().clickOnLivePage();
	}
	
	//���˷�����Ϣ��������
	
		public void testList(){
			
			enterLivePage();
			Solo solo=uiHelper.getSolo();
			ElementsLive live=uiHelper.getElementsLive();
			solo.sleep(5000);
			
			
			//����űȶ�
			String num0=((TextView)live.getLiveRoomTitleMiddleButtom()).getText().toString();
			String num1=num0.substring(3);
			
			
			//ֱ���乫��
			
			//solo.scrollListToTop(0);
			//solo.scrollToSide(Solo.LEFT);
			String s0=(String) ((TextView)solo.getView(R.id.live_room_pubic_chat_item_system_txt,0)).getText();
			//solo.scrollDown();
			solo.clickOnView(live.getLiveRoomLiveInfo());
			solo.clickOnView(live.getLiveRoomMore());
			solo.clickOnText("������Ϣ");
			
			String roomnum0=((TextView)solo.getView(id.room_number)).getText().toString();
			assertEquals(num1, roomnum0);
			
			String roomremark0=((TextView)solo.getView(id.room_remark)).getText().toString();
			assertEquals(s0, "�� ���乫�桿\n"+roomremark0);
			
			//����Ա��Ŀƥ��
			String admin=(String) ((Button)solo.getView(id.btn_admin_detail)).getText().toString();
			String adminnum0=admin.substring(4,5);
			int adminnum=Integer.parseInt(adminnum0);
			solo.clickOnText("����Ա");//�������Ա����
			solo.assertCurrentActivity("�������Ա����ʧ��", com.changba.live.activity.AdminListActivity.class);
			
			solo.sleep(1000);
			
			
			
			int adminnum1=((ListView)((FrameLayout)(((PullToRefreshListView)solo.getView(id.listview)).getChildAt(1))).getChildAt(0)).getChildCount()-2;
			
			assertEquals(adminnum, adminnum1);
			
			solo.clickOnView(solo.getView(id.my_lefttview));//����
			solo.assertCurrentActivity("�˳�����Ա����ʧ��", com.changba.live.room.activity.RoomInfoActivity.class);
			solo.sleep(1000);
			
		}
	
	
	
}
