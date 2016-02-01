package com.hiepkhach9x.readbook;

import android.app.Application;

/**
 * Created by HungHN on 2/1/2016.
 */
public class BookApplication extends Application {

    private static BookApplication mBookApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mBookApplication = this;
    }

    public static BookApplication get() {
        return mBookApplication;
    }
}
