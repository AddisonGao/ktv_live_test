package com.changba.live.test.elements;

import android.R;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.support.v4.view.SmoothViewPager;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.ui.NetworkImageView;
import com.changba.live.R.id;
import com.changba.live.room.view.LiveInfoView;
import com.changba.widget.AutoScrollTextView;
import com.changba.widget.DrawableLeftToCenterButton;
import com.changba.widget.DrawableRightToCenterButton;
import com.changba.widget.emotion.EmotionEditText;
import com.changba.widget.tab.CirclePageIndicator;
import com.robotium.solo.Solo;

public class ElementsLive {

	private Solo solo;
	private Activity activity;
	

	private ViewStub actionModeBarStub;
	private NetworkImageView userBackImg;//�����ͼ��Ƭ
	private GLSurfaceView glSurfaceView;
	
	private AutoScrollTextView giftRunTest;//�����ܵ�
	
	private ImageView liveRoomExit;//�˳�����button
	private Button confirmButton;//�˳�����ȷ�ϰ�ť
	private TextView liveRoomTitleMiddleTop;//������������
	private TextView liveRoomTitleMiddleButtom;//�����
	private ImageView liveRoomMore;//����button
	
	private NetworkImageView liveRoomHeadphoto;//����ͷ��
	private TextView liveRoomCollect;//�ղ�button
	private TextView liveRoomNickname;//��������
	private TextView liveRoomStarLevel;//�����ȼ���ʾ
	private TextView liveRoomEmpty;
	
	private LiveInfoView liveRoomLiveInfo;
	
	private Button tabPublicChat;//����tab
	private Button tabPrivateChat;//˽��tab
	private Button tabAudience;//����tab
	
	private NetworkImageView pubicChatSenderHead;//�����û�ͷ��
	private TextView pubicChatName;//�����û���
	private TextView pubicChatTxt;//����������Ϣ
	private NetworkImageView pubicChatGift;//����ͼƬ
	
	private TextView pubicChatSystem;//����ϵͳ��Ϣ
	
	
	private DrawableLeftToCenterButton liveRoomButtonPublicChat;//�ײ�����button
	private DrawableLeftToCenterButton liveRoomButtonSendGift;//�ײ�����button
	
	//��������
	private ImageView emojiKeyboard;//�������
	private EmotionEditText postComment;//�Ի���
	private Button sendBtn;//���췢��btn
	
	private SmoothViewPager pager;
	private CirclePageIndicator indicator;
	
	private NetworkImageView headphoto;//����ͷ��
	private TextView userName;//��������
	private TextView userTitleLevel;//�����ȼ�
	private TextView richTitleLevel;//�Ƹ��ȼ�
	
	
	
	//������
	private TextView liveRoomTitleLeft;//�������
	private TextView liveRoomBalance;//��������������
	private TextView liveRoomTitleRight;//��ֵ
	private ImageView imageTip;//����ͼƬ
	private TextView giftType;//��������
	private TextView count;//����۸�
	private TextView cntValue;//��������Ŀ
	private TextView targetName;//���������
	private Button sendGiftBtn;//������button
	
	
	
	//�����ǩ
	
	private Button liveRoomPersonAttention;//��ע��ť
	private Button liveRoomPersonKickoffUser;//�߳����䰴ť
	private Button liveRoomPersonGift;//���ﰴť
	private Button liveRoomPersonPublicChat;//������TA˵
	private Button liveRoomPersonPrivateChat;//���Ķ�TA˵
	private TextView username;//�����ǩ���û���
	
	
	
	

	
	
	public ElementsLive(Solo solo){
		this.solo=solo;
		initViews();
	}
	
	
	public void setPubicChatSystem(TextView pubicChatSystem) {
		this.pubicChatSystem = pubicChatSystem;
	}


	public void initViews(){
		solo.sleep(1000);
		activity=solo.getCurrentActivity();
		userBackImg=(NetworkImageView) activity.findViewById(com.changba.live.R.id.user_back_img);
		giftRunTest=(AutoScrollTextView) activity.findViewById(id.gift_run_text);
		liveRoomExit=(ImageView) activity.findViewById(id.live_room_exit);
		confirmButton=(Button) activity.findViewById(id.confirm_btn);
		liveRoomTitleMiddleTop=(TextView) activity.findViewById(id.live_room_title_middle_top);
		liveRoomTitleMiddleButtom=(TextView) activity.findViewById(id.live_room_title_middle_bottom);
		liveRoomMore=(ImageView) activity.findViewById(id.live_room_more);
		liveRoomHeadphoto=(NetworkImageView) activity.findViewById(id.live_room_headphoto);
		liveRoomCollect=(TextView) activity.findViewById(id.live_room_anchor_collect);
		liveRoomNickname=(TextView) activity.findViewById(id.live_room_nickname);
		liveRoomStarLevel=(TextView) activity.findViewById(id.live_room_star_level);
		liveRoomLiveInfo=(LiveInfoView) activity.findViewById(id.live_room_liveinfo);
		tabPublicChat=(Button) activity.findViewById(id.tab_public_chat);
		tabPrivateChat=(Button) activity.findViewById(id.tab_private_chat);
		tabAudience=(Button) activity.findViewById(id.tab_audience);
		pubicChatSenderHead=(NetworkImageView) activity.findViewById(id.live_room_pubic_chat_item_sender_head_img);
		pubicChatName=(TextView) activity.findViewById(id.live_room_pubic_chat_item_username);
		pubicChatTxt=(TextView) activity.findViewById(id.live_room_pubic_chat_item_down_txt);
		pubicChatGift=(NetworkImageView) activity.findViewById(id.live_room_pubic_chat_item_gift);
		pubicChatSystem=(TextView) activity.findViewById(id.live_room_pubic_chat_item_system_txt);
		liveRoomButtonPublicChat=(DrawableLeftToCenterButton) activity.findViewById(id.live_room_bottom_public_chat);
		liveRoomButtonSendGift=(DrawableLeftToCenterButton) activity.findViewById(id.live_room_bottom_send_gift);
		emojiKeyboard=(ImageView) activity.findViewById(id.keyboardType);
		postComment=(EmotionEditText) activity.findViewById(id.postcomment);
		sendBtn=(Button) activity.findViewById(id.send_btn);
		headphoto=(NetworkImageView) activity.findViewById(id.headphoto);
		userName=(TextView) activity.findViewById(id.user_name);
		userTitleLevel=(TextView) activity.findViewById(id.user_title_level);
		richTitleLevel=(TextView) activity.findViewById(id.rich_title_level);
		liveRoomTitleLeft=(TextView) activity.findViewById(id.live_room_title_left);
		liveRoomTitleRight=(TextView) activity.findViewById(id.live_room_title_right);
		liveRoomBalance=(TextView) activity.findViewById(id.live_room_balance);
		imageTip=(ImageView) activity.findViewById(id.image_tip);
		giftType=(TextView) activity.findViewById(id.gifttype);
		count=(TextView) activity.findViewById(id.count);
		cntValue=(TextView) activity.findViewById(id.cnt_value);
		targetName=(TextView) activity.findViewById(id.target_name);
		sendGiftBtn=(Button) activity.findViewById(id.send_btn);
	    liveRoomPersonAttention=(Button) activity.findViewById(id.live_room_person_attention);//��ע��ť
		liveRoomPersonKickoffUser=(Button) activity.findViewById(id.live_room_person_kickoff_user);//�߳����䰴ť
		liveRoomPersonGift=(Button) activity.findViewById(id.live_room_person_gift);//���ﰴť
		liveRoomPersonPublicChat=(Button) activity.findViewById(id.live_room_person_public_chat);//������TA˵
		liveRoomPersonPrivateChat=(Button) activity.findViewById(id.live_room_person_private_chat);
		username=(TextView)activity.findViewById(id.username);
		
	}

	

	
	
	
	
	
	public TextView getUsername() {
		return username;
	}


	public Button getLiveRoomPersonAttention() {
		return liveRoomPersonAttention;
	}


	public Button getLiveRoomPersonKickoffUser() {
		return liveRoomPersonKickoffUser;
	}


	public Button getLiveRoomPersonGift() {
		return liveRoomPersonGift;
	}


	public Button getLiveRoomPersonPublicChat() {
		return liveRoomPersonPublicChat;
	}


	public Button getLiveRoomPersonPrivateChat() {
		return liveRoomPersonPrivateChat;
	}


	public void clickOnTabPublicChat(){
		
		if(solo.searchText("����"))
			solo.clickOnText("����");
		else
			return;
	}
	
	public void clickOnTabPrivateChat(){
		
		if(solo.searchText("˽��"))
			solo.clickOnText("˽��");
		else
			return;
	}	
	
	public void clickOnTabAudience(){
		
		if(solo.searchText("����"))
			solo.clickOnText("����");
		else
			return;
	}
	
	public void clickOnButtonPublicChat(){
		
		if(solo.searchText("��������"))
			solo.clickOnText("��������");
		else
			return;
	}
	
	public void clickOnButtonSendGift(){
		
		if(solo.searchText("������"))
			solo.clickOnText("������");
		else
			return;
	}
	
	
	
	//get��������
	
	
	
	

	
	
	
	public ViewStub getActionModeBarStub() {
		return actionModeBarStub;
	}


	public NetworkImageView getUserBackImg() {
		return userBackImg;
	}


	public GLSurfaceView getGlSurfaceView() {
		return glSurfaceView;
	}


	public AutoScrollTextView getGiftRunTest() {
		return giftRunTest;
	}


	public ImageView getLiveRoomExit() {
		return liveRoomExit;
	}


	public TextView getLiveRoomTitleMiddleTop() {
		return liveRoomTitleMiddleTop;
	}


	public TextView getLiveRoomTitleMiddleButtom() {
		return liveRoomTitleMiddleButtom;
	}


	public ImageView getLiveRoomMore() {
		return liveRoomMore;
	}


	public NetworkImageView getLiveRoomHeadphoto() {
		return liveRoomHeadphoto;
	}


	public TextView getLiveRoomCollect() {
		return liveRoomCollect;
	}


	public TextView getLiveRoomNickname() {
		return liveRoomNickname;
	}


	public TextView getLiveRoomStarLevel() {
		return liveRoomStarLevel;
	}


	public TextView getLiveRoomEmpty() {
		return liveRoomEmpty;
	}


	public Button getTabPublicChat() {
		return tabPublicChat;
	}


	public Button getTabPrivateChat() {
		return tabPrivateChat;
	}


	public Button getTabAudience() {
		return tabAudience;
	}


	public NetworkImageView getPubicChatSenderHead() {
		return pubicChatSenderHead;
	}


	public TextView getPubicChatName() {
		return pubicChatName;
	}


	public TextView getPubicChatTxt() {
		return pubicChatTxt;
	}


	public NetworkImageView getPubicChatGift() {
		return pubicChatGift;
	}




	public DrawableLeftToCenterButton getLiveRoomButtonPublicChat() {
		return liveRoomButtonPublicChat;
	}


	public DrawableLeftToCenterButton getLiveRoomButtonSendGift() {
		return liveRoomButtonSendGift;
	}


	public ImageView getEmojiKeyboard() {
		return emojiKeyboard;
	}


	public EmotionEditText getPostComment() {
		return postComment;
	}


	public Button getSendBtn() {
		return sendBtn;
	}


	public SmoothViewPager getPager() {
		return pager;
	}


	public CirclePageIndicator getIndicator() {
		return indicator;
	}


	public NetworkImageView getHeadphoto() {
		return headphoto;
	}


	public TextView getUserName() {
		return userName;
	}


	public TextView getUserTitleLevel() {
		return userTitleLevel;
	}


	public TextView getRichTitleLevel() {
		return richTitleLevel;
	}


	public TextView getLiveRoomTitleLeft() {
		return liveRoomTitleLeft;
	}


	public TextView getLiveRoomBalance() {
		return liveRoomBalance;
	}


	public TextView getLiveRoomTitleRight() {
		return liveRoomTitleRight;
	}


	public ImageView getImageTip() {
		return imageTip;
	}


	public TextView getGiftType() {
		return giftType;
	}


	public TextView getCount() {
		return count;
	}


	public TextView getCntValue() {
		return cntValue;
	}


	public TextView getTargetName() {
		return targetName;
	}


	public Button getSendGiftBtn() {
		return sendGiftBtn;
	}


	public Solo getSolo() {
		return solo;
	}


	public Activity getActivity() {
		return activity;
	}


	public Button getConfirmButton() {
		return (Button) solo.getView(com.changba.live.R.id.confirm_btn);
	}


	public LiveInfoView getLiveRoomLiveInfo() {
		return liveRoomLiveInfo;
	}


	public TextView getPubicChatSystem() {
		return pubicChatSystem;
	}
	
	
	
	
		
	
	
}


