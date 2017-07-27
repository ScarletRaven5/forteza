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

public class StanceTabFragment extends TabFragment {

    @BindView(R.id.paragraph1)
    TextView paragraph1;
    @BindView(R.id.paragraph2)
    TextView paragraph2;
    @BindView(R.id.checkpoint1)
    TextView checkpoint1;
    @BindView(R.id.checkpoint2)
    TextView checkpoint2;
    @BindView(R.id.checkpoint3)
    TextView checkpoint3;
    @BindView(R.id.checkpoint4)
    TextView checkpoint4;

    Basic mBasic;

    public static StanceTabFragment newInstance(Basic stanceBasic) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Basic.ARG, stanceBasic);
        StanceTabFragment fragment = new StanceTabFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_tab_stance;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mBasic = getArguments().getParcelable(Basic.ARG);

        paragraph1.setText(Html.fromHtml(mBasic.paragraphs.get(0).text));
        paragraph2.setText(Html.fromHtml(mBasic.paragraphs.get(1).text));
        checkpoint1.setText(Html.fromHtml(mBasic.checkpoints.get(0).text));
        checkpoint2.setText(Html.fromHtml(mBasic.checkpoints.get(1).text));
        checkpoint3.setText(Html.fromHtml(mBasic.checkpoints.get(2).text));
        checkpoint4.setText(Html.fromHtml(mBasic.checkpoints.get(3).text));
    }
}
