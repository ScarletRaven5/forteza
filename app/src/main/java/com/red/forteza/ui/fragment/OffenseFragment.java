package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.data.model.Cut;
import com.red.forteza.data.model.Cuts;
import com.red.forteza.ui.view.CutView;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OffenseFragment extends BaseFragment {

    @BindView(R.id.cuts_intro)
    TextView cutsIntro;
    @BindView(R.id.cut1)
    CutView mCut1;

    Cuts mCuts;

    public static OffenseFragment newInstance() {
        return new OffenseFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_offense;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        getActivity().setTitle(Res.string(R.string.nav_offense));

        mCuts = LocalApi.get().getCuts();
        cutsIntro.setText(mCuts.intro);

        Cut c1 = mCuts.cuts.get(0);
        mCut1.setCutInfo(c1.term, c1.translation, c1.meaning);

    }
}
