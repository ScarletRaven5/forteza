package com.red.forteza.util;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.red.forteza.App;


public class ResUtil {

    public static float dp(float pixels) {
        return Resources.getSystem().getDisplayMetrics().density * pixels;
    }

    public static int resolveColor(int colorId) {
        return App.get().getResources().getColor(colorId);
    }

    public static String resolveString(int stringId) {
        return App.get().getResources().getString(stringId);
    }

    public static String resolveString(int stringId, Object... args) {
        return App.get().getResources().getString(stringId, args);
    }

    public static String[] resolveStringArray(int arrayID) {
        return App.get().getResources().getStringArray(arrayID);
    }

    public static Drawable resolveDrawable(int drawableID) {
        return App.get().getResources().getDrawable(drawableID);
    }
}
