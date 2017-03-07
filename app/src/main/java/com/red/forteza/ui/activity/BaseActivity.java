package com.red.forteza.ui.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.red.forteza.R;
import com.red.forteza.ui.fragment.BaseFragment;
import com.red.forteza.ui.view.LoadingView;

public class BaseActivity extends AppCompatActivity {
    private static final String ROOT_FRAGMENT = "root";

    private FrameLayout mContainer;
    protected LoadingView mLoading;

    protected int getLayoutID() {
        return R.layout.activity_base;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        try {
            mContainer = (FrameLayout) findViewById(R.id.content_container);
            mLoading = (LoadingView) findViewById(R.id.loading_view);
        } catch (Exception e) {
            throw new RuntimeException("Layouts for activities extending BaseActivity must include layout/activity_base.xml", e);
        }
    }

    public void addContentToBackstack(BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void setContent(BaseFragment fragment) {
        getSupportFragmentManager().popBackStack(ROOT_FRAGMENT, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_container, fragment, ROOT_FRAGMENT)
                .addToBackStack(ROOT_FRAGMENT)
                .commit();
    }

    public View setContent(int layoutResID) {
        return LayoutInflater.from(mContainer.getContext()).inflate(layoutResID, mContainer, true);
    }

    public void setContent(View view) {
        super.setContentView(view);
    }


    public void setLoadingText(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(text)) {
                    mLoading.setVisibility(View.GONE);
                } else {
                    mLoading.setVisibility(View.VISIBLE);
                    mLoading.setText(text);
                }
            }
        });
    }

}
