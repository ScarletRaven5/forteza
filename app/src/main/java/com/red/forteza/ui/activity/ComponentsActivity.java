package com.red.forteza.ui.activity;

import android.os.Bundle;

import com.red.forteza.ui.fragment.ComponentsFragment;

public class ComponentsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackNavigation();
        setContent(ComponentsFragment.newInstance());
    }
}
