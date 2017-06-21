package com.red.forteza.ui.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.ui.activity.ImageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CutView extends LinearLayout {

    @BindView(R.id.cut_name)
    TextView cutName;
    @BindView(R.id.cut_translation)
    TextView cutTranslation;
    @BindView(R.id.cut_meaning)
    TextView cutMeaning;
    @BindView(R.id.cut_image)
    ImageView cutImage;
    @BindView(R.id.image_zoom)
    ImageView zoomImage;

    String imageRef;
    String imageName;

    public CutView(Context context) {
        super(context);
        init();
    }

    public CutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        parseAttr(attrs);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_cut, this, true);
        ButterKnife.bind(this, this);
    }

    private void parseAttr(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CutView,
                0, 0);

        try {
            String name = a.getString(R.styleable.CutView_name_text);
            cutName.setText(name);

            String translation = a.getString(R.styleable.CutView_translation_text);
            cutTranslation.setText(translation);

            String meaning = a.getString(R.styleable.CutView_meaning_text);
            cutMeaning.setText(meaning);

            Drawable image = a.getDrawable(R.styleable.CutView_cut_image);
            imageRef = a.getString(R.styleable.CutView_cut_image);

            if (imageRef != null) {
                imageName = imageRef.substring(imageRef.lastIndexOf("/") + 1, imageRef.lastIndexOf("."));
            } else {
                zoomImage.setVisibility(GONE);
            }

            cutImage.setImageDrawable(image);
        } finally {
            a.recycle();
        }
    }

    public void setCutInfo(String name, String translation, String meaning) {
        cutName.setText(name);
        if (translation.isEmpty()) {
            cutTranslation.setVisibility(GONE);
        } else {
            cutTranslation.setText(translation);
        }
        cutMeaning.setText(Html.fromHtml(meaning));
    }

    @OnClick(R.id.cut_image)
    protected void clickCut() {
        if (imageName != null) {
            Intent intent = new Intent(getContext(), ImageActivity.class);
            intent.putExtra("REF", imageName);
            getContext().startActivity(intent);
        }
    }
}
