package com.red.forteza.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.data.model.Basics;
import com.red.forteza.util.Res;

import java.util.Arrays;
import java.util.List;

public class BasicsTabsFragment extends TabsFragment {

    public static BasicsTabsFragment newInstance() {
        return new BasicsTabsFragment();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Basics basics = LocalApi.get().getBasics();
    }

    @Override
    protected List<TabItem> getContents() {
        return Arrays.asList(
                new TabItem(Res.string(R.string.basic_stance)) {
                    @Override
                    protected TabFragment newInstance() {
                        return StanceTabFragment.newInstance();
                    }
                },
                new TabItem(Res.string(R.string.basic_grip)) {
                    @Override
                    protected TabFragment newInstance() {
                        return GripTabFragment.newInstance();
                    }
                },
                new TabItem(Res.string(R.string.basic_footwork)) {
                    @Override
                    protected TabFragment newInstance() {
                        return FootworkTabFragment.newInstance();
                    }
                },
                new TabItem(Res.string(R.string.basic_direction)) {
                    @Override
                    protected TabFragment newInstance() {
                        return EmptyTabFragment.newInstance();
                    }
                }
        );
    }
    @Override
    protected int getDefaultItemIndex() {
        return 0;
    }

    @Override
    protected View createTabView(Context context, TabItem item) {
        View view = super.createTabView(context, item);
        ((LinearLayout.LayoutParams) view.getLayoutParams()).weight = 1;
        return view;
    }
}
