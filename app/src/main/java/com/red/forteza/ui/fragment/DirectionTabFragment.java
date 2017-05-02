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

public class DirectionTabFragment extends TabFragment {

    @BindView(R.id.paragraph1)
    TextView paragraph1;
    @BindView(R.id.paragraph2)
    TextView paragraph2;
    @BindView(R.id.paragraph3)
    TextView paragraph3;

    Basic mBasic;

    public static DirectionTabFragment newInstance(Basic directionBasic) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Basic.ARG, directionBasic);
        DirectionTabFragment fragment = new DirectionTabFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_tab_direction;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mBasic = getArguments().getParcelable(Basic.ARG);

        paragraph1.setText(Html.fromHtml(mBasic.paragraphs.get(0).text));
        paragraph2.setText(Html.fromHtml(mBasic.paragraphs.get(1).text));
        paragraph3.setText(Html.fromHtml(mBasic.paragraphs.get(2).text));
    }

}
