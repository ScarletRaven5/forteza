package com.red.forteza.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.red.forteza.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BasicsView extends RelativeLayout {

    @BindView(R.id.image_background)
    ImageView backgroundImage;
    @BindView(R.id.image_icon)
    ImageView iconImage;
    @BindView(R.id.label_title)
    TextView title;


    public BasicsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(this);
        LayoutInflater.from(context).inflate(R.layout.view_basics, this, true);


        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.BasicsView,
                0, 0);

        try {
            int icon = a.getResourceId(R.styleable.BasicsView_iconImage, 0);
            Glide.with(getContext()).load(icon).into(iconImage);
            int background = a.getResourceId(R.styleable.BasicsView_backgroundImage, 0);
            Glide.with(getContext()).load(background).into(backgroundImage);
            String name = a.getString(R.styleable.BasicsView_name);
            title.setText(name);
        } finally {
            a.recycle();
        }
    }
}
