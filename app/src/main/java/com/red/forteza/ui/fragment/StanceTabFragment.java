package com.red.forteza.ui.fragment;

import com.red.forteza.R;

public class StanceTabFragment extends TabFragment {

    public static StanceTabFragment newInstance() {
        return new StanceTabFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_tab_stance;
    }
}
