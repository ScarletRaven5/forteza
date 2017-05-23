package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.ui.adapter.AppendixAdapter;
import com.red.forteza.util.Prefs;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppendixFragment extends BaseFragment {

    @BindView(R.id.recycler_terms)
    RecyclerView termsRecycler;

    AppendixAdapter mAdapter;

    public static AppendixFragment newInstance() {
        return new AppendixFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_appendix;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        String weapon = Prefs.getWeaponType();
        if (Res.string(R.string.rapier).equals(weapon)) {
            // TODO: rapier terms
            mAdapter = new AppendixAdapter(LocalApi.get().getTerms().data);
        } else if (Res.string(R.string.other).equals(weapon)) {
            // TODO: other terms
            mAdapter = new AppendixAdapter(LocalApi.get().getTerms().data);
        } else {
            mAdapter = new AppendixAdapter(LocalApi.get().getTerms().data);
        }

        termsRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        termsRecycler.setAdapter(mAdapter);
    }

}
