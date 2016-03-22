package com.changba.live.test.elements;

import org.junit.internal.runners.statements.Fail;

import android.app.Activity;
import android.support.v4.app.FixedFragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TabWidget;
import android.widget.TextView;

import com.android.volley.ui.NetworkImageView;
import com.changba.live.R;
import com.changba.widget.BlockingImageView;
import com.changba.widget.BlockingRelativeLayout;
import com.changba.widget.MyGridView;
import com.changba.widget.emotion.EmotionScrollView.TabView;
import com.changba.widget.pulltorefresh.PullToRefreshListView;
import com.robotium.solo.Solo;

public class ElementsWonderfulShow {
	
	private Solo solo;
	private Activity activity;
	
	private ViewStub actionModeBarStub;
	private FrameLayout tabContent;
	private LinearLayout videoRoomListTitle;//���Ϸ�һ�������������������
	private Button videoRoomListSearchText;//����
	private ImageView videoRoomTitleRight;//�������ͼ��
	private FrameLayout flInner;
	private ImageView pullToRefreshImage;
	private ProgressBar pullToRefreshProgress;
	private TextView pullToRefreshText;
	private TextView pullToRefreshSubText;
	private ViewPager viewPager;
	private LinearLayout viewGroup;
	private RelativeLayout laySection;//����ֱ��������,����һ��
	private NetworkImageView hdIcon;//�������
	private TextView sectionTitle;//����ֱ����/����
	private TextView sectionBtn;//����>
	private BlockingImageView headPhoto;//ͷ��
	private BlockingRelativeLayout textLayer;//����״̬��������������һ��
	private ImageView roomZZZ;//����״̬
	private LinearLayout roomStatusLayout;//����״̬
	private TextView roomName;
	private TextView roomAccount;
	private RelativeLayout loadMore;//����
	private ProgressBar loadMoreProgresssBar;
	private TabWidget tabs;//���ʱ��ݡ���������
	private MyGridView gridView;
//	private PullToRefreshListView list;
	private PullToRefreshListView videoRoomListListview;
	private LinearLayout rootView;
	private FixedFragmentStatePagerAdapter tabHost;
	private FrameLayout realTabContent;
	private FrameLayout content;
	
	public ElementsWonderfulShow(Solo solo){
		this.solo=solo;	
		initViews();
	}
	/**
	 * ��ʼ��ʱ���ҵ����еĿؼ�
	 */
	public void initViews(){
		solo.sleep(1000);
		activity=solo.getCurrentActivity();
		//actionModeBarStub=activity.findViewById(R.id.)
		//tabContent=activity.findViewById(R.id.ta)
		videoRoomListTitle=(LinearLayout) activity.findViewById(R.id.video_room_list_title);
		videoRoomListSearchText=(Button) activity.findViewById(R.id.video_room_list_search_text);
		videoRoomTitleRight=(ImageView) activity.findViewById(R.id.video_room_title_right);
		flInner=(FrameLayout) activity.findViewById(R.id.fl_inner);
		pullToRefreshImage=(ImageView) activity.findViewById(R.id.pull_to_refresh_image);
		pullToRefreshProgress=(ProgressBar) activity.findViewById(R.id.pull_to_refresh_progress);
		pullToRefreshText=(TextView) activity.findViewById(R.id.pull_to_refresh_text);
		pullToRefreshSubText=(TextView) activity.findViewById(R.id.pull_to_refresh_sub_text);
		viewPager=(ViewPager) activity.findViewById(R.id.viewPager);
		viewGroup=(LinearLayout) activity.findViewById(R.id.view_group);
		laySection=(RelativeLayout) activity.findViewById(R.id.lay_section);
		hdIcon=(NetworkImageView) activity.findViewById(R.id.hd_icon);
		sectionTitle=(TextView) activity.findViewById(R.id.section_title);
		sectionBtn=(TextView) activity.findViewById(R.id.section_btn);
		headPhoto=(BlockingImageView) activity.findViewById(R.id.headphoto);
		textLayer=(BlockingRelativeLayout) activity.findViewById(R.id.text_layer);
		roomZZZ=(ImageView) activity.findViewById(R.id.room_zzz);
		roomStatusLayout=(LinearLayout) activity.findViewById(R.id.room_status_layout);
		roomName=(TextView) activity.findViewById(R.id.room_name);
		roomAccount=(TextView) activity.findViewById(R.id.room_count);
		loadMore=(RelativeLayout) activity.findViewById(R.id.loadmore);
		loadMoreProgresssBar=(ProgressBar) activity.findViewById(R.id.load_more_progressBar);
		//tabs=activity.findViewById(R.id.tab)
		gridView=(MyGridView) activity.findViewById(R.id.grid_view);
		videoRoomListListview=(PullToRefreshListView) activity.findViewById(R.id.video_room_list_listview);
		rootView=(LinearLayout) activity.findViewById(R.id.rootview);
		//tabHost=activity.findViewById(R.id.ta)
		realTabContent=(FrameLayout) activity.findViewById(R.id.realtabcontent);
//		content=activity.findViewById(R.id.con)
	}
	
	
	
	//�����һ��ֱ������Ϊ���Է���
	public void clickOnLivePage(){
		
		solo.clickOnView(solo.getView(com.changba.live.R.id.headphoto,1));
		
	}
	
	
	public TabWidget getTabs(){
		return tabs;
	}
	public void clickOnMe(){
		if(solo.searchText("��"))
			solo.clickOnText("��");
		else
			return;
	}
}
