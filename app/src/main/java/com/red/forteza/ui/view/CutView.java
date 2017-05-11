package com.red.forteza.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.red.forteza.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CutView extends LinearLayout {

    @BindView(R.id.cut_name)
    TextView cutName;
    @BindView(R.id.cut_translation)
    TextView cutTranslation;
    @BindView(R.id.cut_meaning)
    TextView cutMeaning;

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
        } finally {
            a.recycle();
        }
    }

    public void setCutInfo(String name, String translation, String meaning) {
        cutName.setText(name);
        cutTranslation.setText(translation);
        cutMeaning.setText(meaning);
    }
}
