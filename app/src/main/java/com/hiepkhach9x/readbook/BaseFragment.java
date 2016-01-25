package com.hiepkhach9x.readbook;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by HungHN on 1/25/2016.
 */
public abstract class BaseFragment extends Fragment {

    MainActivity mainActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof MainActivity){
            mainActivity = (MainActivity) activity;
        }
    }

    public abstract void findId(View view);
}
