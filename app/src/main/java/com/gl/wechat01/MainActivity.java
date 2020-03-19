package com.gl.wechat01;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends Activity implements View.OnClickListener {
    private Fragment mtab1=new weixingFragment();
    private Fragment mtab2=new friendFragment();
    private Fragment mtab3=new contactFragment();
    private Fragment mtab4=new settingFragment();

    private FragmentManager fm;
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFri;
    private LinearLayout mTabContact;
    private LinearLayout mTabSetting;

    private ImageButton mImageWeixin;
    private ImageButton mImageFriend;
    private ImageButton mImageContact;
    private ImageButton mImageSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initFragment();
        initView();
        initEvent();
        setSelect(0);

    }

    @Override
    public void onClick(View v) {
        Log.i("onclick", "view");
        resetImgs();
        switch (v.getId()){
            case R.id.id_tab_weixin:
                setSelect(0);
                break;
            case R.id.id_tab_friend:
                setSelect(1);
                break;
            case R.id.id_tab_contact:
                setSelect(2);
                break;
            case R.id.id_tab_setting:
                setSelect(3);
                break;
            default:
                System.out.println(v.getId()+"deafult ");
                break;
        }
    }

    private void initEvent(){
        mTabWeixin.setOnClickListener(this);
        mTabFri.setOnClickListener(this);
        mTabContact.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }
    private void resetImgs() {
        mImageWeixin.setImageResource(R.drawable.tab_weixin_normal);
        mImageFriend.setImageResource(R.drawable.tab_find_frd_normal);
        mImageContact.setImageResource(R.drawable.tab_address_normal);
        mImageSetting.setImageResource(R.drawable.tab_settings_normal);
    }

    private void initFragment(){
        fm=getFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        tr.add(R.id.id_content, mtab1);
        tr.add(R.id.id_content, mtab2);
        tr.add(R.id.id_content, mtab3);
        tr.add(R.id.id_content, mtab4);
        tr.commit();
    }

    private void initView(){
        mTabWeixin = (LinearLayout)findViewById(R.id.id_tab_weixin);
        mTabFri = (LinearLayout)findViewById(R.id.id_tab_friend);
        mTabContact = (LinearLayout)findViewById(R.id.id_tab_contact);
        mTabSetting = (LinearLayout)findViewById(R.id.id_tab_setting);

//        图片
        mImageWeixin =(ImageButton)findViewById(R.id.image_weixin);
        mImageFriend =(ImageButton)findViewById(R.id.image_friend);
        mImageContact =(ImageButton)findViewById(R.id.image_contact);
        mImageSetting =(ImageButton)findViewById(R.id.image_setting);

    }

    //show fragment
    private void setSelect(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                Log.d("select","i");
                transaction.show(mtab1);
                mImageWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                Log.d("select","i");
                transaction.show(mtab2);
                mImageFriend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                Log.d("select","i");
                transaction.show(mtab3);
                mImageContact.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                Log.d("select","i");
                transaction.show(mtab4);
                mImageSetting.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                Log.d("error case","i");
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(mtab1);
        transaction.hide(mtab2);
        transaction.hide(mtab3);
        transaction.hide(mtab4);
    }


}
