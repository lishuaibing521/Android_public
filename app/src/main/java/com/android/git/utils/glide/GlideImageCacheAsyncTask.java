package com.android.git.utils.glide;

import android.content.Context;
import android.os.AsyncTask;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.File;

/**
 * 创建者     lishuaibing
 * 创建时间    2017/11/20 14:14
 * 描述	     获取glide本地缓存的图片
 * <p>
 * 更新者
 * 更新时间
 * 更新描述
 */
public class GlideImageCacheAsyncTask extends AsyncTask<String, Void, File> {
    private final Context context;

    public GlideImageCacheAsyncTask(Context context, OnImageFileListener onImageFileListener) {
        this.context = context;
        this.onImageFileListener = onImageFileListener;
    }

    @Override
    protected File doInBackground(String... params) {
        String imgUrl = params[0];
        try {
            return Glide.with(context)
                    .load(imgUrl)
                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(File result) {
        if (onImageFileListener != null) {
            onImageFileListener.getImageFile(result);
        }
    }

    private OnImageFileListener onImageFileListener;

    public interface OnImageFileListener {
        void getImageFile(File file);
    }
}
