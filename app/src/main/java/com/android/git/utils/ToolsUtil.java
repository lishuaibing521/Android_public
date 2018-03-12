package com.android.git.utils;

import android.content.Context;

/**
 * @Title ToolsUtil
 * @Description: TODO
 * @Author lishuaibing
 * @Date 2018 2018/3/10 15:45
 */

public class ToolsUtil {
    // 转换dip为px
    public static int convertDIP2PX(Context context, int dip) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }

    // 转换px为dip
    public static int convertPX2DIP(Context context, int px) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f * (px >= 0 ? 1 : -1));
    }
}
