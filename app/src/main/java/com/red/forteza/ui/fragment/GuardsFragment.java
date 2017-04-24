package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.data.model.Guard;
import com.red.forteza.ui.activity.GuardDetailsActivity;
import com.red.forteza.ui.activity.IntroductionActivity;
import com.red.forteza.ui.adapter.GuardsAdapter;
import com.red.forteza.util.Prefs;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuardsFragment extends BaseFragment implements GuardsAdapter.Callback {

    @BindView(R.id.recycler_guards)
    RecyclerView guardsRecycler;
    GuardsAdapter mAdapter;

    public static GuardsFragment newInstance() {
        return new GuardsFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_guards;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        String weapon = Prefs.getWeaponType();
        if (Res.string(R.string.rapier).equals(weapon)) {
            // TODO: rapier names
            mAdapter = new GuardsAdapter(LocalApi.get().getGuards().data, this);
        } else if (Res.string(R.string.other).equals(weapon)) {
            // TODO: other names
            mAdapter = new GuardsAdapter(LocalApi.get().getGuards().data, this);
        } else {
            mAdapter = new GuardsAdapter(LocalApi.get().getGuards().data, this);
        }

        guardsRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        guardsRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onGuardClicked(Guard guard) {
        Bundle extras = new Bundle();
        extras.putParcelable(Guard.ARG, guard);
        startActivity(GuardDetailsActivity.class, extras, false);
    }

    @OnClick(R.id.button_intro)
    protected void onIntroClick() {
        Bundle extra = new Bundle();
        extra.putString("intro", LocalApi.get().getGuards().intro);
       startActivity(IntroductionActivity.class, extra, false);
    }
}
