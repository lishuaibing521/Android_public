package com.android.git.utils.glide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * @Title GlideHelper
 * @Description: Glide工具类
 * @Author lishuaibing
 * @Date 2016 2016/11/18 11:26
 */

public class GlideHelper {
    public static void loadImg(Context context,@NonNull String path,@DrawableRes int defaultImg, ImageView image) {
        if (isFinish(context)) return;
        Glide.with(context).load(path).apply(requestOptionsConfig(defaultImg)).into(image);
    }

    @SuppressLint("CheckResult")
    private static RequestOptions requestOptionsConfig(@DrawableRes int defaultImg) {
        RequestOptions options = new RequestOptions();
        options.dontTransform()
                .dontAnimate()
                .placeholder(defaultImg)
                .error(defaultImg);
        return options;
    }

    /**
     * 本地磁盘缓存
     */
    public static void loadImgDiskCacheStrategy(Context context,@NonNull String path, @DrawableRes int defaultImg, ImageView image) {
        if (isFinish(context)) return;
        Glide.with(context).load(path).apply(requestOptionsConfig(defaultImg).diskCacheStrategy(DiskCacheStrategy.ALL)).into(image);
    }

    @SuppressLint("CheckResult")
    private static RequestOptions requestOptionsConfig() {
        RequestOptions options = new RequestOptions();
        options.dontTransform()
                .dontAnimate();
        return options;
    }
    public static void loadImgWithNoAnim(Context context, String path, @DrawableRes int defaultImg, ImageView image) {
        if (isFinish(context)) return;
        Glide.with(context).load(path).apply(requestOptionsConfig(defaultImg)).into(image);
    }

    private static boolean isFinish(Context context) {
        if (((Activity) context).isFinishing()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (((Activity) context).isDestroyed()) {
                return true;
            }
        }
        return false;
    }

    public static void loadImg(Context context,@DrawableRes int resouceId,@DrawableRes int defaultImg, ImageView image) {
        if (isFinish(context)) return;
        Glide.with(context).load(resouceId).apply(requestOptionsConfig(defaultImg)).into(image);
    }

    public static void loadImg(Context context, String path, ImageView image) {
        if (isFinish(context)) return;
        Glide.with(context).load(path).apply(requestOptionsConfig()).into(image);
    }

    public static void loadImg(Context context, int path, ImageView image) {
        if (isFinish(context)) return;
        Glide.with(context).load(path).apply(requestOptionsConfig()).into(image);
    }

    /**
     * 加载gif图片
     */
    public static void loadImgGif(Context context, String path, ImageView image) {
        if (isFinish(context)) return;
        Glide.with(context).asGif().load(path).into(image);
    }

    /**
     * 加载圆形图片
     */
    @SuppressLint("CheckResult")
    public static void loadCircleImg(Context context, String path, int defaultImg, ImageView image) {
        if (isFinish(context)) return;
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        requestOptions.dontTransform()
                .dontAnimate()
                .placeholder(defaultImg)
                .error(defaultImg);
        Glide.with(context).load(path).apply(requestOptions).into(image);
    }

    /**
     * 加载圆角图片
     */
    @SuppressLint("CheckResult")
    public static void loadRoundImg(Context context, String path, int defaultImg, ImageView image, int dp) {
        if (isFinish(context)) return;
        Glide.with(context).load(path).apply(requestOptionsConfig(defaultImg).transform(new GlideRoundTransform(context,dp))).into(image);
    }

    /**
     * 加载返回bitmap
     */
    public static void loadImgBitmap(Context context, String path, SimpleTarget<Bitmap> target) {
        if (isFinish(context)) return;
        Glide.with(context).asBitmap().load(path).into(target);
    }

    /**
     * 加载返回bitmap
     */
    public static void loadImgBitmapNoAnim(Context context, String path, SimpleTarget<Bitmap> target) {
        if (isFinish(context)) return;
        Glide.with(context).asBitmap().load(path).apply(requestOptionsConfig()).into(target);
    }

    /**
     * 加载返回bitmap
     */
    public static void loadImgBitmapNoAnim(Context context, int path, SimpleTarget<Bitmap> target) {
        if (isFinish(context)) return;
        Glide.with(context).asBitmap().load(path).apply(requestOptionsConfig()).into(target);
    }

    /**
     * 加载返回bitmap
     */
    public static void loadImgBitmapNoAnim(Context context, String path, int defaultImg, SimpleTarget<Bitmap> target) {
        if (isFinish(context)) return;
        Glide.with(context).asBitmap().load(path).apply(requestOptionsConfig(defaultImg)).into(target);
    }

    /**
     * 加载返回bitmap
     */
    public static void loadImgBitmap(Context context, int resouceId, SimpleTarget<Bitmap> target) {
        if (isFinish(context)) return;
        Glide.with(context).asBitmap().load(resouceId).into(target);
    }

    /**
     * 加载返回bitmap
     */
    public static void loadImgBitmapNoCache(Context context, String path, SimpleTarget<Bitmap> target) {
        if (isFinish(context)) return;
        Glide.with(context).asBitmap().load(path).apply(requestOptionsConfig().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE)).into(target);
    }

    /**
     * 有加载监听（有默认图）
     */
    public static void loadImg(Context context, String path, int defaultImg, SimpleTarget<Drawable> target) {
        if (isFinish(context)) return;
        Glide.with(context).load(path).apply(requestOptionsConfig(defaultImg)).into(target);
    }

    /**
     * 有加载监听（无默认图）
     */
    public static void loadImg(Context context, String path, SimpleTarget<Drawable> target) {
        if (isFinish(context)) return;
        Glide.with(context).load(path).apply(requestOptionsConfig()).into(target);
    }

    /**
     * 跳过缓存
     */
    public static void loadImgNoCache(Context context, String path, int defaultImg, ImageView image) {
        if (isFinish(context)) return;
        Glide.with(context).load(path).apply(requestOptionsConfig(defaultImg).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE)).into(image);
    }

    /**
     * 跳过缓存
     */
    public static void loadImgNoCache(Context context, String path, ImageView image) {
        if (isFinish(context)) return;
        Glide.with(context).load(path).apply(requestOptionsConfig().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE)).into(image);
    }

    /**
     * 清除图片磁盘缓存
     */
    public static void clearImageDiskCache(final Context context) {
        try {
            if (isFinish(context)) return;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(() -> Glide.get(context).clearDiskCache()).start();
            } else {
                Glide.get(context).clearDiskCache();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 清除图片内存缓存
     */
    public static void clearImageMemoryCache(Context context) {
        try {
            if (isFinish(context)) return;
            if (Looper.myLooper() == Looper.getMainLooper()) { //只能在主线程执行
                Glide.get(context).clearMemory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 清除图片所有缓存
     */
    public static void clearImageAllCache(Context context) {
        if (isFinish(context)) return;
        clearImageDiskCache(context);
        clearImageMemoryCache(context);
    }
}
