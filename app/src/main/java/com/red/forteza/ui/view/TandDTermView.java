package com.red.forteza.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.red.forteza.R;
import com.red.forteza.util.CircleTransform;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TandDTermView extends RelativeLayout {


    @BindView(R.id.text_term)
    TextView mTerm;
    @BindView(R.id.text_meaning)
    TextView mMeaning;
    @BindView(R.id.image_term)
    ImageView mTermImage;

    public TandDTermView(Context context) {
        super(context);
        init();
    }

    public TandDTermView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        parseAttr(attrs);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_t_and_d_term, this, true);
        ButterKnife.bind(this, this);
    }

    private void parseAttr(AttributeSet attrs) {

        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TandDTermView,
                0, 0);

        try {
            String term = a.getString(R.styleable.TandDTermView_term);
            mTerm.setText(term);
            String meaning = a.getString(R.styleable.TandDTermView_meaning);
            mMeaning.setText(meaning);
            int imgRef= a.getResourceId(R.styleable.TandDTermView_image, 0);
            Glide.with(getContext()).load(imgRef).transform(new CircleTransform(getContext())).into(mTermImage);
        } finally {
            a.recycle();
        }
    }

    public void setTermInfo(String term, String meaning, String imgRef) {
        mTerm.setText(term);
        mMeaning.setText(meaning);
        Glide.with(getContext()).load(Res.drawableId(getContext(), imgRef)).transform(new CircleTransform(getContext())).into(mTermImage);
    }
}
