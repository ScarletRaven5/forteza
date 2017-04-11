package com.red.forteza.ui.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.red.forteza.R;
import com.red.forteza.ui.fragment.BaseFragment;
import com.red.forteza.ui.view.LoadingView;
import com.red.forteza.util.CustomToolbar;
import com.red.forteza.util.Res;

import java.util.List;

public class BaseActivity extends FragmentActivity {
    private static final String ROOT_FRAGMENT = "root";

    private FrameLayout mContainer;
    protected LoadingView mLoading;
    protected CustomToolbar mToolbar;

    protected int getLayoutID() {
        return R.layout.activity_base;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        try {
            mContainer = (FrameLayout) findViewById(R.id.content_container);
            mToolbar = (CustomToolbar) findViewById(R.id.toolbar);
            mLoading = (LoadingView) findViewById(R.id.loading_view);
        } catch (Exception e) {
            throw new RuntimeException("Layouts for activities extending BaseActivity must include layout/activity_base.xml", e);
        }
        setTitle("");

    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
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

    public void startActivity(Class<? extends Activity> destination, Bundle extras, boolean finish) {
        Intent intent = new Intent(this, destination);
        if (extras != null) {
            intent.putExtras(extras);
        }

        startActivity(intent, finish);
    }

    public void startActivityWithClearStack(Class<? extends Activity> destination, Bundle extras) {
        Intent intent = new Intent(this, destination);
        if (extras != null) {
            intent.putExtras(extras);
        }

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void startActivity(Intent intent, boolean finish) {
        startActivity(intent);

        if (finish) {
            finish();
        }
    }

    public void setBackNavigation() {
        mToolbar.setNavigation(R.drawable.ic_action_back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void setTitle(int id) {
        setTitle(Res.string(id));
    }

    public void setTitle(String title) {
        mToolbar.setTitle(title);
    }

    public void setActions(CustomToolbar.Action... actions) {
        mToolbar.setActions(actions);
    }

    public void setActions(List<CustomToolbar.Action> actions) {
        mToolbar.setActions(actions);
    }


}
