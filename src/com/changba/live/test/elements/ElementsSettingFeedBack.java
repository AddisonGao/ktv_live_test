package com.changba.live.test.elements;

import java.util.Random;

import com.changba.live.R;
import com.changba.widget.MyTitleBar;
import com.robotium.solo.Solo;

import android.app.Activity;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ElementsSettingFeedBack {

	private Solo solo;
	private Activity activity;
	private FrameLayout titleContainer;
	private MyTitleBar actTitleBar;
	private TextView myLeftView;
	private TextView myRightView;
	private TextView myTitleView;
	
	private RelativeLayout publishWindow;
	private LinearLayout publishContent;
	private EditText publishText;
	private TextView wordsTips;
	
	public Solo getSolo() {
		return solo;
	}
	
	public ElementsSettingFeedBack(Solo solo){
		this.solo=solo;
		initViews();
	}
	public void initViews(){
		activity=solo.getCurrentActivity();
		actTitleBar=(MyTitleBar) activity.findViewById(R.id.act_titlebar);
		myLeftView=(TextView) activity.findViewById(R.id.my_lefttview);
		myRightView=(TextView) activity.findViewById(R.id.my_rightview);
		myTitleView=(TextView) activity.findViewById(R.id.my_titleview);
		publishWindow=(RelativeLayout) activity.findViewById(R.id.publish_window);
		publishContent=(LinearLayout) activity.findViewById(R.id.publish_content);
		publishText=(EditText) activity.findViewById(R.id.publish_text);
		wordsTips=(TextView) activity.findViewById(R.id.words_tips);
	}
	/**
	 * 点发送
	 */
	public void clickOnSend(){
		solo.clickOnView(getMyRightView());
	}
	/**
	 * 点取消
	 */
	public void clickOnCancel(){
		solo.clickOnView(getMyLeftView());
	}
	/**
	  * JAVA获得0-9,a-z,A-Z范围的随机数
	  * @param length 随机数长度
	  * @return String
	  */
	 public  String getRandomChar(int length) {
		 char[] chr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
						'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
						'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		 Random random = new Random();
		 StringBuffer buffer = new StringBuffer();
		 for (int i = 0; i < length; i++) {
		    	buffer.append(chr[random.nextInt(62)]);
		 }
		 return buffer.toString();
	}
	 
	public void typeWords(int length){
		solo.typeText(0, getRandomChar(length));
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
	public RelativeLayout getPublishWindow() {
		return publishWindow;
	}
	public LinearLayout getPublishContent() {
		return publishContent;
	}
	public EditText getPublishText() {
		return publishText;
	}
	public TextView getWordsTips() {
		return wordsTips;
	}
	
}
