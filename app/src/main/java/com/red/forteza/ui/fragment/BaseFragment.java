package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.red.forteza.ui.activity.BaseActivity;


public class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null || getLayoutRes() == 0) {
            return null;
        }

        return inflater.inflate(getLayoutRes(), container, false);
    }

    protected int getLayoutRes() {
        return 0;
    }

    private BaseActivity getBaseActivity() {
        try {
            return (BaseActivity) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(String.format("%s must inherit from BaseActivity", getActivity().getClass().getName()));
        }
    }

    protected boolean runOnUiThread(Runnable runnable) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(runnable);
            return true;
        } else {
            return false;
        }
    }


}
