package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.data.model.Cuts;
import com.red.forteza.data.model.Quarters;
import com.red.forteza.ui.view.CutView;
import com.red.forteza.ui.view.QuarterView;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OffenseFragment extends BaseFragment {

    @BindView(R.id.cuts_intro)
    TextView cutsIntro;
    @BindView(R.id.fendente)
    CutView fendente;
    @BindView(R.id.sottano)
    CutView sottano;
    @BindView(R.id.mezzano)
    CutView mezzano;
    @BindView(R.id.falso)
    CutView falso;
    @BindView(R.id.punta)
    CutView punta;

    @BindView(R.id.quarters_intro)
    TextView quartersIntro;
    @BindView(R.id.quarter_high)
    QuarterView highQuarter;
    @BindView(R.id.quarter_low)
    QuarterView lowQuarter;
    @BindView(R.id.quarter_inside)
    QuarterView insideQuarter;
    @BindView(R.id.quarter_outside)
    QuarterView outsideQuarter;

    Cuts mCuts;
    Quarters mQuarters;

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
        cutsIntro.setText(Html.fromHtml(mCuts.intro));
        fendente.setCutInfo(mCuts.cuts.get(0).term, mCuts.cuts.get(0).translation, mCuts.cuts.get(0).meaning);
        sottano.setCutInfo(mCuts.cuts.get(1).term, mCuts.cuts.get(1).translation, mCuts.cuts.get(1).meaning);
        mezzano.setCutInfo(mCuts.cuts.get(2).term, mCuts.cuts.get(2).translation, mCuts.cuts.get(2).meaning);
        falso.setCutInfo(mCuts.cuts.get(3).term, mCuts.cuts.get(3).translation, mCuts.cuts.get(3).meaning);
        punta.setCutInfo(mCuts.cuts.get(4).term, mCuts.cuts.get(4).translation, mCuts.cuts.get(4).meaning);

        mQuarters = LocalApi.get().getQuarters();
        quartersIntro.setText(Html.fromHtml(mQuarters.intro));
        highQuarter.setQuarterInfo(mQuarters.quarters.get(0).quarter, mQuarters.quarters.get(0).description);
        lowQuarter.setQuarterInfo(mQuarters.quarters.get(1).quarter, mQuarters.quarters.get(1).description);
        insideQuarter.setQuarterInfo(mQuarters.quarters.get(2).quarter, mQuarters.quarters.get(2).description);
        outsideQuarter.setQuarterInfo(mQuarters.quarters.get(3).quarter, mQuarters.quarters.get(3).description);
    }
}
