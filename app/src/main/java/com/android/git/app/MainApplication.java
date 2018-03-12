package com.android.git.app;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpHeaders;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @Title MainApplication
 * @Description: 应用配置
 * @Author lishuaibing
 * @Date 2018 2018/3/10 14:56
 */

public class MainApplication extends MultiDexApplication{
    public static Context APP_CONTEXT = null;
    @Override
    public void onCreate() {
        super.onCreate();
        APP_CONTEXT=this;
        initOkHttp();
    }
    private void initOkHttp() {
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.put("User-Agent", ApiConfig.getUserAgentInfo());
        httpHeaders.put("Connection", "Keep-Alive");
        //超时时间
        int timeOut = 20000;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //全局的读取超时时间
        builder.readTimeout(timeOut, TimeUnit.MILLISECONDS);
        //全局的写入超时时间
        builder.writeTimeout(timeOut, TimeUnit.MILLISECONDS);
        //全局的连接超时时间
        builder.connectTimeout(timeOut, TimeUnit.MILLISECONDS);

//        if (TextUtils.equals("google", ToolsUtil.getChannel(APP_CONTEXT))) {//谷歌应用市场，要设置域名验证
//            builder.hostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
//        }
        //必须调用初始化
        OkGo.getInstance().init(this)//
                .setOkHttpClient(builder.build())
                .setRetryCount(0)//全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonHeaders(httpHeaders);
    }
}
