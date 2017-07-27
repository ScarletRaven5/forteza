package com.red.forteza.ui.fragment;

import com.red.forteza.R;

public class EmptyFragment extends BaseFragment {

    public static EmptyFragment newInstance() {
        return new EmptyFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_empty;
    }

}
