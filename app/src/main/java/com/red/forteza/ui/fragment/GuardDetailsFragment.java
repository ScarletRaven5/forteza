package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.red.forteza.R;
import com.red.forteza.data.model.Guard;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuardDetailsFragment extends BaseFragment {

    @BindView(R.id.image_guard)
    ImageView guardImage;
    @BindView(R.id.title_guard)
    TextView guardName;
    @BindView(R.id.content_guard)
    TextView guardDetails;

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
        Glide.with(view.getContext()).load(Res.drawableId(view.getContext(), mGuard.imageRefId)).into(guardImage);
        guardName.setText(mGuard.italianName);
        setTitle(mGuard.italianName);
        guardDetails.setText(Html.fromHtml(mGuard.description));
    }
}
