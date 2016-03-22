package com.changba.live.test.elements;

import com.changba.live.R;
import com.changba.widget.MyTitleBar;
import com.changba.widget.pulltorefresh.PullToRefreshWebView;
import com.robotium.solo.Solo;

import android.app.Activity;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ElementsSettingAgreement {

	private Solo solo;
	private Activity activity;
	
	private ViewStub actionModeBarStub;
	
	private FrameLayout titleContainer;
	private MyTitleBar actTitleBar;
	private TextView myLeftView;
	private TextView myRightView;
	private TextView myTitleView;
	
	private FrameLayout fragmentContent;
	private RelativeLayout emptyLayout;
	private PullToRefreshWebView webPageView;
	private RelativeLayout bottomLayout;
	private TextView emptyView;
	private Button refreshBtn;
	
	private ImageButton btnBack;//×óÏÂ°´Å¥
	private ImageButton btnForward;
	private ImageButton btnUpload;//Ë¢ÐÂ
	private WebView webView;
	
	private ProgressBar loadMore;
	
	public Solo getSolo() {
		return solo;
	}

	public ElementsSettingAgreement(Solo solo){
		this.solo=solo;
		initViews();
	}
	public void initViews(){
		
		activity=solo.getCurrentActivity();
		actTitleBar=(MyTitleBar) activity.findViewById(R.id.act_titlebar);
		myLeftView=(TextView) activity.findViewById(R.id.my_lefttview);
		myRightView=(TextView) activity.findViewById(R.id.my_rightview);
		myTitleView=(TextView) activity.findViewById(R.id.my_titleview);
		fragmentContent=(FrameLayout) activity.findViewById(R.id.fragment_content);
		emptyLayout=(RelativeLayout) activity.findViewById(R.id.empty_layout);
		webPageView=(PullToRefreshWebView) activity.findViewById(R.id.webpageView);
		bottomLayout=(RelativeLayout) activity.findViewById(R.id.bottom_layout);
		refreshBtn=(Button) activity.findViewById(R.id.refresh_btn);
		btnBack=(ImageButton) activity.findViewById(R.id.btn_back);
		btnForward=(ImageButton) activity.findViewById(R.id.btn_forward);
		btnUpload=(ImageButton) activity.findViewById(R.id.btn_upload);
		webView=(WebView) activity.findViewById(R.id.webview);
		loadMore=(ProgressBar) activity.findViewById(R.id.loadmore);
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

	public FrameLayout getFragmentContent() {
		return fragmentContent;
	}

	public RelativeLayout getEmptyLayout() {
		return emptyLayout;
	}

	public PullToRefreshWebView getWebPageView() {
		return webPageView;
	}

	public RelativeLayout getBottomLayout() {
		return bottomLayout;
	}

	public TextView getEmptyView() {
		return emptyView;
	}

	public Button getRefreshBtn() {
		return refreshBtn;
	}

	public ImageButton getBtnBack() {
		return btnBack;
	}

	public ImageButton getBtnForward() {
		return btnForward;
	}

	public ImageButton getBtnUpload() {
		return btnUpload;
	}

	public WebView getWebView() {
		return webView;
	}

	public ProgressBar getLoadMore() {
		return loadMore;
	}

	
}
