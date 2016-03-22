package com.changba.live.test;

import com.changba.live.test.elements.ElementsLive;
import com.changba.live.test.elements.ElementsOtherProfile;
import com.changba.live.test.elements.ElementsProfile;
import com.changba.live.test.elements.ElementsProfileCollections;
import com.changba.live.test.elements.ElementsSetting;
import com.changba.live.test.elements.ElementsSettingAbout;
import com.changba.live.test.elements.ElementsSettingAgreement;
import com.changba.live.test.elements.ElementsSettingFeedBack;
import com.changba.live.test.elements.ElementsSettingHelp;
import com.changba.live.test.elements.ElementsSettingInfoPush;
import com.changba.live.test.elements.ElementsWonderfulShow;
import com.robotium.solo.Solo;

/**
 * ͳһ������ڣ���Ҫ�����ؼ�ʱ����ͨ������ڵõ���Ӧ�ؼ���
 * @author tv
 *
 */
public class UIHelper {
	
	private Solo solo;
	private ElementsProfile elementsProfile;//��ҳ��
	private ElementsWonderfulShow elementsWonderfulShow;//���ʱ���
	private ElementsSetting elementsSetting;//����ҳ
	private ElementsSettingAgreement elementsSettingAgreement;//�����е�����
	private ElementsSettingHelp elementsSettingHelp;//�����еİ�������
	private ElementsSettingAbout elementsSettingAbout;
	private ElementsSettingFeedBack elementsSettingFeedBack;
	private ElementsSettingInfoPush elementsSettingInfoPush;//��������
	private ElementsProfileCollections elementsProfileCollections;//�ղ�
	private ElementsLive elementsLive;//ֱ����
	private ElementsOtherProfile elementsOtherProfile;//ֱ����
	
	
	public UIHelper(Solo solo){
		this.solo=solo;
	}
	public Solo getSolo(){
		return solo;
	}
	public ElementsProfile getElementsProfile(){
		if(elementsProfile==null){
			elementsProfile=new ElementsProfile(solo);
		}
		return elementsProfile;
	}
	
	public ElementsWonderfulShow getElementsWonderfulShow(){
		if(elementsWonderfulShow==null){
			elementsWonderfulShow=new ElementsWonderfulShow(solo);}
		return elementsWonderfulShow;
	}
	public ElementsSetting getElementsSetting(){
		if(elementsSetting==null)
			elementsSetting=new ElementsSetting(solo);
		return elementsSetting;
	}
	public ElementsSettingAgreement getElementsSettingAgreement() {
		if(elementsSettingAgreement==null)
			elementsSettingAgreement=new ElementsSettingAgreement(solo);
		return elementsSettingAgreement;
	}
	public ElementsSettingHelp getElementsSettingHelp(){
		if(elementsSettingHelp==null)
			elementsSettingHelp=new ElementsSettingHelp(solo);
		return elementsSettingHelp;
	}
	public ElementsSettingAbout getElementsSettingaAbout(){
		if(elementsSettingAbout==null)
			elementsSettingAbout=new ElementsSettingAbout(solo);
			return elementsSettingAbout;
	}
	public ElementsSettingFeedBack getElementsSettingFeedBack(){
		if(elementsSettingFeedBack==null)
			elementsSettingFeedBack=new ElementsSettingFeedBack(solo);
		return elementsSettingFeedBack;
	}
	public ElementsSettingInfoPush getElementsSettingInfoPush(){
		if(elementsSettingInfoPush==null)
			elementsSettingInfoPush=new ElementsSettingInfoPush(solo);
		return elementsSettingInfoPush;
	}
	public ElementsProfileCollections getCollections(){
		if(elementsProfileCollections==null)
			elementsProfileCollections=new ElementsProfileCollections(solo);
		return elementsProfileCollections;
	}
	public ElementsLive getElementsLive() {
		// TODO Auto-generated method stub
		if(elementsLive==null)
			elementsLive=new ElementsLive(solo);
		return elementsLive;
	}
	public ElementsOtherProfile getElementsOtherProfile() {
		// TODO Auto-generated method stub
		if(elementsOtherProfile==null)
			elementsOtherProfile=new ElementsOtherProfile(solo);
		return elementsOtherProfile;
	}
}
