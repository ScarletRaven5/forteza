package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.data.model.Basic;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GripTabFragment extends TabFragment {

    @BindView(R.id.checkpoint1)
    TextView checkpoint1;
    @BindView(R.id.checkpoint2)
    TextView checkpoint2;
    @BindView(R.id.checkpoint3)
    TextView checkpoint3;

    Basic mBasic;

    public static GripTabFragment newInstance(Basic gripBasic) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Basic.ARG, gripBasic);
        GripTabFragment fragment = new GripTabFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_tab_grip;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mBasic = getArguments().getParcelable(Basic.ARG);

        checkpoint1.setText(Html.fromHtml(mBasic.checkpoints.get(0).text));
        checkpoint2.setText(Html.fromHtml(mBasic.checkpoints.get(1).text));
        checkpoint3.setText(Html.fromHtml(mBasic.checkpoints.get(2).text));
    }
}
