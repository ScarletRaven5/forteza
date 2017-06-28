package com.red.forteza.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.red.forteza.R;

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
        int id = getResources().getIdentifier(imageName, "drawable", getPackageName());
        imageView.setImageResource(id);
    }
}
