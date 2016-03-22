package com.changba.live.test.elements;

import com.changba.live.R;
import com.changba.widget.MyTitleBar;
import com.robotium.solo.Solo;

import android.app.Activity;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ElementsSettingAbout {

	private Solo solo;
	private Activity activity;
	
	private ViewStub actionModeBarStub;
	private FrameLayout titleContainer;
	private MyTitleBar actTitleBar;
	private TextView myLeftView;
	private TextView myRightView;
	private TextView myTitleView;
	
	private ImageView changbaLog;
	private TextView version;
	private TextView tips;
	private Button downloadStable;
	
	private TextView copyRight;
	
	public Solo getSolo() {
		return solo;
	}

	public ElementsSettingAbout(Solo solo){
		this.solo=solo;
		initViews();
	}
	
	public void initViews(){
		activity=solo.getCurrentActivity();
		actTitleBar=(MyTitleBar) activity.findViewById(R.id.act_titlebar);
		myLeftView=(TextView) activity.findViewById(R.id.my_lefttview);
		myRightView=(TextView) activity.findViewById(R.id.my_rightview);
		myTitleView=(TextView) activity.findViewById(R.id.my_titleview);
		changbaLog=(ImageView) activity.findViewById(R.id.changba_log);
		version=(TextView) activity.findViewById(R.id.version);
		tips=(TextView) activity.findViewById(R.id.tips);
		downloadStable=(Button) activity.findViewById(R.id.download_stable);
		copyRight=(TextView)activity.findViewById(R.id.copyright);
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
	public ImageView getChangbaLog() {
		return changbaLog;
	}
	public TextView getVersion() {
		return version;
	}
	public TextView getTips() {
		return tips;
	}
	public Button getDownloadStable() {
		return downloadStable;
	}
	public TextView getCopyRight() {
		return copyRight;
	}
	
}
