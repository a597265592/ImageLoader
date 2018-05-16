package com.example.admin.imageloader.share;

import android.content.Context;
import android.widget.Toast;

import com.example.admin.imageloader.Config.ThirdConfigManager;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2018/5/11.
 */

public class UMengShareHelper {
    public static final String[] QZONE_PACKAGE_NAME = new String[]{"com.tencent.mobileqq", "com.qzone"};
    public static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
    public static final String QQ_LITE_PACKAGE_NAME = "com.tencent.qqlite";
    public static final String WECHAT_PACKAGE_NAME = "com.tencent.mm";
    public static final String[] WEIBO_PACKAGE_NAME = new String[]{"com.sina.weibo", "com.sina.weibolite", "com.weico.international", "com.sina.weibog3"};
    private static UMShareListener mListener;

    public static void init(final Context context){
        PlatformConfig.setWeixin(ThirdConfigManager.WX_APP_ID, ThirdConfigManager.WX_APP_SECRET);
        PlatformConfig.setQQZone(ThirdConfigManager.QQ_APP_ID, ThirdConfigManager.QQ_APP_KEY);
        PlatformConfig.setSinaWeibo(ThirdConfigManager.WEIBO_APP_ID, ThirdConfigManager.WEIBO_APP_KEY, "http://sns.whalecloud.com");
        mListener = new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onResult(SHARE_MEDIA share_media) {
                Toast.makeText(context, "分享成功",Toast.LENGTH_SHORT).show();
                finishShareActivity();
            }

            @Override
            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                Toast.makeText(context, "分享失败，请确认程序已经安装",Toast.LENGTH_SHORT).show();
                finishShareActivity();
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media) {
                finishShareActivity();
            }
        };
    }

    private static void finishShareActivity() {

    }
}
