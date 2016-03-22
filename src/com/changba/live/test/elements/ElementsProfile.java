package com.changba.live.test.elements;

import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.ui.NetworkImageView;
import com.aps.ac;
import com.changba.live.R;
import com.changba.widget.UISwitchButton;
import com.robotium.solo.Solo;

public class ElementsProfile {
	
	private Solo solo;
	private Activity activity;
	
	private NetworkImageView headPhoto;
	private RelativeLayout headBg;//头像背景
	private ImageView btnSetting;//设置按钮
	
	private ImageView btnBack;//返回按钮
	private ImageView btnChat;//聊天
	private Button btnFollow;//关注
	
	private TextView userName;
	private TextView level;
	private Button btnEdit;
	
	private ImageView imgLeft;
	private TextView txtLeft;
	private TextView txtLeftRight;
	private TextView txtArrow;
	private ImageView imgRight;
	private UISwitchButton switchRight;
	private TextView txtRight;
	private ImageView imgNewTip;//消息上的红点
	private Button moreInfoLayout;//更多资料
	
	public ElementsProfile(Solo solo){
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
		headBg=(RelativeLayout)activity.findViewById(R.id.head_bg);
		btnSetting=(ImageView)activity.findViewById(R.id.btn_setting);
		btnBack=(ImageView)activity.findViewById(R.id.btn_back);
		btnChat=(ImageView)activity.findViewById(R.id.btn_chat);
		btnFollow=(Button)activity.findViewById(R.id.btn_follow);
		userName=(TextView)activity.findViewById(R.id.user_name);
		level=(TextView)activity.findViewById(R.id.level);
		btnEdit=(Button)activity.findViewById(R.id.btn_edit);
		imgLeft=(ImageView)activity.findViewById(R.id.img_left);
		txtLeft=(TextView)activity.findViewById(R.id.txt_left);
		txtLeftRight=(TextView)activity.findViewById(R.id.txt_left_right);
		txtArrow=(TextView)activity.findViewById(R.id.txt_arrow);
		imgRight=(ImageView)activity.findViewById(R.id.img_right);
		switchRight=(UISwitchButton)activity.findViewById(R.id.switch_right);
		txtRight=(TextView)activity.findViewById(R.id.txt_right);
		imgNewTip=(ImageView)activity.findViewById(R.id.img_new_tip);
		moreInfoLayout=(Button)activity.findViewById(R.id.more_info_layout);
	}
	/**
	 * 进入设置页
	 */
	public void clickOnSetting(){
		solo.clickOnView(getBtnSetting());
	}
	/*
	 * 进入收藏页
	 */
	public void clickOnCollection(){
		//solo.clickOnText("收藏");
		solo.clickOnView(solo.getView(R.id.txt_left, 6));
	}
	
	/**
	 * 获得我页面显示的收藏数量
	 * @param solo
	 * @return
	 */
	public int getCollectionCountText(Solo solo){
		String s=(String) ((TextView)solo.getView(R.id.txt_left_right,6)).getText();
	    s=s.substring(1,s.length()-1);
		return Integer.parseInt(s);
	}
	public NetworkImageView getHeadPhoto() {
		return headPhoto;
	}

	public RelativeLayout getHeadBg() {
		return headBg;
	}

	public ImageView getBtnSetting() {
		return btnSetting;
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

	public Button getBtnEdit() {
		return btnEdit;
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

	public UISwitchButton getSwitchRight() {
		return switchRight;
	}

	public TextView getTxtRight() {
		return txtRight;
	}

	public ImageView getImgNewTip() {
		return imgNewTip;
	}

	public Button getMoreInfoLayout() {
		return moreInfoLayout;
	}
	
	
}
