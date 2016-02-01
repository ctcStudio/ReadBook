package com.hiepkhach9x.readbook.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.hiepkhach9x.readbook.BookApplication;
import com.hiepkhach9x.readbook.entities.BookSetting;

/**
 * Created by HungHN on 2/1/2016.
 */
public class SettingBookPreferences {
    private static String TAG = "UserPreferences";
    private static final String FILE_PREFERENCES = "com.hiepkhach9x.readbook.setting";
    private static Context mContext;
    private Gson gson = new Gson();

    private static final String KEY_SETTING = "key.setting";

    protected SettingBookPreferences() {
        this.mContext = BookApplication.get();
    }

    public static SettingBookPreferences getInstance(Context context) {
        return new SettingBookPreferences();
    }

    private SharedPreferences.Editor getEditor() {
        if (mContext == null) {
            return null;
        }
        return mContext.getSharedPreferences(FILE_PREFERENCES,
                Context.MODE_PRIVATE).edit();
    }

    private SharedPreferences getSharedPreferences() {
        if (mContext == null) {
            return null;
        }
        return mContext.getSharedPreferences(FILE_PREFERENCES,
                Context.MODE_PRIVATE);
    }

    public void registerOnChange(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        if (listener != null) {
            getSharedPreferences().registerOnSharedPreferenceChangeListener(
                    listener);
        }
    }

    public void unregisterOnChange(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        if (listener != null) {
            getSharedPreferences().unregisterOnSharedPreferenceChangeListener(
                    listener);
        }
    }

    public void apply() {
        getEditor().apply();
    }

    public void clear() {
        getEditor().clear().commit();
    }

    public boolean saveSetting(BookSetting bookSetting) {
        String strSetting = gson.toJson(bookSetting);
        return getEditor().putString(KEY_SETTING, strSetting).commit();
    }

    public BookSetting getSetting() {
        String strSetting = getSharedPreferences().getString(KEY_SETTING, "");
        BookSetting bookSetting = gson.fromJson(strSetting, BookSetting.class);
        return bookSetting;
    }
}
