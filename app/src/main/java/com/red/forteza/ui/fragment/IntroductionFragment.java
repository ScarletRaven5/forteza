package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.red.forteza.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroductionFragment extends BaseFragment {

    @BindView(R.id.content_intro)
    TextView paragraph1;

    public static IntroductionFragment newInstance() {
        return new IntroductionFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_intro;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        paragraph1.setText(getResources().getText(R.string.guards_p1));

    }
}
