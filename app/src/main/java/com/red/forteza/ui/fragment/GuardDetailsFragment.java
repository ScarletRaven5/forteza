package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.data.model.Guard;
import com.red.forteza.util.Res;
import com.squareup.picasso.Picasso;

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
        Picasso.with(view.getContext()).load(Res.drawableId(view.getContext(), mGuard.guardImage)).into(guardImage);
        guardName.setText(mGuard.italianGuardName);
        setTitle(mGuard.italianGuardName);
        guardDetails.setText(Res.string(R.string.lorem_ipsum));
    }
}
