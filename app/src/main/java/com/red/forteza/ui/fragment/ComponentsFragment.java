package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.red.forteza.R;
import com.red.forteza.data.api.LocalApi;
import com.red.forteza.ui.adapter.ComponentAdapter;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComponentsFragment extends BaseFragment {

    @BindView(R.id.scrollview_components)
    NestedScrollView componentsScrollview;
    @BindView(R.id.framelayout_components)
    FrameLayout componentsFramelayout;
    @BindView(R.id.image_sword)
    ImageView swordImage;
    @BindView(R.id.recyclerview_components)
    RecyclerView componentsRecycler;

    ComponentAdapter mAdapter;

    public static ComponentsFragment newInstance() {
        return new ComponentsFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_components;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        setTitle(Res.string(R.string.major_components));

        mAdapter = new ComponentAdapter(LocalApi.get().getMajorSwordComponents().components);
        componentsRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        componentsRecycler.setAdapter(mAdapter);

        componentsScrollview.getViewTreeObserver().addOnScrollChangedListener(new ScrollPositionObserver());

    }

    private class ScrollPositionObserver implements ViewTreeObserver.OnScrollChangedListener {

        private int mImageViewHeight;

        public ScrollPositionObserver() {
            mImageViewHeight = getResources().getDimensionPixelSize(R.dimen.sword_image_height);
        }

        @Override
        public void onScrollChanged() {
            int scrollY = Math.min(Math.max(componentsScrollview.getScrollY(), 0), mImageViewHeight);
            swordImage.setTranslationY(scrollY / 2);
        }
    }
}
