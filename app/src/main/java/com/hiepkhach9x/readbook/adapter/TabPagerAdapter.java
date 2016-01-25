package com.hiepkhach9x.readbook.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hiepkhach9x.readbook.ListBookFragment;
import com.hiepkhach9x.readbook.R;

/**
 * Created by HungHN on 1/25/2016.
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {

    public final static int TAB_ALL = 0;
    public final static int TAB_TIEN_HIEP = 1;
    public final static int TAB_NGON_TINH = 2;

    private Context mContext;

    public TabPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TAB_ALL:
                Fragment fragmentHome = ListBookFragment.newInstanse();
                return fragmentHome;
            case TAB_TIEN_HIEP:
                Fragment fragmentTienHiep = ListBookFragment.newInstanse();
                return fragmentTienHiep;
            case TAB_NGON_TINH:
                Fragment fragmentNgonTinh = ListBookFragment.newInstanse();
                return fragmentNgonTinh;
            default:
                Fragment fragmentDefault = ListBookFragment.newInstanse();
                return fragmentDefault;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case TAB_ALL:
                return mContext.getString(R.string.title_tab_all);
            case TAB_TIEN_HIEP:
                return mContext.getString(R.string.title_tab_tien_hiep);
            case TAB_NGON_TINH:
                return mContext.getString(R.string.title_tab_ngon_tinh);
            default:
                return mContext.getString(R.string.app_name);
        }
    }
}
