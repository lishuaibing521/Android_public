package com.android.git.utils.glide;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;

/**
 * @Title MyAppGlideModule
 * @Description: TODO
 * @Author lishuaibing
 * @Date 2018 2018/3/10 15:12
 */
@GlideModule
public class MyAppGlideModule extends AppGlideModule{
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        builder.setMemoryCache(new LruResourceCache(10 * 1024 * 1024));
    }
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
