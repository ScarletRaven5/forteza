package com.red.forteza.ui.activity;

import android.os.Bundle;

import com.red.forteza.R;
import com.red.forteza.ui.fragment.IntroductionFragment;
import com.red.forteza.util.Res;

public class IntroductionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackNavigation();
        setTitle(Res.string(R.string.introduction));
        setContent(IntroductionFragment.newInstance());
    }
}

