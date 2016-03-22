package com.changba.live.test.elements;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.changba.live.R;
import com.changba.widget.InfoLayout;
import com.changba.widget.MyTitleBar;
import com.changba.widget.UISwitchButton;
import com.robotium.solo.Solo;

public class ElementsSettingInfoPush {

	private Solo solo;
	private Activity activity;
	
	private ViewStub actionModeBarStub;
	
	private FrameLayout titleContainer;
	private MyTitleBar actTitleBar;
	private TextView myLeftView;
	private TextView myRightView;
	private TextView myTitleView;
	
	private InfoLayout infoPushSwitch;
	private RelativeLayout topurLayout;
	private ImageView imgLeft;
	private TextView txtLeft;
	private TextView txtLeftRight;
	private TextView txtArrow;

	private ImageView imgRight;
	private UISwitchButton switchRight;
	private TextView txtRight;
	private ImageView imgNewTip;
	
	private InfoLayout infoSound;
	private InfoLayout infoVibrate;
	private InfoLayout infoPushStart;
	private InfoLayout infoPushStop;
	private LinearLayout pushInfoLayout;
	
	public ElementsSettingInfoPush(Solo solo){
		this.solo=solo;
		initViews();
	}
	
	public Solo getSolo() {
		return solo;
	}

	public Activity getActivity() {
		return activity;
	}
	
	public void initViews(){
		solo.sleep(1000);
		activity=solo.getCurrentActivity();
		actTitleBar=(MyTitleBar) activity.findViewById(R.id.act_titlebar);
		myLeftView=(TextView) activity.findViewById(R.id.my_lefttview);
		myRightView=(TextView) activity.findViewById(R.id.my_rightview);
		myTitleView=(TextView) activity.findViewById(R.id.my_titleview);
		infoPushSwitch=(InfoLayout) activity.findViewById(R.id.info_push_switch);
		topurLayout=(RelativeLayout) activity.findViewById(R.id.topur_layout);
		imgLeft=(ImageView) activity.findViewById(R.id.img_left);
		txtLeft=(TextView) activity.findViewById(R.id.txt_left);
		txtLeftRight=(TextView) activity.findViewById(R.id.txt_left_right);
		txtArrow=(TextView) activity.findViewById(R.id.txt_arrow);
		imgRight=(ImageView) activity.findViewById(R.id.img_right);
		switchRight=(UISwitchButton) activity.findViewById(R.id.switch_right);
		txtRight=(TextView) activity.findViewById(R.id.txt_right);
		imgNewTip=(ImageView) activity.findViewById(R.id.img_new_tip);
		infoSound=(InfoLayout) activity.findViewById(R.id.info_sound);
		infoVibrate=(InfoLayout) activity.findViewById(R.id.info_vibrate);
		infoPushStart=(InfoLayout) activity.findViewById(R.id.info_push_start);
		infoPushStop=(InfoLayout) activity.findViewById(R.id.info_push_stop);
		pushInfoLayout=(LinearLayout) activity.findViewById(R.id.push_info_layout);
	}

	/**
	 * 点击接受推送提醒开关
	 */
	public void clickOnAgreePush(){
		solo.clickOnView(solo.getView(R.id.switch_right,0));
	}
	/**
	 * 点击声音
	 * @return
	 */
	public void clickOnSoundPush(){
		solo.clickOnView(solo.getView(R.id.switch_right,1));
	}
	/**
	 * 点击震动
	 * @return
	 */
	public void clickOnVibratePush(){
		solo.clickOnView(solo.getView(R.id.switch_right,2));
	}
	/*
	 * 点击接受推送提醒，声音，震动中的随意一个开关
	 */
	public void clickOnRandomSwitch(){
		solo.clickOnView(solo.getView(R.id.switch_right,new Random().nextInt(2)));
	}
	public boolean getText(){
		return solo.searchText("提醒方式")&&solo.searchText("免打扰时间");
	}
	/*
	 * 判断标题是否为推送提醒，左侧返回按钮是否显示
	 */
	public boolean judgeTheTitle(){
		return (getMyTitleView().getText()).equals("推送提醒");
	}
	/**
	 * 判断每一栏
	 * @return
	 */
	public boolean judgeTheItem(){
		boolean flag=true;
		ArrayList<String> list=new ArrayList<String>();
		list.add("接受推送提醒");
		list.add("声音");
		list.add("震动");
		list.add("开始");
		list.add("结束");
		for(int i=0;i<list.size();i++){
			if(!((TextView)solo.getView(R.id.txt_left,i)).getText().equals(list.get(i))){
				flag=false;
				break;
			}
		}
		return flag;
	}
	/*
	 * 返回设置页
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

	public InfoLayout getInfoPushSwitch() {
		return infoPushSwitch;
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

	public InfoLayout getInfoSound() {
		return infoSound;
	}

	public InfoLayout getInfoVibrate() {
		return infoVibrate;
	}

	public InfoLayout getInfoPushStart() {
		return infoPushStart;
	}

	public InfoLayout getInfoPushStop() {
		return infoPushStop;
	}

	public LinearLayout getPushInfoLayout() {
		return pushInfoLayout;
	}
}
