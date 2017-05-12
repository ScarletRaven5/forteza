package com.red.forteza.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.red.forteza.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends BaseActivity {

    @BindView(R.id.image)
    ImageView imageView;

    String imageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackNavigation();
        ButterKnife.bind(this, setContent(R.layout.activity_image));

        imageRef = getIntent().getStringExtra("REF");
        //imageView.setImageDrawable(getResources().getdrawable());
    }
}
