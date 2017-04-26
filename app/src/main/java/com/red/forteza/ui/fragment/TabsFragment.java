package com.red.forteza.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.ui.view.SlidingTabLayout;
import com.red.forteza.util.Res;

import java.lang.ref.WeakReference;
import java.util.List;

public abstract class TabsFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private static final int TAB_VIEW_PADDING_DIPS = 16;
    private static final int TAB_VIEW_TEXT_SIZE_SP = 14;

    protected Integer mCurrentPage = null;
    private ViewPager mPager;
    private TabsPagerAdapter mAdapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_tabs;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPager = (ViewPager) view.findViewById(R.id.pager);

        mAdapter = new TabsPagerAdapter(getChildFragmentManager(), getContents());
        mPager.addOnPageChangeListener(this);
        mPager.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mPager.setOffscreenPageLimit(2);
        bindPager(mPager);
        if (mCurrentPage != null) {
            scrollToItem(mCurrentPage, false);
        } else if (mPager.getCurrentItem() == getDefaultItemIndex()) {
            onPageSelected(mPager.getCurrentItem());
        } else {
            mPager.setCurrentItem(getDefaultItemIndex(), false);
        }
    }

    protected int getDefaultItemIndex() {
        return 0;
    }

    protected void scrollToItem(final int inx, boolean withBackStack) {
        if (withBackStack) {
            onNavigateAwayFrom(mPager.getCurrentItem());
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                mPager.setCurrentItem(inx, true);
            }
        });
    }

    protected void onNavigateAwayFrom(int inx) {
        //Stub
    }

    protected abstract List<TabItem> getContents();

    @Override
    public void onPageScrollStateChanged(int state) {
        //Stub
    }

    @Override
    public void onPageSelected(int position) {
        mCurrentPage = position;
        mAdapter.onPageSelected(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        mAdapter.onPageScrolled(position, positionOffset);
    }

    protected View createTabView(Context context, TabItem item) {
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, TAB_VIEW_TEXT_SIZE_SP);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(params);

        textView.setTextColor(Res.color(android.R.color.white));

        int padding = (int) Res.dp(TAB_VIEW_PADDING_DIPS);
        textView.setPadding(padding, padding, padding, padding);

        textView.setText(item.getTitle());
        textView.setTextColor(Res.color(R.color.black));
        return textView;
    }

    protected abstract class TabItem {
        private static final int MODE_TITLE = 0;
        private static final int MODE_ICON = 1;

        private int mode;
        private String mTitle;
        private WeakReference<TabFragment> fragmentRef = new WeakReference<>(null);
        private int mIcon;
        private boolean notifyOnCreate;
        private boolean onScreen;

        public TabItem(String title) {
            mTitle = title;
            mode = MODE_TITLE;
        }

        public TabItem(int mIcon) {
            this.mIcon = mIcon;
            mode = MODE_ICON;
        }

        protected abstract TabFragment newInstance();

        public TabFragment getContent() {
            TabFragment fragment = fragmentRef.get();
            if (fragment == null) {
                fragment = newInstance();
                fragmentRef = new WeakReference<>(fragment);
                if (notifyOnCreate) {
                    fragment.onScreenStateChanged(onScreen);
                }
            }
            return fragment;

        }

        public void onScrolled(float scroll) {
            TabFragment fragment = fragmentRef.get();
            if (fragment != null) {
                fragment.onPageScrolled(scroll);
            }
        }

        public String getTitle() {
            return TextUtils.isEmpty(mTitle) ? "BROKEN" : mTitle;
        }

        public int getIcon() {
            return mIcon;
        }

        public void onScreenStateChanged(boolean onScreen) {
            TabFragment fragment = fragmentRef.get();
            if (fragment != null) {
                fragment.onScreenStateChanged(onScreen);
            } else {
                notifyOnCreate = true;
                this.onScreen = onScreen;
            }
        }
    }

    public class TabsPagerAdapter extends FragmentStatePagerAdapter implements SlidingTabLayout.TabFactory {

        private List<TabItem> mTabItems;

        public TabsPagerAdapter(FragmentManager fragmentManager, List<TabItem> items) {
            super(fragmentManager);
            mTabItems = items;
            notifyDataSetChanged();
        }

        @Override
        public Fragment getItem(int position) {
            return mTabItems.get(position).getContent();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabItems.get(position).getTitle();
        }

        @Override
        public int getCount() {
            return mTabItems.size();
        }

        public void onPageScrolled(int position, float positionOffset) {
            mTabItems.get(position).onScrolled(-positionOffset);
            if (mTabItems.size() > position + 1) {
                mTabItems.get(position + 1).onScrolled(1 - positionOffset);
            }
        }


        @Override
        public View getTabView(Context context, int i) {
            return createTabView(context, mTabItems.get(i));
        }

        public void onPageSelected(int position) {
            for (int i = 0; i < mTabItems.size(); i++) {
                mTabItems.get(i).onScreenStateChanged(i == position);
            }
        }
    }
}
