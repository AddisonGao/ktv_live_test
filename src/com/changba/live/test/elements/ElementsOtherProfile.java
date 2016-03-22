package com.changba.live.test.elements;

import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.ui.NetworkImageView;
import com.changba.live.R;
import com.changba.live.R.id;
import com.changba.widget.UISwitchButton;
import com.robotium.solo.Solo;

public class ElementsOtherProfile {
	
	
	private Solo solo;
	private Activity activity;
	
	private NetworkImageView headPhoto;
	private RelativeLayout headBgIV;//头像背景
	
	
	private ImageView btnBack;//返回按钮
	private ImageView btnChat;//聊天
	private Button btnFollow;//关注
	
	private TextView userName;
	private TextView level;
	
	
	private ImageView imgLeft;
	private TextView txtLeft;
	
	private TextView txtLeftRight;
	private TextView txtArrow;
	private ImageView imgRight;
	
	
	
	private Button moreInfoLayout;//更多资料
	
	public ElementsOtherProfile(Solo solo){
		this.solo=solo;
		initViews();
	}
	
	
	
	/**
	 * 初始化页面,找到页面所有控件
	 */
	public void initViews(){
		solo.sleep(1000);
		activity=solo.getCurrentActivity();
		
		headPhoto=(NetworkImageView)activity.findViewById(R.id.headphoto);
		headBgIV=(RelativeLayout) activity.findViewById(R.id.head_bg_iv);
		btnBack=(ImageView) activity.findViewById(R.id.btn_back);
		btnChat=(ImageView) activity.findViewById(R.id.btn_chat);
		btnFollow=(Button) activity.findViewById(R.id.btn_follow);
		userName=(TextView) activity.findViewById(R.id.user_name);
		level=(TextView) activity.findViewById(R.id.level);
		imgLeft=(ImageView) activity.findViewById(R.id.img_left);
		txtLeft=(TextView) activity.findViewById(R.id.txt_left);
		txtLeftRight=(TextView) activity.findViewById(R.id.txt_left_right);
		txtArrow=(TextView) activity.findViewById(R.id.txt_arrow);
		imgRight=(ImageView) activity.findViewById(R.id.img_right);
		moreInfoLayout=(Button) activity.findViewById(R.id.more_info_layout);
	}



	public Solo getSolo() {
		return solo;
	}



	public Activity getActivity() {
		return activity;
	}



	public NetworkImageView getHeadPhoto() {
		return headPhoto;
	}



	public RelativeLayout getHeadBgIV() {
		return headBgIV;
	}



	public ImageView getBtnBack() {
		return btnBack;
	}



	public ImageView getBtnChat() {
		return btnChat;
	}



	public Button getBtnFollow() {
		return btnFollow;
	}



	public TextView getUserName() {
		return userName;
	}



	public TextView getLevel() {
		return level;
	}



	public ImageView getImgLeft() {
		return imgLeft;
	}



	public TextView getTxtLeft() {
		return txtLeft;
	}



	public TextView getTxtLeftRight() {
		return txtLeftRight;
	}



	public TextView getTxtArrow() {
		return txtArrow;
	}



	public ImageView getImgRight() {
		return imgRight;
	}



	public Button getMoreInfoLayout() {
		return moreInfoLayout;
	}
	
	
	//进入第一个关注人的profile界面中
	public void clickOnOtherPersonProfile(){
		
		solo.clickOnText("我");
		solo.clickOnView(solo.getView(R.id.txt_left, 8));
		solo.sleep(500);
		solo.clickOnView(solo.getView(id.headphoto,0));//点击关注的第1个人 进入他的主页面
		
		
	}
	
	
	

}
