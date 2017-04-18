package com.sh.zsh.code.umeng_sdk;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by zhush on 2017/2/6.
 * E-mail 405086805@qq.com
 * PS
 */
public class UMShareHelper {

    public static  Context context;

    public static void init(Application application){
        context=application;
       Resources resources= application.getResources();
        //注册第三方 id
        PlatformConfig.setWeixin(resources.getString(R.string.wexin_app_id), resources.getString(R.string.wexin_app_secret));
        UMShareAPI.get(application);
    }

}
