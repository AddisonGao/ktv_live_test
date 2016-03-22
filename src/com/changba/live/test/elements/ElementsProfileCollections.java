package com.changba.live.test.elements;

import java.util.Random;

import android.app.Activity;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.ui.NetworkImageView;
import com.changba.live.R;
import com.changba.widget.BlockingRelativeLayout;
import com.changba.widget.InfoLayout;
import com.changba.widget.MyTitleBar;
import com.changba.widget.UISwitchButton;
import com.changba.widget.pulltorefresh.PullToRefreshListView;
import com.robotium.solo.Solo;

public class ElementsProfileCollections {

	private Solo solo;
	private Activity activity;
	
	private ViewStub actionModeBarStub;	
	private FrameLayout titleContainer;
	private MyTitleBar actTitleBar;
	private TextView myLeftView;
	private TextView myRightView;
	private TextView myTitleView;
	
	private FrameLayout flInner;
	private ImageView pullToRefreshImage;
	private ProgressBar pullToRefreshProgress;
	private TextView pullToRefreshText;
	private TextView pullToRefreshSubText;
	
	private RelativeLayout liveRoomListItemView;
	private NetworkImageView liveRoomListItemImg;
	private BlockingRelativeLayout txtLayer;
	private LinearLayout roomStatusLayout;
	private ImageView roomStatus;
	private TextView roomCount;
	private TextView liveRoomListItemToptView;//��������
	private TextView roomListItemLevelTxt;//�ȼ�
	private TextView roomListItemRoomIdTxt;//ֱ����id
	
	private RelativeLayout loadMore;
	private ProgressBar loadMoreProgressBar;
	
	private PullToRefreshListView listView; 

	public Solo getSolo() {
		return solo;
	}
	
	public ElementsProfileCollections(Solo solo){
		this.solo=solo;
		initViews();
	}
	public void initViews(){
		activity=solo.getCurrentActivity();
		actTitleBar=(MyTitleBar) activity.findViewById(R.id.act_titlebar);
		myLeftView=(TextView) activity.findViewById(R.id.my_lefttview);
		myRightView=(TextView) activity.findViewById(R.id.my_rightview);
		myTitleView=(TextView) activity.findViewById(R.id.my_titleview);
		flInner=(FrameLayout) activity.findViewById(R.id.fl_inner);
		pullToRefreshImage=(ImageView) activity.findViewById(R.id.pull_to_refresh_image);
		pullToRefreshProgress=(ProgressBar) activity.findViewById(R.id.pull_to_refresh_progress);
		pullToRefreshText=(TextView) activity.findViewById(R.id.pull_to_refresh_text);
		pullToRefreshSubText=(TextView) activity.findViewById(R.id.pull_to_refresh_sub_text);
		liveRoomListItemView=(RelativeLayout) activity.findViewById(R.id.live_room_list_item_view);
		liveRoomListItemImg=(NetworkImageView) activity.findViewById(R.id.live_room_list_item_img);
		liveRoomListItemToptView=(TextView) activity.findViewById(R.id.live_room_list_item_top_tView);
		roomStatusLayout=(LinearLayout) activity.findViewById(R.id.room_status_layout);
		roomStatus=(ImageView) activity.findViewById(R.id.room_status);
		roomCount=(TextView) activity.findViewById(R.id.room_count);
		roomListItemLevelTxt=(TextView) activity.findViewById(R.id.room_list_item_level_txt);
		roomListItemRoomIdTxt=(TextView) activity.findViewById(R.id.room_list_item_room_id_txt);
		loadMoreProgressBar=(ProgressBar) activity.findViewById(R.id.load_more_progressBar);
		listView=(PullToRefreshListView)activity.findViewById(R.id.listview);
	}
	
	/**
	 * ����ղص�ֱ���������
	 * @param solo
	 * @return int ֱ������
	 */
	public int getCollectionCount(Solo solo)
	{
		return ((ListView)((FrameLayout)((PullToRefreshListView)solo.getView(R.id.listview)).getChildAt(1)).getChildAt(0)).getCount()-2;
	}

	public void goToWonderfulShow(){	
		solo.clickOnView(getMyLeftView());//��������ҳ
		solo.clickOnText("���ʱ���");
	}
	
	public int addCollection(Solo solo){
		solo.clickOnView(solo.getView(R.id.my_lefttview));
		solo.clickOnText("���ʱ���");
		int r=new Random().nextInt(5);
		solo.assertCurrentActivity("not homefragment= =", com.changba.live.activity.HomeFragmentTabs.class);
		solo.sleep(1000);
		//����5+r��ֱ������˳�
		for(int i=4;i<=12+r*2;)
		{
			solo.clickOnImage(i);
			solo.sleep(1000);
			if(solo.searchText("���ղ�")){
				solo.goBackToActivity("HomeFragmentTabs");
			}
			else //===========================����ղذ�ť������
			{
				solo.clickOnText("�ղ�");
				solo.waitForText("���ֱ���䵽�ղ��б�ɹ�");
				solo.goBackToActivity("HomeFragmentTabs");
			}
			i=i+2;
		}
		return 5+r;
	}
	public Activity getActivity() {
		return activity;
	}

	public ViewStub getActionModeBarStub() {
		return actionModeBarStub;
	}

	public FrameLayout getTitleContainer() {
		return titleContainer;
	}

	public MyTitleBar getActTitleBar() {
		return actTitleBar;
	}

	public TextView getMyLeftView() {
		return myLeftView;
	}

	public TextView getMyRightView() {
		return myRightView;
	}

	public TextView getMyTitleView() {
		return myTitleView;
	}

	public FrameLayout getFlInner() {
		return flInner;
	}

	public ImageView getPullToRefreshImage() {
		return pullToRefreshImage;
	}

	public ProgressBar getPullToRefreshProgress() {
		return pullToRefreshProgress;
	}

	public TextView getPullToRefreshText() {
		return pullToRefreshText;
	}

	public TextView getPullToRefreshSubText() {
		return pullToRefreshSubText;
	}

	public RelativeLayout getLiveRoomListItemView() {
		return liveRoomListItemView;
	}

	public NetworkImageView getLiveRoomListItemImg() {
		return liveRoomListItemImg;
	}

	public BlockingRelativeLayout getTxtLayer() {
		return txtLayer;
	}

	public LinearLayout getRoomStatusLayout() {
		return roomStatusLayout;
	}

	public ImageView getRoomStatus() {
		return roomStatus;
	}

	public TextView getRoomCount() {
		return roomCount;
	}

	public TextView getLiveRoomListItemToptView() {
		return liveRoomListItemToptView;
	}

	public TextView getRoomListItemLevelTxt() {
		return roomListItemLevelTxt;
	}

	public TextView getRoomListItemRoomIdTxt() {
		return roomListItemRoomIdTxt;
	}

	public RelativeLayout getLoadMore() {
		return loadMore;
	}

	public ProgressBar getLoadMoreProgressBar() {
		return loadMoreProgressBar;
	}
	public PullToRefreshListView getListView() {
		return listView;
	}
}
