package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.data.model.Guards;
import com.red.forteza.ui.activity.IntroductionActivity;
import com.red.forteza.ui.adapter.GuardsAdapter;
import com.red.forteza.ui.view.FToolbar;
import com.red.forteza.util.Prefs;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuardsFragment extends BaseFragment {

    @BindView(R.id.recycler_guards)
    RecyclerView guardsRecycler;
    GuardsAdapter mAdapter;

    Guards mGuards;

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
        mGuards = LocalApi.get().getGuards();
        if (Res.string(R.string.rapier).equals(weapon)) {
            // TODO: rapier names
            mAdapter = new GuardsAdapter(mGuards.data);
        } else if (Res.string(R.string.other).equals(weapon)) {
            // TODO: other names
            mAdapter = new GuardsAdapter(mGuards.data);
        } else {
            mAdapter = new GuardsAdapter(mGuards.data);
        }

        guardsRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        guardsRecycler.setAdapter(mAdapter);

        setActions(new FToolbar.Action("INTRO") {
            @Override
            public void onClick(View v) {
                Bundle extra = new Bundle();
                extra.putString("title", mGuards.introTitle);
                extra.putString("text", mGuards.introText);
                startActivity(IntroductionActivity.class, extra, false);
            }
        });
    }
}
