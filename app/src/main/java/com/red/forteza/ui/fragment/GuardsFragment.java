package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.red.forteza.R;
import com.red.forteza.data.model.Guard;
import com.red.forteza.ui.adapter.GuardsAdapter;
import com.red.forteza.util.Prefs;
import com.red.forteza.util.Res;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuardsFragment extends BaseFragment implements GuardsAdapter.Callback {

    @BindView(R.id.recycler_guards)
    RecyclerView guardsRecycler;

    ArrayList<Guard> mGuards = new ArrayList<>();
    String[] italianGuardNames;
    String[] englishGuardNames;
    String[] guardImages;

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
            //rapier names
        } else if (Res.string(R.string.other).equals(weapon)) {
            //other names

        } else {
            italianGuardNames = getResources().getStringArray(R.array.guards_longsword_italian);
            englishGuardNames = getResources().getStringArray(R.array.guards_longsword_english);
            guardImages = getResources().getStringArray(R.array.guards_longsword_images);
        }

        for (int i = 0; i < italianGuardNames.length; i++) {
            Guard guard = new Guard();
            guard.guardImage = guardImages[i];
            guard.italianGuardName = italianGuardNames[i];
            guard.englishGuardName = englishGuardNames[i];

            mGuards.add(guard);
        }

        mAdapter = new GuardsAdapter(mGuards, this);
        guardsRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        guardsRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onGuardClicked(Guard guard) {
        Bundle extras = new Bundle();
        extras.putParcelable(Guard.ARG, guard);
        getFragmentManager().beginTransaction()
                .add(R.id.content_container, GuardDetailsFragment.newInstance(extras))
                .addToBackStack(null)
                .commit();
    }
}
