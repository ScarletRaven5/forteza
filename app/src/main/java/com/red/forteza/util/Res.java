package com.red.forteza.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.red.forteza.App;


public class Res {

    public static float dp(float pixels) {
        return Resources.getSystem().getDisplayMetrics().density * pixels;
    }

    public static int dpi(int i) {
        return (int)dp((float)i);
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

    public static int drawableId(Context context, String drawable) {
        return context.getResources().getIdentifier(drawable, "drawable", context.getPackageName());
    }

    public static int identifyRaw(Context context, String name) {
        return context.getResources().getIdentifier(name, "raw", context.getPackageName());
    }
}
