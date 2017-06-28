package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.red.forteza.R;
import com.red.forteza.data.model.Guard;
import com.red.forteza.ui.adapter.GuardPhotoPagerAdapter;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuardDetailsFragment extends BaseFragment {

    @BindView(R.id.image_guard)
    ImageView guardImage;
    @BindView(R.id.title_guard)
    TextView guardName;
    @BindView(R.id.translation_guard)
    TextView guardTranslation;
    @BindView(R.id.type_guard)
    TextView guardType;
    @BindView(R.id.fiore_text)
    TextView guardFioreText;
    @BindView(R.id.content_guard)
    TextView guardDetails;
    @BindView(R.id.photo_viewpager)
    ViewPager photoViewpager;
    @BindView(R.id.right_arrow)
    ImageView rightArrow;
    @BindView(R.id.left_arrow)
    ImageView leftArrow;

    Guard mGuard;

    public static GuardDetailsFragment newInstance(Bundle arguments) {
        GuardDetailsFragment fragment = new GuardDetailsFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_guard_details;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mGuard = getArguments().getParcelable(Guard.ARG);
        setTitle(mGuard.italianName);

        Glide.with(view.getContext()).load(Res.drawableId(view.getContext(), mGuard.fioreImage)).into(guardImage);
        guardName.setText(mGuard.italianName);
        guardTranslation.setText(mGuard.englishName);
        guardType.setText(mGuard.type);
        guardFioreText.setText(mGuard.fioreQuote);
        guardDetails.setText(Html.fromHtml(mGuard.description));

        photoViewpager.setAdapter(new GuardPhotoPagerAdapter(mGuard.photos));
        photoViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    leftArrow.setVisibility(View.INVISIBLE);
                    rightArrow.setVisibility(View.VISIBLE);
                } else if (position == mGuard.photos.size() - 1) {
                    leftArrow.setVisibility(View.VISIBLE);
                    rightArrow.setVisibility(View.INVISIBLE);
                } else {
                    leftArrow.setVisibility(View.VISIBLE);
                    rightArrow.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.left_arrow)
    protected void previousPage() {
        photoViewpager.setCurrentItem(photoViewpager.getCurrentItem() - 1);
    }

    @OnClick(R.id.right_arrow)
    protected void nextPage() {
        photoViewpager.setCurrentItem(photoViewpager.getCurrentItem() + 1);
    }

}
