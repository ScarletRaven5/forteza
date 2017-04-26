package com.red.forteza.ui.fragment;

import com.red.forteza.R;

public class GripTabFragment extends TabFragment {

    public static GripTabFragment newInstance() {
        return new GripTabFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_tab_grip;
    }
}
