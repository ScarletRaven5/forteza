package com.red.forteza.ui.fragment;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.data.model.TandDs;
import com.red.forteza.util.Res;

import java.util.Arrays;
import java.util.List;

public class TandDTabsFragment extends TabsFragment {

    TandDs mTiming;
    TandDs mDistance;

    public static TandDTabsFragment newInstance() {
        return new TandDTabsFragment();
    }

    @Override
    protected List<TabItem> getContents() {
        mTiming = LocalApi.get().getTiming();
        mDistance = LocalApi.get().getDistance();

        return Arrays.asList(
                new TabItem(Res.string(R.string.timing)) {
                    @Override
                    protected TabFragment newInstance() {
                        return TandDTabFragment.newInstance(mTiming);
                    }
                },
                new TabItem(Res.string(R.string.distance)) {
                    @Override
                    protected TabFragment newInstance() {
                        return TandDTabFragment.newInstance(mDistance);
                    }
                }
        );
    }
}
