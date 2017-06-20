package com.red.forteza.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.red.forteza.ui.activity.BaseActivity;
import com.red.forteza.ui.view.FToolbar;


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

    protected void setTitle(String title) {
        getBaseActivity().setTitle(title);
    }

    public void startActivity(Class<? extends Activity> destination, Bundle extras, boolean finish) {
        getBaseActivity().startActivity(destination, extras, finish);
    }

    public void startActivityWithClearStack(Class<? extends Activity> destination, Bundle extras) {
        getBaseActivity().startActivityWithClearStack(destination, extras);
    }

    public void startActivity(Intent intent, boolean finish) {
        getBaseActivity().startActivity(intent, finish);
    }

    public void bindPager(ViewPager pager) {
        getBaseActivity().bindPager(pager);
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    protected void setActions(FToolbar.Action... actions) {
        getBaseActivity().setActions(actions);
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
