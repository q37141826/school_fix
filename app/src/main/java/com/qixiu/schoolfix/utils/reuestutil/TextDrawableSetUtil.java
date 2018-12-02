package com.qixiu.schoolfix.utils.reuestutil;

import android.content.Context;
import android.os.Build;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/11/28.
 */

public class TextDrawableSetUtil {
    public static void setRightImage(Context context, TextView textview, int resource) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            textview.setCompoundDrawablesWithIntrinsicBounds(resource, 0, 0, 0);
        } else {
            textview.setCompoundDrawables(context.getResources().getDrawable(resource), null, null, null);
        }
    }
}
