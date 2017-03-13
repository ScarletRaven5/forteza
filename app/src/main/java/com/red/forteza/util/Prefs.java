package com.red.forteza.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.red.forteza.App;
import com.red.forteza.R;

public class Prefs {

    private static final String KEY_WEAPON = "WEAPON";

    private static SharedPreferences get() {
        return PreferenceManager.getDefaultSharedPreferences(App.get());
    }

    public static String getWeaponType() {
        return get().getString(KEY_WEAPON, Res.string(R.string.longsword));
    }

    public static void setWeaponType(String weapon) {
        get().edit().putString(KEY_WEAPON, weapon).apply();
    }
}
