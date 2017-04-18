package com.jrm.hailing;

import android.app.Application;

import com.sh.zsh.code.umeng_sdk.UMShareHelper;



/**
 * For developer startup JPush SDK
 * 
 *
 */
public class ExampleApplication extends Application {
    @Override
    public void onCreate() {    	     

         super.onCreate();
        //注册有盟
        UMShareHelper.init(this);
    }
}
