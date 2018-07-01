package jp.gr.java_conf.ya.wearweatherapp; //  Copyright (c) 2018 YA<ya.androidapp@gmail.com> All rights reserved.

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class PrefUtil {
    private Context context;

    public PrefUtil(final Context context) {
        this.context = context;
    }

    public Boolean savePref(final String key, final String value) {
        try {
            if (context != null) {
                if (!"".equals(key)) {
                    SharedPreferences data = context.getSharedPreferences(key, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = data.edit();
                    editor.putString(key, value);
                    editor.apply();
                    return true;
                }
            }
        } catch (Exception e) {
            Log.d("WWA", e.toString());
        }
        return false;
    }

    public String loadPref(final String key) {
        try {
            if (context != null) {
                if (!"".equals(key)) {
                    SharedPreferences data = context.getSharedPreferences(key, Context.MODE_PRIVATE);
                    return data.getString(key, "");
                }
            }
        } catch (Exception e) {
            Log.d("WWA", e.toString());
        }

        return "";
    }
}

