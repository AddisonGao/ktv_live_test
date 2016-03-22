package com.changba.live.test.elements;

import com.changba.live.R;
import com.changba.widget.InfoLayout;
import com.changba.widget.MyTitleBar;
import com.changba.widget.UISwitchButton;
import com.robotium.solo.Solo;

import android.app.Activity;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ElementsSetting {
	
	private Solo solo;
	private Activity activity;
	
	private ViewStub actionModeBarStub;
	
	private FrameLayout titleContainer;
	private MyTitleBar actTitleBar;
	private TextView myLeftView;
	private TextView myRightView;
	private TextView myTitleView;
	
	private InfoLayout infoPushAnimation;
	private RelativeLayout topurLayout;
	private ImageView imgLeft;
	private TextView txtLeft;
	private TextView txtLeftRight;
	private TextView txtArrow;
	private ImageView imgRight;
	private UISwitchButton switchRight;
	private TextView txtRight;
	private ImageView imgNewTip;
	
	private InfoLayout infoPush;
	private InfoLayout btnAbout;
	private InfoLayout btnFeedBack;
	private InfoLayout btnHelp;
	private InfoLayout btnAgreement;
	private Button loginBtn;
	
	private FrameLayout content;
	
	public ElementsSetting(Solo solo){
		this.solo=solo;
		initViews();
	}
	
	public void initViews(){
		solo.sleep(1000);
		activity=solo.getCurrentActivity();
		actTitleBar=(MyTitleBar) activity.findViewById(R.id.act_titlebar);
		myLeftView=(TextView) activity.findViewById(R.id.my_lefttview);
		myRightView=(TextView) activity.findViewById(R.id.my_rightview);
		myTitleView=(TextView) activity.findViewById(R.id.my_titleview);
		infoPushAnimation=(InfoLayout) activity.findViewById(R.id.info_push_animation);
		topurLayout=(RelativeLayout) activity.findViewById(R.id.topur_layout);
		imgLeft=(ImageView) activity.findViewById(R.id.img_left);
		txtLeft=(TextView) activity.findViewById(R.id.txt_left);
		txtLeftRight=(TextView) activity.findViewById(R.id.txt_left_right);
		txtArrow=(TextView) activity.findViewById(R.id.txt_arrow);
		imgRight=(ImageView) activity.findViewById(R.id.img_right);
		switchRight=(UISwitchButton) activity.findViewById(R.id.switch_right);
		txtRight=(TextView) activity.findViewById(R.id.txt_right);
		imgNewTip=(ImageView) activity.findViewById(R.id.img_new_tip);
		infoPush=(InfoLayout) activity.findViewById(R.id.info_push);
		btnAbout=(InfoLayout) activity.findViewById(R.id.btn_about);
		btnFeedBack=(InfoLayout) activity.findViewById(R.id.btn_feedback);
		btnHelp=(InfoLayout) activity.findViewById(R.id.btn_help);
		btnAgreement=(InfoLayout) activity.findViewById(R.id.btn_agreement);
		loginBtn=(Button) activity.findViewById(R.id.login_btn);
	}
	/**
	 * 点击反馈
	 */
	public void clickOnFeedBack(){
		solo.clickOnView(getBtnFeedBack());
	}
	/**
	 * 点击声明
	 */
	public void clickOnAgreement(){
		solo.clickOnView(getBtnAgreement());
	}
	/**
	 * 点击帮助中心
	 * @return
	 */
	public void clickOnHelp(){
		solo.clickOnView(getBtnHelp());
	}
	/**
	 * 点击关于本软件
	 * @return
	 */
	public void clickOnAbout(){
		solo.clickOnView(getBtnAbout());
	}
	/**
	 * 点击推送提醒
	 */
	public void clickOnInfoPush(){
		solo.clickOnView(getInfoPush());
	}
	/**
	 * 点击播放房间动画开关
	 * @return
	 */
	public void clickOninfoPushAnimation(){
		solo.clickOnView(solo.getView(R.id.switch_right,0));
	}
	/**
	 * 点击左上返回
	 */
	public void clickOnLeftBack(){
		solo.clickOnView(getMyLeftView());
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

	public InfoLayout getInfoPushAnimation() {
		return infoPushAnimation;
	}

	public RelativeLayout getTopurLayout() {
		return topurLayout;
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

	public InfoLayout getInfoPush() {
		return infoPush;
	}

	public InfoLayout getBtnAbout() {
		return btnAbout;
	}

	public InfoLayout getBtnFeedBack() {
		return btnFeedBack;
	}

	public InfoLayout getBtnHelp() {
		return btnHelp;
	}

	public InfoLayout getBtnAgreement() {
		return btnAgreement;
	}

	public Button getLoginBtn() {
		return loginBtn;
	}

	public FrameLayout getContent() {
		return content;
	}
}
