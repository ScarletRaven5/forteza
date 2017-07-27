package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.ui.adapter.GlossaryAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlossaryFragment extends BaseFragment {

    @BindView(R.id.recycler_terms)
    RecyclerView termsRecycler;

    GlossaryAdapter mAdapter;

    public static GlossaryFragment newInstance() {
        return new GlossaryFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_glossary;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

//        String weapon = Prefs.getWeaponType();
//        if (Res.string(R.string.rapier).equals(weapon)) {
//            // TODO: rapier terms
//            mAdapter = new GlossaryAdapter(LocalApi.get().getTerms().data);
//        } else if (Res.string(R.string.other).equals(weapon)) {
//            // TODO: other terms
//            mAdapter = new GlossaryAdapter(LocalApi.get().getTerms().data);
//        } else {
//            mAdapter = new GlossaryAdapter(LocalApi.get().getTerms().data);
//        }

        termsRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mAdapter = new GlossaryAdapter(LocalApi.get().getTerms().data);

        termsRecycler.setAdapter(mAdapter);
    }

}
