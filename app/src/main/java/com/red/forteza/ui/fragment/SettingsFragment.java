package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.red.forteza.R;
import com.red.forteza.util.Prefs;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsFragment extends BaseFragment {

    @BindView(R.id.group_weapon)
    RadioGroup weaponGroup;
    @BindView(R.id.option_longsword)
    RadioButton longswordOption;
    @BindView(R.id.option_rapier)
    RadioButton rapierOption;
    @BindView(R.id.option_other)
    RadioButton otherOption;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_settings;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        String weapon = Prefs.getWeaponType();

        if (Res.string(R.string.rapier).equals(weapon)) {
            rapierOption.setChecked(true);
        } else if (Res.string(R.string.other).equals(weapon)) {
            otherOption.setChecked(true);
        } else {
            longswordOption.setChecked(true);
        }

        weaponGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);

                switch (index) {
                    case 0:
                        Prefs.setWeaponType(Res.string(R.string.longsword));
                        break;
                    case 1:
                        Prefs.setWeaponType(Res.string(R.string.rapier));
                        break;
                    case 2:
                        Prefs.setWeaponType(Res.string(R.string.other));
                        break;
                }

            }
        });

    }
}
