package com.red.forteza.ui.fragment;

import com.red.forteza.R;

public class EmptyTabFragment extends TabFragment {

    public static EmptyTabFragment newInstance() {
        return new EmptyTabFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_empty;
    }

}
