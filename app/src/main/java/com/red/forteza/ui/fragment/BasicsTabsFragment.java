package com.red.forteza.ui.fragment;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.data.model.Basic;
import com.red.forteza.data.model.Basics;
import com.red.forteza.util.Res;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicsTabsFragment extends TabsFragment {

    Basics mBasics;
    ArrayList<Basic> mFootworks = new ArrayList<>();

    public static BasicsTabsFragment newInstance() {
        return new BasicsTabsFragment();
    }

    @Override
    protected List<TabItem> getContents() {
        mBasics = LocalApi.get().getBasics();
        mFootworks.add(mBasics.data.get(2));
        mFootworks.add(mBasics.data.get(4));
        mFootworks.add(mBasics.data.get(5));
        mFootworks.add(mBasics.data.get(6));

        return Arrays.asList(
                new TabItem(Res.string(R.string.basic_stance)) {
                    @Override
                    protected TabFragment newInstance() {
                        return StanceTabFragment.newInstance(mBasics.data.get(0));
                    }
                },
                new TabItem(Res.string(R.string.basic_grip)) {
                    @Override
                    protected TabFragment newInstance() {
                        return GripTabFragment.newInstance(mBasics.data.get(1));
                    }
                },
                new TabItem(Res.string(R.string.basic_footwork)) {
                    @Override
                    protected TabFragment newInstance() {
                        return FootworkTabFragment.newInstance(mFootworks);
                    }
                },
                new TabItem(Res.string(R.string.basic_direction)) {
                    @Override
                    protected TabFragment newInstance() {
                        return DirectionTabFragment.newInstance(mBasics.data.get(3));
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
