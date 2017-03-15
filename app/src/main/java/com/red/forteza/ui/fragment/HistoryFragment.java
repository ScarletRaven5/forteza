package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.red.forteza.App;
import com.red.forteza.R;
import com.red.forteza.util.Prefs;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryFragment extends BaseFragment {

    @BindView(R.id.image_weapon)
    ImageView weaponImage;
    @BindView(R.id.title_history)
    TextView title;
    @BindView(R.id.content_history)
    TextView content;

    String weaponType = Prefs.getWeaponType();

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_history;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        getActivity().setTitle(Res.string(R.string.nav_origin));


        switch (weaponType){
            case "longsword":
                weaponImage.setImageDrawable(Res.drawable(R.drawable.longsword));
                title.setText(Res.string(R.string.title_history_longsword));
                content.setText(Res.string(R.string.lorem_ipsum));
                break;
            case "rapier":
                weaponImage.setImageDrawable(Res.drawable(R.drawable.rapier));
                title.setText(Res.string(R.string.title_history_rapier));
                content.setText(Res.string(R.string.lorem_ipsum));
                break;
            case "other":
                weaponImage.setImageDrawable(Res.drawable(R.drawable.polearm));
                title.setText(Res.string(R.string.title_history_other));
                content.setText(Res.string(R.string.lorem_ipsum));
                break;
        }

    }
}
