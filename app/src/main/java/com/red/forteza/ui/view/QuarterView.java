package com.red.forteza.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.red.forteza.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuarterView extends LinearLayout {

    @BindView(R.id.title_quarter)
    TextView quarterTitle;
    @BindView(R.id.description_quarter)
    TextView quarterDescription;

    public QuarterView(Context context) {
        super(context);
        init();
    }

    public QuarterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        parseAttr(attrs);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_quarter, this, true);
        ButterKnife.bind(this, this);
    }

    private void parseAttr(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CutView,
                0, 0);

        try {
            String name = a.getString(R.styleable.QuarterView_quarter_text);
            quarterTitle.setText(name);

            String translation = a.getString(R.styleable.QuarterView_description_text);
            quarterDescription.setText(translation);

        } finally {
            a.recycle();
        }
    }

    public void setQuarterInfo(String name, String description) {
        quarterTitle.setText(name);
        quarterDescription.setText(Html.fromHtml(description));
    }
}
