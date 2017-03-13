package com.red.forteza.util;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.red.forteza.App;


public class Res {

    public static float dp(float pixels) {
        return Resources.getSystem().getDisplayMetrics().density * pixels;
    }

    public static int color(int colorId) {
        return App.get().getResources().getColor(colorId);
    }

    public static String string(int stringId) {
        return App.get().getResources().getString(stringId);
    }

    public static String string(int stringId, Object... args) {
        return App.get().getResources().getString(stringId, args);
    }

    public static String[] stringArray(int arrayID) {
        return App.get().getResources().getStringArray(arrayID);
    }

    public static Drawable drawable(int drawableID) {
        return App.get().getResources().getDrawable(drawableID);
    }
}
