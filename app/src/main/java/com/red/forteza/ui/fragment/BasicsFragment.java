package com.red.forteza.ui.fragment;

import com.red.forteza.R;
import com.red.forteza.ui.activity.EmptyActivity;

import butterknife.OnClick;

public class BasicsFragment extends BaseFragment {

    public static BasicsFragment newInstance() {
        return new BasicsFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_basics;
    }

    @OnClick(R.id.basic_stance)
    protected void openStance() {
        // TODO
        startActivity(EmptyActivity.class, null, false);
    }

    @OnClick(R.id.basic_grip)
    protected void openGripe() {
        // TODO
        startActivity(EmptyActivity.class, null, false);
    }

    @OnClick(R.id.basic_footwork)
    protected void openFootwork() {
        // TODO
        startActivity(EmptyActivity.class, null, false);
    }

    @OnClick(R.id.basic_direction)
    protected void openDireciton() {
        // TODO
        startActivity(EmptyActivity.class, null, false);
    }
}
