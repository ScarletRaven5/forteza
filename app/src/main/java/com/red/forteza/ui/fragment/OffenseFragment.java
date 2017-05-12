package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.data.model.Cuts;
import com.red.forteza.ui.view.CutView;
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

        fendente.setCutInfo(mCuts.cuts.get(0).term, mCuts.cuts.get(0).translation, mCuts.cuts.get(0).meaning);
        sottano.setCutInfo(mCuts.cuts.get(1).term, mCuts.cuts.get(1).translation, mCuts.cuts.get(1).meaning);
        mezzano.setCutInfo(mCuts.cuts.get(2).term, mCuts.cuts.get(2).translation, mCuts.cuts.get(2).meaning);
        falso.setCutInfo(mCuts.cuts.get(3).term, mCuts.cuts.get(3).translation, mCuts.cuts.get(3).meaning);
        punta.setCutInfo(mCuts.cuts.get(4).term, mCuts.cuts.get(4).translation, mCuts.cuts.get(4).meaning);
    }
}
