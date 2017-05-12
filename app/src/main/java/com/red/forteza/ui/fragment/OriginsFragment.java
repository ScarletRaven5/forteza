package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.data.model.OriginItems;
import com.red.forteza.ui.activity.ComponentsActivity;
import com.red.forteza.ui.activity.TextyActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OriginsFragment extends BaseFragment {

    OriginItems mOriginItems;

    public static OriginsFragment newInstance() {
        return new OriginsFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_origins;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mOriginItems = LocalApi.get().getOriginItems();
    }

    @OnClick(R.id.button_origin)
    protected void goToOrigin() {
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", mOriginItems.data.get(0).section);
        bundle.putParcelableArrayList("TEXT", mOriginItems.data.get(0).paragraphs);
        startActivity(TextyActivity.class, bundle, false);
    }

    @OnClick(R.id.button_evolution)
    protected void goToEvolution() {
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", mOriginItems.data.get(1).section);
        bundle.putParcelableArrayList("TEXT", mOriginItems.data.get(1).paragraphs);
        startActivity(TextyActivity.class, bundle, false);
    }

    @OnClick(R.id.button_anatomy)
    protected void goToAnatomy() {
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", mOriginItems.data.get(2).section);
        bundle.putParcelableArrayList("TEXT", mOriginItems.data.get(2).paragraphs);
        startActivity(TextyActivity.class, bundle, false);
    }

    @OnClick(R.id.button_major_components)
    protected void goToComponents() {
        startActivity(ComponentsActivity.class, null, false);
    }
}
