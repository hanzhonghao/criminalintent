package com.jrm.hailing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.sh.zsh.code.umeng_sdk.ShareActivity;
import com.sh.zsh.code.umeng_sdk.ShareDialog;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton weixin;
    Button share;
    Button share1;

    UMShareAPI mShareAPI;
    LinearLayout activityMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weixin = (ImageButton) findViewById(R.id.weixin);
        share= (Button) findViewById(R.id.share);
        share1= (Button) findViewById(R.id.share1);
        activityMain = (LinearLayout) findViewById(R.id.activity_main);
        weixin.setOnClickListener(this);
        share.setOnClickListener(this);
        share1.setOnClickListener(this);
         mShareAPI = UMShareAPI.get(this);

    }




        //登录 回调 文档 http://dev.umeng.com/social/android/login-page#2
        UMAuthListener umAuthListener = new UMAuthListener() {
            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Log.i("登录结果",map.toString());
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        };

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.weixin://微信
                mShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
                break;
            case R.id.share1://分享
                ShareActivity.share(activityMain,this,null,"测试分享","https://www.baidu.co,","测试分享");
                break;
            case R.id.share://分享
                ShareDialog.getInstance(this,null,"测试分享","https://www.baidu.co,","测试分享").showDialog();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}
