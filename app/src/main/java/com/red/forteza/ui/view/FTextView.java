package com.red.forteza.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.red.forteza.R;
import com.red.forteza.util.TypefaceManager;

public class FTextView extends AppCompatTextView {

    public FTextView(Context context) {
        super(context);
    }

    public FTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.FTextView,
                0, 0);

        try {
            String font = a.getString(R.styleable.FTextView_font);
           // if (!TextUtils.isEmpty(font)) {
                setFont(TextUtils.isEmpty(font) ? "Fontin-Regular" : font);
            //}

            float size = a.getDimension(R.styleable.FTextView_size, 16);
            setTextSize(TypedValue.COMPLEX_UNIT_PX, size == 16 ? getResources().getDimension(R.dimen.font_size) : size);

            setLineSpacing(getResources().getDimension(R.dimen.line_spacing), 1);

        } finally {
            a.recycle();
        }
    }

    public void setFont(String font) {
        setTypeface(TypefaceManager.getTypeface(font, getContext()));

    }
}
