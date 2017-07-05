package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.red.forteza.R;
import com.red.forteza.util.Res;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        getActivity().setTitle(Res.string(R.string.nav_home));
    }

    @OnClick(R.id.banner_guards)
    protected void goToGuards() {
        setTitle(Res.string(R.string.nav_guards));
        pushFragment(GuardsFragment.newInstance());
    }

    @OnClick(R.id.banner_drills)
    protected void goToDrills() {
        setTitle(Res.string(R.string.nav_guards));
        pushFragment(OffenseFragment.newInstance());
    }

    @OnClick(R.id.banner_components)
    protected void goToComponents() {
        setTitle(Res.string(R.string.nav_guards));
        pushFragment(ComponentsFragment.newInstance());
    }

    @OnClick(R.id.banner_terms)
    protected void goToTerms() {
        setTitle(Res.string(R.string.nav_glossary));
        pushFragment(GlossaryFragment.newInstance());
    }
}
