package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.red.forteza.R;
import com.red.forteza.util.Res;

import butterknife.ButterKnife;

public class AnatomyFragment extends BaseFragment {

    public static AnatomyFragment newInstance() {
        return new AnatomyFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_anatomy;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        getActivity().setTitle(Res.string(R.string.nav_parts));

    }
}
