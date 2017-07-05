package com.red.forteza.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.red.forteza.R;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends BaseActivity {

    @BindView(R.id.image)
    ImageView imageView;

    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackNavigation();
        ButterKnife.bind(this, setContent(R.layout.activity_image));

        imageName = getIntent().getStringExtra("REF");
        Glide.with(this).load(Res.drawableId(this, imageName)).into(imageView);
    }
}
